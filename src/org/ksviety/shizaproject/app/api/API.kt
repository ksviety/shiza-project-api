package org.ksviety.shizaproject.app.api

import org.ksviety.shizaproject.app.api.core.Pages
import org.ksviety.shizaproject.app.api.core.getDocument
import org.ksviety.shizaproject.app.api.core.parser.getReleaseBoxesList
import org.ksviety.shizaproject.app.api.core.parser.getStatusPageCurrentIndex
import org.ksviety.shizaproject.app.api.core.parser.getStatusPageLastIndex
import org.ksviety.shizaproject.app.api.pojo.pages.StatusPage

fun getStatusPage(page: Pages): StatusPage {
    val document = getDocument(page.toString())
    val mainContent = document.getElementsByClass("main-content").first()
    val nav = mainContent.getElementsByAttributeValue("role", "navigation").first()

    return StatusPage(
        getStatusPageCurrentIndex(nav),
        getStatusPageLastIndex(nav),
        getReleaseBoxesList(mainContent)
    )
}
