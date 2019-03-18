package org.ksviety.shizaproject.app.api.core

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

const val AGENT_NAME: String = "Shiza-project API"
const val API_VERSION: String = "1.0"
const val AUTHOR: String = "Ksviety"

fun getDocument(url: String): Document {
    var html: String = ""

    try {

        val connection: HttpURLConnection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty("User-Agent", "$AGENT_NAME/$API_VERSION by $AUTHOR (JVM)")

        html = connection.inputStream.bufferedReader().readText()

    } catch (e: Exception) {}

    return Jsoup.parse(html, Pages.HOME)
}