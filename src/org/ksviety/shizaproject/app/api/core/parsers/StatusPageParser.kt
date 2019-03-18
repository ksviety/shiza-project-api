package org.ksviety.shizaproject.app.api.core.parsers

import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.ksviety.shizaproject.app.api.pojo.elements.ReleaseBox

fun getReleaseBoxesListOnStatus(main: Element): Array<ReleaseBox> {

    fun getReleaseBox(e: Element): ReleaseBox {
        val imageURL = e.getElementsByTag("img").first().absUrl("src")
        val releasePage = e.getElementsByTag("a").first().absUrl("href")
        val title = e.getElementsByTag("h4").first().text()
        val description = e.getElementsByTag("p").first().text()
        val likes = e.getElementsByClass("info-card__name").first().ownText().toInt()
        val comments = e.getElementsByClass("info-card__name").last().ownText().toInt()
        val status = e.getElementsByClass("relstatus").first().text()

        return ReleaseBox(title, description, imageURL, releasePage, status, likes, comments)
    }

    val gallery: Elements = main.getElementsByClass("gallery-grid").first().children()
    val boxList: ArrayList<ReleaseBox> = ArrayList()

    for (e: Element in gallery)
        boxList.add(getReleaseBox(e))

    return boxList.toTypedArray()
}

fun getStatusPageCurrentIndex(nav: Element): Int {
    return nav.getElementsByClass("active").first().text().toInt()
}

fun getStatusPageLastIndex(nav: Element): Int {
    val ul = nav.getElementsByTag("ul").first()

    return ul.child(ul.children().count()-2).text().toInt()
}
