package com.example.fragments.ui.fixtures

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragments.R
import com.example.fragments.databinding.ActivityFixturesBinding

import kotlinx.android.synthetic.main.activity_fixtures.*
import kotlinx.android.synthetic.main.fragment_fixtures.*
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

class FixturesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFixturesBinding
    private var adapter : LiveFixturesAdapter? = null
    var leagueId:Int? = 0
    var dt:String? = ""
//    @RequiresApi(Build.VERSION_CODES.O)
    var cal : Calendar = Calendar.getInstance()
    var date:Date? = cal.time

//    var date:LocalDate? = LocalDate.parse("2020-10-24")
    var season: Int = 2022
    var dateAdapter: FixtureDateAdapter? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fixtures)

        datesRCV.adapter = FixtureDateAdapter(this, 28)
        var intent = intent
//        leagueId = intent.getStringExtra("leagueId").toString().toInt()
        leagueId = 39

        var bundle : Bundle? = intent.extras
        dt = bundle?.getString("date").toString()

        initViewModel(season!!, leagueId!!, date!!)

    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun initViewModel(season:Int, leagueId:Int, dt: Date) {

        val viewModel = FixtureViewModel()
        viewModel.makeApiCall(season, leagueId, date!!)
        viewModel.getFixture(season, leagueId, date!!).observe(this) {
            adapter = LiveFixturesAdapter(it)
            binding!!.rvStandings.layoutManager = GridLayoutManager(this, 1)
            binding!!.rvStandings.adapter = adapter
        }
    }

    //    inflate main activity layout and initialize the view model after the data is fetched from the API
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        binding = ActivityFixturesBinding.inflate(layoutInflater)

        setContentView(binding?.root)
        if (season != null && leagueId != null) {
            initViewModel(season!!, leagueId!!, date!!)
        }
    }


}

