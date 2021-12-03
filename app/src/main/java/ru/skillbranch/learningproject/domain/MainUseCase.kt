package ru.skillbranch.learningproject.domain

import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import ru.skillbranch.learningproject.model.Movie
import type.MediaType


interface MainUseCase {

    suspend fun getMovie(id: Int): Movie
    suspend fun getMovies(type: MediaType, pageNumber: Int): List<Movie>
    suspend fun getPagingSource(): PagingSource<Int, Movie>?

    fun getTest(): Flow<Int>
}
