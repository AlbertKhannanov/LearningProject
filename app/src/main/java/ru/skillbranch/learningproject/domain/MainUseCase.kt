package ru.skillbranch.learningproject.domain

import kotlinx.coroutines.flow.Flow
import ru.skillbranch.learningproject.model.Movie
import type.MediaType


interface MainUseCase {

    fun getMovie(id: Int): Flow<Movie>
    fun getMovies(type: MediaType, pageNumber: Int): Flow<List<Movie>>

    fun getTest(): Flow<Int>
}
