package ru.skillbranch.learningproject.data.repository

import ru.skillbranch.learningproject.data.api.AnilistApi
import ru.skillbranch.learningproject.model.Movie
import ru.skillbranch.learningproject.model.mapToMovie
import type.MediaType

class MainRepositoryImpl(
    private val animeApi: AnilistApi
) : MainRepository {

    override suspend fun getMovie(id: Int): Movie =
        animeApi.getMovie(id)
            .data?.media?.mapToMovie() ?: Movie()

    override suspend fun getMovies(type: MediaType, pageNumber: Int, pageSize: Int): List<Movie> =
        animeApi.getMovies(type, pageNumber, pageSize)
            .data?.page?.media?.map { it?.mapToMovie() ?: Movie() } ?: emptyList()
}
