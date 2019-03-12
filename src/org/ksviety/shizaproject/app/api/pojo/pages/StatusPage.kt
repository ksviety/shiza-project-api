package org.ksviety.shizaproject.app.api.pojo.pages

import org.ksviety.shizaproject.app.api.pojo.elements.ReleaseBox

data class StatusPage (val currentIndex: Int, val lastIndex: Int, val releases: Array<ReleaseBox>) {

    fun isLast(): Boolean = currentIndex < lastIndex

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StatusPage

        if (currentIndex != other.currentIndex) return false
        if (lastIndex != other.lastIndex) return false
        if (!releases.contentEquals(other.releases)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = currentIndex
        result = 31 * result + lastIndex
        result = 31 * result + releases.contentHashCode()
        return result
    }

}