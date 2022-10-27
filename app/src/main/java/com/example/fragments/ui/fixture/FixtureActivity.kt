package com.example.fragments.ui.fixture

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragments.databinding.ActivityAnotherFixtureBinding
import com.example.fragments.ui.teamStat.TeamStatActivity

import kotlinx.android.synthetic.main.activity_another_fixture.*
import kotlinx.android.synthetic.main.days.view.*
import java.text.SimpleDateFormat
import java.util.*


class FixtureActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnotherFixtureBinding
    private var adapter : FixtureAdapter? = null
    var leagueId:Int? = 0
//    var dt:String? = ""
//    var date:LocalDate? = LocalDate.parse("2020-10-24")
    // create today's date with format yyyy-mm-dd using Date
    var dt: String = SimpleDateFormat("yyyy-MM-dd").format(Date())

    //format date
    var sdf = SimpleDateFormat("yyyy-MM-dd")
    var date = sdf.parse(dt)
    var season: Int = 2022
    var dateAdapter: DateAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnotherFixtureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //local broadcast manager
//        LocalBroadcastManager.getInstance(this).registerReceiver(
//            mMessageReceiver,
//            IntentFilter("date")
//        )


        dateAdapter = DateAdapter(this)

        var intent = intent

        leagueId = intent.getStringExtra("leagueId").toString().toInt()

        initViewModel(season!!, leagueId!!, date!!)
    }

    fun dateOnClick(view: View){
        //fetch the view id of the clicked item and store it in a variable

        val dt2 = view.date.text.toString()
//        var dt: String = SimpleDateFormat("yyyy-MM-dd").format(Date())
        var sdf2 = SimpleDateFormat("yyyy-MM-dd")
        var date2 = sdf2.parse(dt2)
        date = date2
        initViewModel(season, leagueId!!, date!!)
    }

    private fun initViewModel(season:Int, leagueId:Int, date:Date) {

        val viewModel = FixtureViewModel()
        viewModel.makeApiCall(season, leagueId, date!!)
        viewModel.getResponse().observe(this) {
            adapter = FixtureAdapter(it)
            rvDate.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            (rvDate.layoutManager as LinearLayoutManager).scrollToPosition(10)
            rvDate.adapter = dateAdapter
            binding.rvStandings.layoutManager = GridLayoutManager(this, 1)
            binding.rvStandings.adapter = adapter
        }
    }

    //    inflate main activity layout and initialize the view model after the data is fetched from the API
    override fun onResume() {
        super.onResume()
        binding = ActivityAnotherFixtureBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        if (season != null && leagueId != null) {
            initViewModel(season!!, leagueId!!, date!!)
        }
    }


    override fun onItemClick(position: Int) {
        var intent = Intent(this, TeamStatActivity::class.java)
        startActivity(intent)
        adapter?.notifyItemChanged(position)
    }


}