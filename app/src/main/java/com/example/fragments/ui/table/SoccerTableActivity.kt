package com.example.fragments.ui.table

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fragments.databinding.ActivitySoccerTableBinding

class SoccerTableActivity : AppCompatActivity() {
        private var binding : ActivitySoccerTableBinding? = null
        private var adapter : MyAdapter? = null
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
                adapter = MyAdapter(it)
                binding!!.rvStandings.layoutManager = GridLayoutManager(this, 1)
                binding!!.rvStandings.adapter = adapter
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




    }