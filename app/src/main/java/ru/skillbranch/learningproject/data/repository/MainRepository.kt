package ru.skillbranch.learningproject.data.repository

import ru.skillbranch.learningproject.model.Movie
import ru.skillbranch.learningproject.utils.COUNT_ON_PAGE
import type.MediaType

interface MainRepository {

    suspend fun getMovie(id: Int): Movie
    suspend fun getMovies(type: MediaType, pageNumber: Int, pageSize: Int = COUNT_ON_PAGE): List<Movie>
}
