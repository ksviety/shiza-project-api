package org.ksviety.shizaproject.app.api.core.parser

import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.ksviety.shizaproject.app.api.pojo.elements.SearchReleaseBox

fun getReleaseBoxesListOnSearch(main: Element): Array<SearchReleaseBox> {

    fun getReleaseBox(e: Element): SearchReleaseBox {
        val imageURL = e.getElementsByTag("img").first().absUrl("src")
        val releasePage = e.getElementsByTag("a").last().absUrl("href")
        val title = e.getElementsByClass("card-title").first().text()
        val description = e.getElementsByClass("description").first().text()
        val status = e.getElementsByClass("relstatus").first().text()

        return SearchReleaseBox(title, description, imageURL, releasePage, status)
    }

    val gallery: Elements = main.getElementsByClass("row top-xs").first()
        .getElementsByClass("card")
    val boxList: ArrayList<SearchReleaseBox> = ArrayList()

    for (e: Element in gallery)
        boxList.add(getReleaseBox(e))

    return boxList.toTypedArray()
}

fun getSearchSuggestion(main: Element): String? {
    return main.getElementById("spell").getElementsByTag("a").last().text()
}

fun getSearchPageIndex(nav: Element): Int {
    return nav.getElementsByClass("active").first().text().toInt()
}

fun getSearchPageLastIndex(nav: Element): Int {
    return nav.getElementsByTag("li")[nav.getElementsByTag("li").count()-3].text().toInt()
}