package org.ksviety.shizaproject.app.api

import org.ksviety.shizaproject.app.api.core.Pages
import org.ksviety.shizaproject.app.api.core.getDocument
import org.ksviety.shizaproject.app.api.core.parsers.*
import org.ksviety.shizaproject.app.api.pojo.pages.ReleasePage
import org.ksviety.shizaproject.app.api.pojo.pages.SearchPage
import org.ksviety.shizaproject.app.api.pojo.pages.StatusPage

fun getStatusPage(page: String): StatusPage {
    val document = getDocument(page)
    val mainContent = document.getElementsByClass("main-content").first()
    val nav = mainContent.getElementsByAttributeValue("role", "navigation").first()

    return StatusPage(
        getStatusPageCurrentIndex(nav),
        getStatusPageLastIndex(nav),
        getReleaseBoxesListOnStatus(mainContent)
    )
}

fun getSearchPage(request: String, tag: String): SearchPage {
    val document = getDocument("${Pages.HOME}/releases/search?q=$request&t=$tag")
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

fun getReleasePage(url: String): ReleasePage {
    val document = getDocument(url)
    val mainContent = document.getElementsByClass("main-content").first()

    return ReleasePage(
        getReleasePageTitle(mainContent),
        getReleasePageSecondaryDescription(mainContent),
        getReleasePageDescription(mainContent),
        getReleasePageGenres(mainContent),
        getReleasePageImageURL(mainContent),
        getReleasePageVideos(mainContent),
        getReleasePageWorkers(mainContent),
        null
    )
}