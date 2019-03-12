package org.ksviety.shizaproject.app.api.pojo.pages

import org.ksviety.shizaproject.app.api.pojo.elements.SearchReleaseBox

data class SearchPage
    (
    val request: String, val suggestion: String?,
    val currentIndex: Int, val lastIndex: Int,
    val releases: Array<SearchReleaseBox>
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SearchPage

        if (request != other.request) return false
        if (suggestion != other.suggestion) return false
        if (currentIndex != other.currentIndex) return false
        if (lastIndex != other.lastIndex) return false
        if (!releases.contentEquals(other.releases)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = request.hashCode()
        result = 31 * result + (suggestion?.hashCode() ?: 0)
        result = 31 * result + currentIndex
        result = 31 * result + lastIndex
        result = 31 * result + releases.contentHashCode()
        return result
    }

}