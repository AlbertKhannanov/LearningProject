package ru.skillbranch.learningproject.data.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.apollographql.apollo.exception.ApolloException
import ru.skillbranch.learningproject.data.api.AnilistApi
import ru.skillbranch.learningproject.model.Movie
import ru.skillbranch.learningproject.model.mapToMovie
import type.MediaType
import java.lang.Exception

class MoviesPagingSource(
    private val animeApi: AnilistApi
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.inc() ?: page.nextKey?.dec()
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val pageNum: Int = params.key ?: 1
        val pageSize: Int = params.loadSize

        val response = animeApi.getMovies(MediaType.ANIME, pageNum, pageSize)

        return if (response.errors.isNullOrEmpty()) {
            val movies =
                response.data?.page?.media?.map { it?.mapToMovie() ?: Movie() } ?: emptyList()
            val nextKey = if (movies.size < pageSize) null else pageNum + 1
            val prevKey = if (pageNum == 1) null else pageNum - 1

            LoadResult.Page(movies, prevKey, nextKey)
        } else {
            LoadResult.Error(ApolloException("Something went wrong"))
        }
    }
}
