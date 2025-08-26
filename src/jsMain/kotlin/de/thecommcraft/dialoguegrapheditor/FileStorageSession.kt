package de.thecommcraft.dialoguegrapheditor

import js.errors.SyntaxError
import js.objects.unsafeJso
import js.uri.encodeURIComponent
import js.function.async
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withTimeout
import web.events.addHandler
import web.sockets.WebSocket
import web.http.*
import web.sockets.closeEvent
import web.url.URL
import web.url.URLSearchParams
import seskar.js.JsValue
import web.crypto.crypto
import web.sockets.messageEvent
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

external class FileContent {
    var content: String
}

interface FileStorageSession {
    val pushControlSession: FileStoragePushControlSession?
    fun changeTarget(newFileTarget: String)
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

    override fun changeTarget(newFileTarget: String) {
        fileTarget = newFileTarget
        previousData = ""
    }

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

object WSTimeout

class MyResult<A, B>(val result: A?, val problem: B? = null) {
    companion object {
        inline fun<reified T: Throwable, A> tryCatch(block: () -> A): MyResult<A, T> {
            return try {
                MyResult(block())
            } catch (exc: Throwable) {
                if (exc is T) MyResult(null, exc)
                else throw exc
            }
        }
    }

    fun<C> ifSuccess(block: (A?) -> C?): MyResult<C, B> {
        if (problem != null) return MyResult(null, problem)
        return MyResult(block(result), null)
    }

    suspend fun<C> ifSuccessSuspend(block: suspend (A?) -> C?): MyResult<C, B> {
        if (problem != null) return MyResult(null, problem)
        return MyResult(block(result), null)
    }

    fun<C> ifNonNullSuccess(block: (A) -> C): MyResult<C, B> = ifSuccess {
        it?.let(block)
    }

    suspend fun<C> ifNonNullSuccessSuspend(block: suspend (A) -> C): MyResult<C, B> = ifSuccessSuspend {
        if (it == null) return@ifSuccessSuspend null
        block(it)
    }

    fun handle(block: (B) -> A?): MyResult<A, B> {
        if (problem == null) return MyResult(result, null)
        return MyResult(block(problem), null)
    }

    suspend fun handleSuspend(block: suspend (B) -> A?): MyResult<A, B> {
        if (problem == null) return MyResult(result, null)
        return MyResult(block(problem), null)
    }

    fun handle(block: (B) -> MyResult<A, B>): MyResult<A, B> {
        if (problem == null) return MyResult(result, null)
        return block(problem)
    }

    suspend fun handleSuspend(block: suspend (B) -> MyResult<A, B>): MyResult<A, B> {
        if (problem == null) return MyResult(result, null)
        return block(problem)
    }

    fun handleNotNull(block: (B) -> A?): MyResult<A, B> {
        val resolved = handle(block)
        resolved.result?.let {
            return resolved
        }
        return this
    }

    suspend fun handleNotNullSuspend(block: suspend (B) -> A?): MyResult<A, B> {
        val resolved = handleSuspend(block)
        resolved.result?.let {
            return resolved
        }
        return this
    }

    fun<C> ifProblem(block: (B) -> C): MyResult<A, C> {
        if (problem == null) return MyResult(result, null)
        return MyResult(null, block(problem))
    }

    suspend fun<C> ifProblemSuspend(block: suspend (B) -> C): MyResult<A, C> {
        if (problem == null) return MyResult(result, null)
        return MyResult(null, block(problem))
    }
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

    override fun changeTarget(newFileTarget: String) {
        fileTarget = newFileTarget
        previousData = ""
    }

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
        })[1].ifProblemSuspend {
            write(currentData)
            null
        }
    }

    private fun makeTryWrite(data: String): suspend (WSTimeout?) -> MyResult<WSFileStorageSessionMessage, WSTimeout> = {
        executeCommand {
            commandType = WSFileStorageSessionCommandType.WRITE
            fileTarget = this@WSFileStorageSession.fileTarget
            content = data
        }
    }

    override suspend fun write(data: String) {
        if (data == previousData) return
        previousData = data
        val tryWrite = makeTryWrite(data)
        tryWrite(null)
            .handleSuspend(tryWrite)
            .handleSuspend(tryWrite)
            .handleSuspend(tryWrite)
    }

    private suspend fun tryRead(problem: WSTimeout? = null): MyResult<WSFileStorageSessionMessage, WSTimeout> = executeCommand {
        commandType = WSFileStorageSessionCommandType.READ
        fileTarget = this@WSFileStorageSession.fileTarget
    }

    override suspend fun read(): String {
        val response = tryRead()
            .handleSuspend(::tryRead)
            .handleSuspend(::tryRead)
            .handleSuspend(::tryRead)
        return response.result?.content ?: ""
    }

    private suspend fun receiveFiltered(filter: WSFileStorageSessionMessage.() -> Boolean): WSFileStorageSessionMessage {
        while (true) {
            val message = dataReception.receive()
            if (message.filter()) return message
        }
    }

    private suspend fun executeCommand(
        timeout: Duration = 5.seconds,
        commandBuilder: WSFileStorageSessionCommand.() -> Unit
    ): MyResult<WSFileStorageSessionMessage, WSTimeout> {
        val command = unsafeJso<WSFileStorageSessionCommand> {
            identifier = crypto.randomUUID()
            commandBuilder()
        }
        val encodedCommand = JSON.stringify(command)+"\n"
        return MyResult.tryCatch<TimeoutCancellationException, WSFileStorageSessionMessage> {
            withTimeout(timeout) {
                executingCommands.withLock {
                    webSocket.send(encodedCommand)
                    receiveFiltered { messageType == WSFileStorageSessionMessageType.RESPONSE && identifier == command.identifier }
                }
            }
        }.ifProblemSuspend { WSTimeout }
    }

    private suspend fun executeBatchedCommands(amount: Int, timeout: Duration = 10.seconds, commandBuilder: WSFileStorageSessionCommand.(Int) -> Unit): List<MyResult<WSFileStorageSessionMessage, WSTimeout>> {
        return executeBatchedCommands(sequence {
            (0..<amount).forEach { idx -> yield(unsafeJso { commandBuilder(idx) }) }
        }, timeout)
    }

    private suspend fun executeBatchedCommands(commands: Sequence<WSFileStorageSessionCommand>, timeout: Duration = 10.seconds): List<MyResult<WSFileStorageSessionMessage, WSTimeout>> {
        val commandList = commands.toList().apply {
            forEach {
                it.identifier = crypto.randomUUID()
            }
        }
        val responseMap: MutableMap<String, WSFileStorageSessionMessage?> = commands.map { it.identifier to null }.toMap().toMutableMap()
        val encodedCommands = commandList.joinToString("\n", transform = JSON::stringify)+"\n"
        executingCommands.withLock {
            webSocket.send(encodedCommands)
            try {
                withTimeout(timeout) {
                    repeat(commandList.size) {
                        val msg = receiveFiltered { messageType == WSFileStorageSessionMessageType.RESPONSE }
                        if (msg.identifier !in responseMap) return@repeat
                        msg.identifier?.let {
                            responseMap[it] = msg
                        }
                    }
                }
            } catch (_: TimeoutCancellationException) { }
            return responseMap.values.map {
                it?.let(::MyResult) ?: MyResult(null, WSTimeout)
            }
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
            encodedMessage.lines().forEach {
                val message = try {
                    JSON.parse<WSFileStorageSessionMessage>(it)
                } catch (exc: SyntaxError) {
                    return@forEach
                }
                async { ->
                    dataReception.send(message)
                }()
            }
        }
    }
}

infix fun URL.params(params: String) = URL("?$params", this)

operator fun URL.div(endPoint: String) = URL(encodeURIComponent(endPoint.slice(0..<endPoint.lastIndex ))+endPoint.last(), this.toString().removeSuffix("/")+"/")