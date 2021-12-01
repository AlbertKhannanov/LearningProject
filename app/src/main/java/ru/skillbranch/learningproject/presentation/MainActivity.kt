package ru.skillbranch.learningproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.skillbranch.learningproject.databinding.ActivityMainBinding
import ru.skillbranch.learningproject.presentation.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(binding.container.id, MainFragment.newInstance())
            .commit()
    }
}
