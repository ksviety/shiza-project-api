package org.ksviety.shizaproject.app.api.pojo.pages

import org.ksviety.shizaproject.app.api.pojo.elements.Comment
import org.ksviety.shizaproject.app.api.pojo.elements.Video
import org.ksviety.shizaproject.app.api.pojo.elements.Worker

data class ReleasePage(
    val title: String,
    val secondaryDescription: String,
    val description: String,
    val genres: Array<String>,
    val imageURL: String,
    val videos: Array<Video>,
    val Workers: Array<Worker>,
    val Comments: Array<Comment>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ReleasePage

        if (title != other.title) return false
        if (secondaryDescription != other.secondaryDescription) return false
        if (description != other.description) return false
        if (!genres.contentEquals(other.genres)) return false
        if (imageURL != other.imageURL) return false
        if (!videos.contentEquals(other.videos)) return false
        if (!Workers.contentEquals(other.Workers)) return false
        if (!Comments.contentEquals(other.Comments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + secondaryDescription.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + genres.contentHashCode()
        result = 31 * result + imageURL.hashCode()
        result = 31 * result + videos.contentHashCode()
        result = 31 * result + Workers.contentHashCode()
        result = 31 * result + Comments.contentHashCode()
        return result
    }

}