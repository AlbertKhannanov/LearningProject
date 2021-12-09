package ru.skillbranch.learningproject.model

import android.graphics.Bitmap
import type.MediaType

data class Movie(
    val id: Int? = null,
    val type: MediaType? = null,
    val title: String? = null,
    val description: String? = null,
    val episodes: Int? = null,
    val duration: Int? = null,
    val chapters: Int? = null,
    val volumes: Int? = null,
    val coverImage: String? = null,
    val bannerImage: String? = null,
    val siteUrl: String? = null,

    var coverImageBitmap: Bitmap? = null
)
