package org.ksviety.shizaproject.app.api.pojo.elements

data class ReleaseBox (
    val title: String,
    val description: String,
    val imageURL: String,
    val releasePage: String,
    val status: String,
    val likes: Int,
    val comments: Int )