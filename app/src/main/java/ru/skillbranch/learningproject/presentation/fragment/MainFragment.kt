package ru.skillbranch.learningproject.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject
import ru.skillbranch.learningproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainFViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.uiState
                .onEach {
                    when(it) {
                        MainUiState.Init -> {
                            Log.i("asdfasdf", "init")
                        }
                        MainUiState.Loading -> {
                            Log.i("asdfasdf", "loading")
                        }
                        MainUiState.Error -> {
                            Log.i("asdfasdf", "error")
                        }
                        is MainUiState.MoviesLoaded -> {
                            Log.i("asdfasdf", "${it.movies}")
                        }
                    }
                }
                .collect()
        }

        viewModel.getMovies()
    }

    companion object {

        fun newInstance() = MainFragment()
    }
}
