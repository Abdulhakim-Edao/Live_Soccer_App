package com.example.fragments.ui.teamStat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fragments.databinding.ActivityTeamStatBinding


class TeamStatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamStatBinding
    private var adapter : TeamStatAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamStatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()


    }

    private fun initViewModel(){
        val viewModel = TeamStatActivityViewModel()
        viewModel.makeApiCall()
        viewModel.getResponse().observe(this) {
            adapter = TeamStatAdapter(it)

            binding!!.rvStandings.layoutManager = GridLayoutManager(this, 1)
            binding!!.rvStandings.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        binding = ActivityTeamStatBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initViewModel()
    }

}