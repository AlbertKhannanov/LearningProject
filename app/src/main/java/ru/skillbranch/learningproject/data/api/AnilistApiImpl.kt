package ru.skillbranch.learningproject.data.api

import CurrentMediaQuery
import GetListQuery
import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.coroutines.toDeferred
import com.apollographql.apollo.coroutines.toFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import ru.skillbranch.learningproject.model.Movie
import ru.skillbranch.learningproject.model.mapToMovie
import ru.skillbranch.learningproject.utils.COUNT_ON_PAGE
import type.MediaType

class AnilistApiImpl(
    private val client: ApolloClient
) : AnilistApi {

    override suspend fun getMovie(id: Int): Response<CurrentMediaQuery.Data> =
        client.query(CurrentMediaQuery(id))
            .await()

    override suspend fun getMovies(
        type: MediaType,
        pageNumber: Int,
        pageSize: Int
    ): Response<GetListQuery.Data> =
        client.query(GetListQuery(type, pageSize, pageNumber))
            .await()
}
