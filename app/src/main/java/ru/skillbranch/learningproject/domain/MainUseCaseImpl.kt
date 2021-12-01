package ru.skillbranch.learningproject.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.skillbranch.learningproject.data.repository.MainRepository
import ru.skillbranch.learningproject.model.Movie
import type.MediaType

class MainUseCaseImpl(
    private val mainRepository: MainRepository
) : MainUseCase {

    override fun getMovie(id: Int): Flow<Movie> =
        mainRepository.getMovie(id)

    override fun getMovies(type: MediaType, pageNumber: Int): Flow<List<Movie>> =
        mainRepository.getMovies(type, pageNumber)

    override fun getTest(): Flow<Int> = flow {
        emit(2)
    }
}
