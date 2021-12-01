package ru.skillbranch.learningproject.data.api

import CurrentMediaQuery
import GetListQuery
import android.util.Log
import com.apollographql.apollo.ApolloClient
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

    @ExperimentalCoroutinesApi
    override fun getMovie(id: Int): Flow<Movie> = client.query(CurrentMediaQuery(id))
            .toFlow()
            .map {
                it.data?.media?.mapToMovie() ?: Movie()
            }
            .flowOn(Dispatchers.IO)

    @ExperimentalCoroutinesApi
    override fun getMovies(type: MediaType, pageNumber: Int): Flow<List<Movie>> =
        client.query(GetListQuery(type, COUNT_ON_PAGE, pageNumber))
            .toFlow()
            .map {
                it.data?.page?.media?.map { movieResponse ->
                    movieResponse?.mapToMovie() ?: Movie()
                } ?: emptyList()
            }
            .flowOn(Dispatchers.IO)
}
