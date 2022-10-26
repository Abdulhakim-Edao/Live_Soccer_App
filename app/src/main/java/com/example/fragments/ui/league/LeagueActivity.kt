package com.example.fragments.ui.league

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fragments.databinding.ActivityLeagueBinding
import com.example.fragments.databinding.ActivityMainBinding

class LeagueActivity : AppCompatActivity() {
    lateinit var binding:ActivityLeagueBinding
    private var adapter: HomeAdapter? = null
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                binding= ActivityLeagueBinding.inflate((layoutInflater))
                setContentView(binding.root)

                initViewModel()

    }
    private fun initViewModel(){
        val viewModel = LeagueActivityViewModel()
        viewModel.makeApiCall()
        viewModel.getResponse().observe(this) {

            adapter = HomeAdapter(it)
            binding!!.rvStandings1.layoutManager = GridLayoutManager(this, 1)
            binding!!.rvStandings1.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        binding = ActivityLeagueBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initViewModel()
    }
}


