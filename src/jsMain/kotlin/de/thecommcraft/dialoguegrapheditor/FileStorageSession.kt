package de.thecommcraft.dialoguegrapheditor

import js.array.tupleOf
import js.objects.unsafeJso
import js.uri.encodeURIComponent
import web.http.*
import web.streams.ReadableStreamReadResult
import web.streams.read
import web.url.URL

class FileContent(var content: String)


class RawCredentials(
    var data_access_token: String,
    var manual_update_token: String
)

class FileStorageSession(
    val serverBaseUrl: URL,
    var fileTarget: String,
    val dataAccessToken: String,
    val manualUpdateToken: String? = null
) {
    suspend fun write(data: String) {
        fetch(serverBaseUrl / "files" / fileTarget, RequestInit(
            method = RequestMethod.PUT,
            body = BodyInit(JSON.stringify(unsafeJso<FileContent> {
                content = data
            })),
            headers = makeHeaders()
        ))
    }

    suspend fun read(data: String): String {
        val response = fetch(serverBaseUrl / "files" / fileTarget, RequestInit(
            method = RequestMethod.GET,
            headers = makeHeaders()
        ))
        val out = response.json()
        val fileContent = out.unsafeCast<FileContent>()
        return fileContent.content
    }

    suspend fun forcePush() {
        fetch(serverBaseUrl / "save_data/", RequestInit(
            method = RequestMethod.POST,
            headers = makeHeaders()
        ))
    }

    private fun makeHeaders() = Headers(arrayOf(
        tupleOf("Content-Type", "application/json"),
        tupleOf("Cookie", JSON.stringify(unsafeJso<RawCredentials> {
            data_access_token = dataAccessToken
            manualUpdateToken?.let {
                manual_update_token = it
            }
        }))
    ))
}

operator fun URL.div(endPoint: String) = URL(encodeURIComponent(endPoint.slice(0..<endPoint.lastIndex ))+endPoint.last(), this.toString().removeSuffix("/")+"/")