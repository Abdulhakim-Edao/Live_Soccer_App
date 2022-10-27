package com.example.fragments.ui.teamStat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.fragments.databinding.ActivityTeamStatBinding
import com.example.fragments.ui.league.LeagueActivity
import com.example.fragments.ui.league.LeagueTableActivity
import kotlinx.android.synthetic.main.activity_team_stat.*
import kotlinx.android.synthetic.main.item_standings.view.*


class TeamStatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamStatBinding
    private var adapter : TeamStatAdapter? = null
    private var homeTeamName:String? = null
    private var awayTeamName:String? = null
    private var homeTeamScore:Int = 0
    private  var awayTeamScore:Int  = 0
    private  var homeTeamLogo:String? = null
    private  var awayTeamLogo :String?= null
    private  var fixtureId:Int  = 0


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
            homeTeamName = intent?.getStringExtra("homeTeamName")
            awayTeamName = intent?.getStringExtra("awayTeamName")
            homeTeamScore = intent.getIntExtra("homeTeamScore",0)
            awayTeamScore = intent.getIntExtra("awayTeamScore",0)
            homeTeamLogo = intent?.getStringExtra("homeTeamName")
            awayTeamLogo =intent?.getStringExtra("homeTeamName")
            fixtureId = intent.getIntExtra("fixtureId",0)

            team1Txt.text = homeTeamName
            team2Txt.text = awayTeamName
            team1Score.text = homeTeamScore.toString()
            team2Score.text = awayTeamScore.toString()

            Glide.with(this).load(homeTeamLogo).into(team1Img)
            Glide.with(this).load(homeTeamLogo).into(team2Img)
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

    fun leagueClick(view: View){
        var intent = Intent(this, LeagueActivity::class.java)
        startActivity(intent)
    }
    fun tableClick(view: View){
        var intent = Intent(this, LeagueTableActivity::class.java)
        startActivity(intent)
    }
}