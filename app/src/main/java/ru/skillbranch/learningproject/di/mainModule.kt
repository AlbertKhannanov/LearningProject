package ru.skillbranch.learningproject.di

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.skillbranch.learningproject.data.api.AnilistApi
import ru.skillbranch.learningproject.data.api.AnilistApiImpl
import ru.skillbranch.learningproject.data.repository.MainRepository
import ru.skillbranch.learningproject.data.repository.MainRepositoryImpl
import ru.skillbranch.learningproject.data.repository.MoviesPagingSource
import ru.skillbranch.learningproject.domain.MainUseCase
import ru.skillbranch.learningproject.domain.MainUseCaseImpl
import ru.skillbranch.learningproject.presentation.fragment.MainFViewModel
import java.util.concurrent.TimeUnit

val mainModule = module {

    viewModel {
        MainFViewModel(get())
    }

    single<MainUseCase> {
        MainUseCaseImpl(get())
    }

    single<MainRepository> {
        MainRepositoryImpl(get())
    }

    single<AnilistApi> {
        AnilistApiImpl(get())
    }

    single<ApolloClient> {
        ApolloClient.builder()
            .okHttpClient(get())
            .serverUrl("https://graphql.anilist.co")
            .build()
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    factory<MoviesPagingSource> {
        MoviesPagingSource(get())
    }
}
