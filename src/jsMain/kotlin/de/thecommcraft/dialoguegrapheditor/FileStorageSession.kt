package de.thecommcraft.dialoguegrapheditor

import js.objects.unsafeJso
import js.uri.encodeURIComponent
import js.function.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import web.events.addHandler
import web.sockets.WebSocket
import web.http.*
import web.sockets.closeEvent
import web.url.URL
import web.url.URLSearchParams
import seskar.js.JsValue
import web.crypto.crypto
import web.sockets.messageEvent

external class FileContent {
    var content: String
}

interface FileStorageSession {
    val pushControlSession: FileStoragePushControlSession?
    suspend fun rename(newFileTarget: String)
    suspend fun write(data: String)
    suspend fun read(): String
}

interface FileStoragePushControlSession {
    suspend fun forcePush()
}

class HTTPFileStoragePushControlSession(val serverBaseUrl: URL, val manualUpdateToken: String) : FileStoragePushControlSession {
    override suspend fun forcePush() {
        fetch(serverBaseUrl / "save_data/" params makeParams(), RequestInit(
            method = RequestMethod.POST,
            headers = makeHeaders(),
        ))
    }
    private fun makeParams(): String {
        val params = URLSearchParams()
        manualUpdateToken.let {
            params.append("manual_update_token", manualUpdateToken)
        }
        return params.toString()
    }

    private fun makeHeaders(): Headers {
        val headers = Headers()
        headers.append("Content-Type", "application/json")
        return headers
    }
}

class HTTPFileStorageSession(
    val serverBaseUrl: URL,
    private var fileTarget: String,
    val dataAccessToken: String,
    override val pushControlSession: FileStoragePushControlSession? = null
) : FileStorageSession {
    val currentFileTarget: String by ::fileTarget
    private var previousData = ""

    override suspend fun rename(newFileTarget: String) {
        val currentData = read()
        write("")
        fileTarget = newFileTarget
        write(currentData)
    }

    override suspend fun write(data: String) {
        if (data == previousData) return
        previousData = data
        fetch(serverBaseUrl / "files" / fileTarget params makeParams(), RequestInit(
            method = RequestMethod.PUT,
            body = BodyInit(JSON.stringify(unsafeJso<FileContent> {
                content = data
            })),
            headers = makeHeaders()
        ))
    }

    override suspend fun read(): String {
        val response = fetch(serverBaseUrl / "files" / fileTarget params makeParams(), RequestInit(
            method = RequestMethod.GET,
            headers = makeHeaders()
        ))
        val out = response.json()
        val fileContent = out.unsafeCast<FileContent>()
        return fileContent.content
    }

    private fun makeParams(): String {
        val params = URLSearchParams()
        params.append("data_access_token", dataAccessToken)
        return params.toString()
    }

    private fun makeHeaders(): Headers {
        val headers = Headers()
        headers.append("Content-Type", "application/json")
        return headers
    }
}

sealed external interface WSFileStorageSessionCommandType {
    companion object {
        @JsValue("write")
        val WRITE: WSFileStorageSessionCommandType

        @JsValue("read")
        val READ: WSFileStorageSessionCommandType

        @JsValue("query")
        val QUERY: WSFileStorageSessionCommandType
    }
}

external class WSFileStorageSessionCommand {
    @JsName("command_type")
    var commandType: WSFileStorageSessionCommandType
    @JsName("file_target")
    var fileTarget: String
    var identifier: String
    var content: String?
}

sealed external interface WSFileStorageSessionMessageType {
    companion object {
        @JsValue("write")
        val WRITE: WSFileStorageSessionMessageType

        @JsValue("read")
        val READ: WSFileStorageSessionMessageType

        @JsValue("save")
        val SAVE: WSFileStorageSessionMessageType

        @JsValue("force_save")
        val FORCE_SAVE: WSFileStorageSessionMessageType

        @JsValue("response")
        val RESPONSE: WSFileStorageSessionMessageType

        @JsValue("handshake")
        val HANDSHAKE: WSFileStorageSessionMessageType
    }
}

external class WSFileStorageSessionMessage {
    @JsName("message_type")
    var messageType: WSFileStorageSessionMessageType
    var actor: String?
    @JsName("file_target")
    var fileTarget: String?
    var identifier: String?
    var content: String?
    var timestamp: Double
}

class WSFileStorageSession(
    serverBaseUrl: URL,
    private var fileTarget: String,
    val dataAccessToken: String,
    override val pushControlSession: FileStoragePushControlSession? = null
) : FileStorageSession {
    private val wsUri = serverBaseUrl / "ws" params makeParams()
    init {
        wsUri.protocol = "wss"
    }
    private var webSocket = makeWebSocket()
    val currentFileTarget: String by ::fileTarget
    private var dataReception = Channel<WSFileStorageSessionMessage>()
    private var previousData = ""
    private var executingCommands = Mutex()

    override suspend fun rename(newFileTarget: String) {
        val currentData = read()
        executeBatchedCommands(sequence {
            yield(unsafeJso {
                commandType = WSFileStorageSessionCommandType.WRITE
                fileTarget = this@WSFileStorageSession.fileTarget
                content = ""
            })
            fileTarget = newFileTarget
            yield(unsafeJso {
                commandType = WSFileStorageSessionCommandType.WRITE
                fileTarget = this@WSFileStorageSession.fileTarget
                content = currentData
            })
        })
    }

    override suspend fun write(data: String) {
        if (data == previousData) return
        previousData = data
        executeCommand {
            commandType = WSFileStorageSessionCommandType.WRITE
            fileTarget = this@WSFileStorageSession.fileTarget
            content = data
        }
    }

    override suspend fun read(): String {
        val response = executeCommand {
            commandType = WSFileStorageSessionCommandType.READ
            fileTarget = this@WSFileStorageSession.fileTarget
        }
        return response.content ?: ""
    }

    private suspend fun receiveFiltered(filter: WSFileStorageSessionMessage.() -> Boolean): WSFileStorageSessionMessage {
        while (true) {
            val message = dataReception.receive()
            if (message.filter()) return message
        }
    }

    private suspend fun executeCommand(commandBuilder: WSFileStorageSessionCommand.() -> Unit): WSFileStorageSessionMessage {
        val command = unsafeJso<WSFileStorageSessionCommand> {
            identifier = crypto.randomUUID()
            commandBuilder()
        }
        val encodedCommand = JSON.stringify(command)+"\n"
        executingCommands.withLock {
            webSocket.send(encodedCommand)
            return receiveFiltered { messageType == WSFileStorageSessionMessageType.RESPONSE }
        }
    }

    private suspend fun executeBatchedCommands(amount: Int, commandBuilder: WSFileStorageSessionCommand.(Int) -> Unit): List<WSFileStorageSessionMessage> {
        return executeBatchedCommands(sequence {
            (0..<amount).forEach { idx -> yield(unsafeJso { commandBuilder(idx) }) }
        })
    }

    private suspend fun executeBatchedCommands(commands: Sequence<WSFileStorageSessionCommand>): List<WSFileStorageSessionMessage> {
        val commandList = commands.toList()
        val responseMap = commands.map { it.identifier to unsafeJso<WSFileStorageSessionMessage>() }.toMap().toMutableMap()
        val encodedCommands = commandList.joinToString("\n", transform = JSON::stringify)+"\n"
        executingCommands.withLock {
            webSocket.send(encodedCommands)
            repeat(commandList.size) {
                val msg = receiveFiltered { messageType == WSFileStorageSessionMessageType.RESPONSE }
                if (msg.identifier !in responseMap) return@repeat
                msg.identifier?.let {
                    responseMap[it] = msg
                }
            }
            return responseMap.values.toList()
        }
    }

    private fun makeParams(): String {
        val params = URLSearchParams()
        params.append("data_access_token", dataAccessToken)
        return params.toString()
    }

    private fun makeWebSocket(): WebSocket = WebSocket(wsUri).apply {
        closeEvent.addHandler {
            webSocket = makeWebSocket()
        }
        messageEvent.addHandler { event ->
            val encodedMessage = event.data as String
            val message = JSON.parse(encodedMessage) as WSFileStorageSessionMessage
            async { ->
                dataReception.send(message)
            }()
        }
    }
}

infix fun URL.params(params: String) = URL("?$params", this)

operator fun URL.div(endPoint: String) = URL(encodeURIComponent(endPoint.slice(0..<endPoint.lastIndex ))+endPoint.last(), this.toString().removeSuffix("/")+"/")