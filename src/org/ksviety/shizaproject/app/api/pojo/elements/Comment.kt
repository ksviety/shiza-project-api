package org.ksviety.shizaproject.app.api.pojo.elements

data class Comment
    (val name: String, val imageURL: String,
     val date: String, val text: String,
     val comments: Array<Comment>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Comment

        if (name != other.name) return false
        if (imageURL != other.imageURL) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (!comments.contentEquals(other.comments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + imageURL.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + comments.contentHashCode()
        return result
    }

}