package ru.skillbranch.learningproject.data.api

import com.apollographql.apollo.api.Response
import kotlinx.coroutines.flow.Flow
import ru.skillbranch.learningproject.model.Movie
import type.MediaType

interface AnilistApi {

    suspend fun getMovie(id: Int): Response<CurrentMediaQuery.Data>
    suspend fun getMovies(type: MediaType, pageNumber: Int, pageSize: Int): Response<GetListQuery.Data>
}
