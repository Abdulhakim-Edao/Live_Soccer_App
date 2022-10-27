package com.example.fragments.ui.table

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fragments.databinding.ActivitySoccerTableBinding
import com.example.fragments.ui.league.LeagueActivity
import com.example.fragments.ui.league.LeagueTableActivity

class SoccerTableActivity : AppCompatActivity() {
        private var binding : ActivitySoccerTableBinding? = null
        private var adapter : TableAdapter? = null
        var season:Int? = 2022
        var leagueId:Int? = 0

        override fun onCreate(savedInstanceState: Bundle?) {
            //create season and leagueId variables to get data from intent

            super.onCreate(savedInstanceState)
            binding = ActivitySoccerTableBinding.inflate(layoutInflater)
            setContentView(binding?.root)
            //get data from intent

            leagueId = intent?.getIntExtra("leagueId",0)
            initViewModel(season!!, leagueId!!)
        }

        private fun initViewModel(season:Int, leagueId:Int) {

            val viewModel = SoccerTableViewModel()
            viewModel.makeApiCall(season, leagueId)
            viewModel.getResponse().observe(this) {
                adapter = TableAdapter(it)
                binding!!.rvStandings.layoutManager = GridLayoutManager(this, 1)
                binding!!.rvStandings.adapter = adapter
                binding!!.tvLeagueName.text = it.response[0].league.name
            }
        }

        //    inflate main activity layout and initialize the view model after the data is fetched from the API
        override fun onResume() {
            super.onResume()
            binding = ActivitySoccerTableBinding.inflate(layoutInflater)
            setContentView(binding?.root)
            if (season != null && leagueId != null) {
                initViewModel(season!!, leagueId!!)
            }
        }

    fun leagueClick(view: View){
        var intent = Intent(this, LeagueActivity::class.java)
        startActivity(intent)
    }
    fun tableClick(view: View){
        var intent = Intent(this, LeagueTableActivity::class.java)
        startActivity(intent)
    }


    }