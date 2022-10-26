package com.example.fragments.ui.teamStat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fragments.databinding.ActivityTeamStatBinding


class TeamStatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamStatBinding
    private  var fixtureId: String? = null
    private var adapter : TeamStatAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamStatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = intent
        fixtureId = intent.getStringExtra("fixtureId")

//        binding.fixture.text = fixtureId

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

//    update the main activity after the data is fetched from the API
//    override fun onResume() {
//        super.onResume()
//        initViewModel()
//    }

    //    inflate main activity layout and initialize the view model after the data is fetched from the API
    override fun onResume() {
        super.onResume()
        binding = ActivityTeamStatBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initViewModel()
    }

}