package ru.skillbranch.learningproject.examples

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import ru.skillbranch.learningproject.MainActivity
import ru.skillbranch.learningproject.databinding.FragmentThirdExampleBinding
import ru.skillbranch.learningproject.examples.thirdfragments.Fragment1
import ru.skillbranch.learningproject.examples.thirdfragments.Fragment2

class ThirdExampleFragment: Fragment() {

    private lateinit var binding: FragmentThirdExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdExampleBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction()
            .add(binding.flContainer.id, Fragment1())
            .commit()

        binding.root.addTransitionListener(object: MotionLayout.TransitionListener {
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
                (activity as MainActivity).binding.mainContainer.isUserInputEnabled = false
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
                if (progress > .5)
                    childFragmentManager.beginTransaction()
                        .replace(binding.flContainer.id, Fragment2())
                        .commitNow()
                else
                    childFragmentManager.beginTransaction()
                        .replace(binding.flContainer.id, Fragment1())
                        .commitNow()
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                (activity as MainActivity).binding.mainContainer.isUserInputEnabled = true
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {}
        })
    }
}
