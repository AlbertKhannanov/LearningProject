package ru.skillbranch.learningproject.data.repository

import kotlinx.coroutines.flow.Flow
import ru.skillbranch.learningproject.data.api.AnilistApi
import ru.skillbranch.learningproject.model.Movie
import type.MediaType

class MainRepositoryImpl(
    private val animeApi: AnilistApi
) : MainRepository {

    override fun getMovie(id: Int): Flow<Movie> =
        animeApi.getMovie(id)

    override fun getMovies(type: MediaType, pageNumber: Int): Flow<List<Movie>> =
        animeApi.getMovies(type, pageNumber)
}
