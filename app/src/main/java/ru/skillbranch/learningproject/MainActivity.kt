package ru.skillbranch.learningproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.skillbranch.learningproject.adapters.ViewPager2Adapter
import ru.skillbranch.learningproject.databinding.ActivityMainBinding
import ru.skillbranch.learningproject.examples.FirstExampleFragment
import ru.skillbranch.learningproject.examples.FourthExampleFragment
import ru.skillbranch.learningproject.examples.SecondExampleFragment
import ru.skillbranch.learningproject.examples.ThirdExampleFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var viewPagerAdapter: ViewPager2Adapter? = null

    private val fragments: List<Fragment> = listOf(
        FirstExampleFragment(),
        SecondExampleFragment(),
        ThirdExampleFragment(),
        FourthExampleFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerAdapter = ViewPager2Adapter(this, fragments)

        binding.mainContainer.adapter = viewPagerAdapter
    }
}
