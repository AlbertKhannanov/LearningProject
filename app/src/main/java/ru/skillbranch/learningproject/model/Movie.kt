package ru.skillbranch.learningproject.model

import type.MediaType

data class Movie(
    private val id: Int? = null,
    private val type: MediaType? = null,
    private val title: String? = null,
    private val description: String? = null,
    private val episodes: Int? = null,
    private val duration: Int? = null,
    private val chapters: Int? = null,
    private val volumes: Int? = null,
    private val coverImage: String? = null,
    private val bannerImage: String? = null,
    private val siteUrl: String? = null
)
