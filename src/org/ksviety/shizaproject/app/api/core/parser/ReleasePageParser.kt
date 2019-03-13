package org.ksviety.shizaproject.app.api.core.parser

import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.ksviety.shizaproject.app.api.pojo.elements.Video
import org.ksviety.shizaproject.app.api.pojo.elements.Worker
import kotlin.NullPointerException

fun getReleasePageTitle(main: Element): String {
    val left = main.child(1)
    return left.getElementsByClass("card-header grad-info text-white").first()
        .getElementsByTag("h3").first().text()
}

fun getReleasePageSecondaryDescription(main: Element): String {
    val left = main.child(1)
    return left.getElementsByClass("card-header grad-info text-white").first()
        .getElementsByTag("p").first().text()
}

fun getReleasePageGenres(main: Element): Array<String> {
    val left = main.child(1)
    val list = left.getElementsByClass("params")[0].child(0)
    val genres = ArrayList<String>()

    for (a in list.getElementsByTag("a"))
        genres.add(a.text())

    return genres.toTypedArray()
}

fun getReleasePageDescription(main: Element): String =
    main.child(1).getElementsByClass("desc").text()

fun getReleasePageImageURL(main: Element): String =
    main.child(0).getElementsByTag("img").first().absUrl("src")

fun getReleasePageWorkers(main: Element): Array<Worker> {
    val right = main.child(0)
    val list = right.getElementsByClass("card-content text-center").last()
        .getElementsByClass("media-post media-role")
    val workerList = ArrayList<Worker>()

    for (e in list) {
        val name = e.getElementsByTag("font").last().text()
        val role = e.getElementsByTag("p").last().text()
        val imageURL = e.getElementsByTag("img").last().absUrl("src")

        workerList.add(Worker(name, role, imageURL))
    }

    return workerList.toTypedArray()
}

fun getReleasePageVideos(main: Element): Array<Video> {
    val left = main.child(1)
    val videoList = ArrayList<Video>()
    val videoBlocks: Elements
    val names = ArrayList<String>()

    try {
        videoBlocks = left.getElementsByClass("release-online__item")

        try {
            val a = main.getElementsByClass("panel-body").first()
                .getElementsByTag("ul").last().getElementsByTag("li")

            for (e in a)
                names.add(e.text())

        } catch (e: NullPointerException) {
            for (i in 0 until videoBlocks.count())
                names.add("$i+1")
        }

        for (i in 0 until videoBlocks.count()) {
            val name = names[i]
            val imageURL = videoBlocks[i].getElementsByTag("img").last().absUrl("src")
            val source = videoBlocks[i].getElementsByTag("a").last().absUrl("href")

            videoList.add(Video(imageURL, name, source))
            println(videoList[i])
        }
    } catch (e: NullPointerException) {}

    return videoList.toTypedArray()
}
