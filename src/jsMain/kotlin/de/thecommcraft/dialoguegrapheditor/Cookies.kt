package de.thecommcraft.dialoguegrapheditor

import js.date.Date
import js.uri.decodeURIComponent
import js.uri.encodeURIComponent
import web.dom.document

class Delay private constructor(val milliseconds: Double) {
    companion object {
        fun milliseconds(ms: Double) = Delay(ms)
        fun seconds(seconds: Double) = Delay(seconds * 1000)
        fun minutes(minutes: Double) = seconds(minutes * 60)
        fun hours(hours: Double) = minutes(hours * 60)
        fun days(days: Double) = hours(days * 24)
        fun weeks(weeks: Double) = days(weeks * 7)
        fun months(months: Double) = days(months * 30)
        fun years(years: Double) = days(years * 365.24)
        fun of(
            milliseconds: Double = 0.0,
            seconds: Int = 0,
            minutes: Int = 0,
            hours: Int = 0,
            days: Int = 0,
            weeks: Int = 0,
            months: Int = 0,
            years: Int = 0
        ) = milliseconds(milliseconds) +
            seconds(seconds.toDouble()) +
            minutes(minutes.toDouble()) +
            hours(hours.toDouble()) +
            days(days.toDouble()) +
            weeks(weeks.toDouble()) +
            months(months.toDouble()) +
            years(years.toDouble())
    }
    operator fun plus(delay: Delay) = Delay(milliseconds + delay.milliseconds)
    operator fun minus(delay: Delay) = Delay(milliseconds - delay.milliseconds)
}

object Cookies {
    private val defaults = mutableMapOf<String, Any?>()

    private fun join(vararg args: Any?): Map<String, Any?> {
        val result = mutableMapOf<String, Any?>()
        for (arg in args) {
            if (arg is Map<*, *>) {
                for ((key, value) in arg) {
                    result[key as String] = value
                }
            }
        }
        return result
    }

    private fun decode(value: String): String {
        return decodeURIComponent(value)
    }

    private fun encode(value: String): String {
        return encodeURIComponent(value)
    }

    fun setValue(name: String, value: Any?, options: Map<String, Any?> = emptyMap()) {
        if (value != null) {
            val opts = join(mapOf("path" to "/"), defaults, options)
            val expires = opts["expires"]
            val cookieValue = if (value is String) encode(value) else try {
                JSON.stringify(value)
            } catch (e: Exception) {
                encode(value.toString())
            }
            val encodedName = encode(name)
            val cookieString = StringBuilder("$encodedName=$cookieValue")
            if (expires != null) {
                val expiresDate = expires.let{
                    when (it) {
                        is Date -> it
                        is Delay -> Date(Date.now() + it.milliseconds)
                        is Double -> Date(it)
                        else -> Date("0")
                    }
                }
                cookieString.append("; expires=${expiresDate.toUTCString()}")
            }
            for ((key, optValue) in opts) {
                optValue?.let {
                    cookieString.append("; $key=$it")
                }
            }
            document.cookie = cookieString.toString()
        } else {
            setValue(name, "", join(mapOf("expires" to Date(0.0)), options))
        }
    }

    fun getValue(name: String, json: Boolean = false): Any? {
        val cookies = document.cookie.split("; ")
        for (cookie in cookies) {
            val parts = cookie.split("=")
            val cookieName = decode(parts[0])
            val cookieValue = parts.slice(1..parts.lastIndex).joinToString("=")
            if (cookieName == name) {
                if (json) {
                    return try {
                        JSON.parse(cookieValue)
                    } catch (e: Exception) {
                        decode(cookieValue)
                    }
                }
                return decode(cookieValue)
            }
        }
        return null
    }

    operator fun get(name: String): String? {
        val value = getValue(name)
        value ?: return null
        if (value !is String) return null
        return value
    }

    operator fun set(name: String, value: Any?) {
        return setValue(name, value)
    }

    fun getJSON(name: String): Any? {
        return getValue(name, true)
    }

    fun remove(name: String, options: Map<String, Any?> = emptyMap()) {
        setValue(name, "", join(mapOf("expires" to Date(0.0)), options))
    }
}