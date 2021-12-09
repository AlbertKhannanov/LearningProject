package ru.skillbranch.learningproject.domain

import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.skillbranch.learningproject.data.repository.MainRepository
import ru.skillbranch.learningproject.data.repository.MoviesPagingSource
import ru.skillbranch.learningproject.model.Movie
import type.MediaType

class MainUseCaseImpl(
    private val mainRepository: MainRepository,
) : MainUseCase {

    override suspend fun getMovie(id: Int): Movie =
        mainRepository.getMovie(id)

    override suspend fun getMovies(type: MediaType, pageNumber: Int): List<Movie> =
        mainRepository.getMovies(type, pageNumber)

    override suspend fun getPagingSource(): PagingSource<Int, Movie>? {
        return null
    }

    override fun getTest(): Flow<Int> = flow {
        emit(2)
    }
}
