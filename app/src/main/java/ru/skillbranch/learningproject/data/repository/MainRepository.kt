package ru.skillbranch.learningproject.data.repository

import kotlinx.coroutines.flow.Flow
import ru.skillbranch.learningproject.model.Movie
import type.MediaType

interface MainRepository {

    fun getMovie(id: Int): Flow<Movie>
    fun getMovies(type: MediaType, pageNumber: Int): Flow<List<Movie>>
}
