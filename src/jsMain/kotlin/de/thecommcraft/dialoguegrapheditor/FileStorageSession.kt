package de.thecommcraft.dialoguegrapheditor

import js.array.tupleOf
import js.objects.unsafeJso
import js.uri.encodeURIComponent
import web.http.*
import web.streams.ReadableStreamReadResult
import web.streams.read
import web.url.URL
import web.url.URLSearchParams

external class FileContent {
    var content: String
}


external class RawCredentials {
    var data_access_token: String
    var manual_update_token: String
}

class FileStorageSession(
    val serverBaseUrl: URL,
    var fileTarget: String,
    val dataAccessToken: String,
    val manualUpdateToken: String? = null
) {
    private var previousData = ""
    suspend fun write(data: String) {
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

    suspend fun read(data: String): String {
        val response = fetch(serverBaseUrl / "files" / fileTarget params makeParams(), RequestInit(
            method = RequestMethod.GET,
            headers = makeHeaders()
        ))
        val out = response.json()
        val fileContent = out.unsafeCast<FileContent>()
        return fileContent.content
    }

    suspend fun forcePush() {
        fetch(serverBaseUrl / "save_data/" params makeParams(), RequestInit(
            method = RequestMethod.POST,
            headers = makeHeaders(),
        ))
    }

    private fun makeParams(): String {
        val params = URLSearchParams()
        params.append("data_access_token", dataAccessToken)
        manualUpdateToken?.let {
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

infix fun URL.params(params: String) = URL(params, this)

operator fun URL.div(endPoint: String) = URL(encodeURIComponent(endPoint.slice(0..<endPoint.lastIndex ))+endPoint.last(), this.toString().removeSuffix("/")+"/")