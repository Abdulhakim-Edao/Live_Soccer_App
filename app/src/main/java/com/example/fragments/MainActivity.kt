package com.example.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.fragments.ui.league.MyPageAdapter

import com.example.fragments.databinding.ActivityMainBinding
import com.example.fragments.ui.league.LeagueActivity
import com.example.fragments.ui.league.LeagueTableActivity
import com.example.fragments.ui.table.SoccerTableActivity
import com.example.fragments.ui.teamStat.TeamStatActivity


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


    }
}