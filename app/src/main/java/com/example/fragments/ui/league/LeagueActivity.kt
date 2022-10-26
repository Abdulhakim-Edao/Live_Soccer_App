package com.example.fragments.ui.league

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fragments.databinding.ActivityLeagueBinding
import com.example.fragments.databinding.ActivityMainBinding
import com.example.fragments.model.league.LeagueMain
import com.example.fragments.model.league.Response

class LeagueActivity : AppCompatActivity(), HomeAdapter.OnItemClickListener {
    lateinit var binding:ActivityLeagueBinding
    private var adapter: HomeAdapter? = null
    private var leagueResponse: List<Response>? = null
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
            leagueResponse = it.response
            adapter = HomeAdapter(it,this)
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

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked And League name ${leagueResponse!![position].league.name}", Toast.LENGTH_SHORT).show()

        adapter?.notifyItemChanged(position)
    }
}


