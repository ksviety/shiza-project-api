package org.ksviety.shizaproject.app.api

import org.ksviety.shizaproject.app.api.core.DOMAIN
import org.ksviety.shizaproject.app.api.core.Pages
import org.ksviety.shizaproject.app.api.core.getDocument
import org.ksviety.shizaproject.app.api.core.parser.*
import org.ksviety.shizaproject.app.api.pojo.pages.SearchPage
import org.ksviety.shizaproject.app.api.pojo.pages.StatusPage

fun getStatusPage(page: Pages): StatusPage {
    val document = getDocument(page.toString())
    val mainContent = document.getElementsByClass("main-content").first()
    val nav = mainContent.getElementsByAttributeValue("role", "navigation").first()

    return StatusPage(
        getStatusPageCurrentIndex(nav),
        getStatusPageLastIndex(nav),
        getReleaseBoxesListOnStatus(mainContent)
    )
}

fun getSearchPage(request: String): SearchPage {
    val document = getDocument("$DOMAIN/releases/search?q=$request")
    val mainContent = document.getElementsByClass("main-content").first()
    val nav = mainContent.getElementsByAttributeValue("role", "navigation").first()

    return SearchPage(
        request,
        getSearchSuggestion(mainContent),
        getSearchPageIndex(nav),
        getSearchPageLastIndex(nav),
        getReleaseBoxesListOnSearch(mainContent)
    )
}
