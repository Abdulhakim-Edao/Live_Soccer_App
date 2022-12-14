package com.example.fragments.ui.fixture

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragments.databinding.ActivityAnotherFixtureBinding
import com.example.fragments.model.fixture.Response
import com.example.fragments.ui.league.LeagueActivity
import com.example.fragments.ui.league.LeagueTableActivity
import com.example.fragments.ui.teamStat.TeamStatActivity

import kotlinx.android.synthetic.main.activity_another_fixture.*
import kotlinx.android.synthetic.main.days.view.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import kotlin.collections.List


class FixtureActivity : AppCompatActivity(), FixtureAdapter.OnItemClickListener {
    private lateinit var binding: ActivityAnotherFixtureBinding
    private var adapter : FixtureAdapter? = null
    var leagueId:Int? = 0
    var fixtureResponse: List<Response>? = null
    var date : LocalDate? = LocalDate.now()
    var season: Int = 2022
    var dateAdapter: DateAdapter? = null
    var scrollPosition:Int = 16

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnotherFixtureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //local broadcast manager
//        LocalBroadcastManager.getInstance(this).registerReceiver(
//            mMessageReceiver,
//            IntentFilter("date")
//        )




        var intent = intent

        leagueId = intent.getStringExtra("leagueId").toString().toInt()

        initViewModel(season!!, leagueId!!, date!!)
    }

    fun dateOnClick(view: View){
        //fetch the view id of the clicked item and store it in a variable

        val dt2 = view.date.text.toString()
        date = LocalDate.parse(dt2)
        //get clicked date position in the recyclerview and store it in a variable scrollPosition to be used in the recyclerview
        scrollPosition = (rvDate.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        //convert date to LocalDate

        initViewModel(season, leagueId!!, date!!)
    }

    private fun initViewModel(season:Int, leagueId:Int, date:LocalDate) {

        val viewModel = FixtureViewModel()
        viewModel.makeApiCall(season, leagueId, date!!)
        viewModel.getResponse().observe(this) {
            fixtureResponse = it.response
            dateAdapter = DateAdapter(this)
            adapter = FixtureAdapter(it, this)
            binding.rvDate.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            (rvDate.layoutManager as LinearLayoutManager).scrollToPosition(scrollPosition)
            binding.rvDate.adapter = dateAdapter
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

        var homeTeamName = fixtureResponse!![position].teams.home.name
        var awayTeamName = fixtureResponse!![position].teams.away.name
        var homeTeamScore = fixtureResponse!![position].goals.home
        var awayTeamScore = fixtureResponse!![position].goals.away
        var homeTeamLogo = fixtureResponse!![position].teams.home.logo
        var awayTeamLogo = fixtureResponse!![position].teams.away.logo
        var fixtureId = fixtureResponse!![position].fixture.id

        intent.putExtra("homeTeamName", homeTeamName)
        intent.putExtra("awayTeamName", awayTeamName)
        intent.putExtra("homeTeamScore", homeTeamScore)
        intent.putExtra("awayTeamScore", awayTeamScore)
        intent.putExtra("homeTeamLogo", homeTeamLogo)
        intent.putExtra("awayTeamLogo", awayTeamLogo)
        intent.putExtra("fixtureId", fixtureId)

        startActivity(intent)
        adapter?.notifyItemChanged(position)
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