package ru.skillbranch.learningproject.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import ru.skillbranch.learningproject.domain.MainUseCase
import ru.skillbranch.learningproject.model.Movie
import type.MediaType

class MainFViewModel(
    private val mainUseCase: MainUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState.Init)
    val uiState = _uiState.asStateFlow()

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            mainUseCase.getMovies(MediaType.ANIME, 1)
                .onStart {
                    _uiState.emit(MainUiState.Loading)
                }
                .collect {
                    _uiState.emit(MainUiState.MoviesLoaded(it))
                }
        }
    }
}

sealed class MainUiState {
    object Init : MainUiState()
    object Loading: MainUiState()
    object Error: MainUiState()
    data class MoviesLoaded(val movies: List<Movie>): MainUiState()
}
