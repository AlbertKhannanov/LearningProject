package ru.skillbranch.learningproject.model

import CurrentMediaQuery.Media
import GetListQuery.Medium

fun Media.mapToMovie(): Movie =
    Movie(
        id,
        type,
        title?.romaji,
        description,
        episodes,
        duration,
        chapters,
        volumes,
        coverImage?.extraLarge,
        bannerImage,
        siteUrl
    )

fun Medium.mapToMovie(): Movie =
    Movie(
        id,
        type,
        title?.romaji,
        description,
        episodes,
        duration,
        chapters,
        volumes,
        coverImage?.extraLarge,
        bannerImage,
        siteUrl
    )
