package ru.skillbranch.learningproject.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.skillbranch.learningproject.data.repository.MoviesPagingSource
import ru.skillbranch.learningproject.domain.MainUseCase
import ru.skillbranch.learningproject.model.Movie

class MainFViewModel(
    private val mainUseCase: MainUseCase,
) : ViewModel(), KoinComponent {

    val movies: StateFlow<PagingData<Movie>> = Pager(PagingConfig(pageSize = 1, initialLoadSize = 1, maxSize = 10)) {
        val moviesPagingSource: MoviesPagingSource by inject()
        moviesPagingSource
    }.flow
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
}
