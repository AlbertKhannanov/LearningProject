package ru.skillbranch.learningproject.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject
import ru.skillbranch.learningproject.databinding.FragmentMainBinding
import ru.skillbranch.learningproject.presentation.adapter.AnimeMangaAdapter
import ru.skillbranch.learningproject.presentation.adapter.MoviesLoaderStateAdapter

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainFViewModel by inject()

    private val adapter: AnimeMangaAdapter by lazy(LazyThreadSafetyMode.NONE) {
        AnimeMangaAdapter()
    }

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

        binding.rv.adapter = adapter.withLoadStateHeaderAndFooter(
            MoviesLoaderStateAdapter(),
            MoviesLoaderStateAdapter(),
        )
        lifecycleScope.launchWhenStarted {
            viewModel.movies
                .collectLatest {
                    adapter.submitData(it)
                }
        }
    }

    companion object {

        fun newInstance() = MainFragment()
    }
}
