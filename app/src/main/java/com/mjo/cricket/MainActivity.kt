package com.mjo.cricket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mjo.cricket.databinding.ActivityMainBinding
import com.mjo.cricket.fragment.LeaguesFragment
import com.mjo.cricket.fragment.TeamsFragment


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.fragment, LeaguesFragment()).commit()
    }

}