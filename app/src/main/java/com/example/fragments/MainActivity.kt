package com.example.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.fragments.ui.league.MyPageAdapter

import com.example.fragments.databinding.ActivityMainBinding
import com.example.fragments.ui.league.LeagueActivity

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = Intent(this, LeagueActivity::class.java)
        startActivity(intent)

// for pushing to github

//        val adapter = MyPageAdapter(this)
//        binding.vpager.adapter = adapter
//        binding.tlayout.tabGravity = TabLayout.GRAVITY_FILL
//
//        TabLayoutMediator(binding.tlayout, binding.vpager){tab, position ->
//            when(position){
//                0->{
//                    tab.text = "Leagues"
//                    tab.setIcon(R.drawable.home)
//                }
//                1->{
//                    tab.text = "Standing"
//                    tab.setIcon(R.drawable.work)
//                }
//            }
//        }.attach()
    }
}