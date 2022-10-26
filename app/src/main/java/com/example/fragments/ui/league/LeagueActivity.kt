package com.example.fragments.ui.league

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fragments.databinding.ActivityLeagueBinding
import com.example.fragments.model.league.Response
import com.example.fragments.ui.fixture.FixtureActivity

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
    var intent = Intent(this, FixtureActivity::class.java)
        var leagueId = leagueResponse!![position].league.id.toString()
        intent.putExtra("leagueId", leagueId)

        startActivity(intent)
        adapter?.notifyItemChanged(position)
    }
}


