package ru.skillbranch.learningproject.examples

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import ru.skillbranch.learningproject.R
import ru.skillbranch.learningproject.awaitTransitionComplete
import ru.skillbranch.learningproject.databinding.FragmentFourthExampleBinding

class FourthExampleFragment: Fragment(), CoroutineScope by MainScope() {

    private lateinit var binding: FragmentFourthExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthExampleBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        launch {
            with(binding.root) {
                transitionToState(R.id.fsecond)
                Log.i("asdfasdf", "qwerty")
                // do anything
                awaitTransitionComplete(R.id.fsecond)
                Log.i("asdfasdf", "qwerty2")
                // do anything
                transitionToState(R.id.fthird)
                // do anything
                awaitTransitionComplete(R.id.fthird)
                transitionToState(R.id.ffourth)
            }
        }
    }
}
