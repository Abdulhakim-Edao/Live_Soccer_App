package com.example.fragments.ui.teamStat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.model.teamStat.Statistic
import com.example.fragments.model.teamStat.Team

import com.bumptech.glide.Glide
import com.example.fragments.R
import com.example.fragments.model.teamStat.TeamStat


import kotlinx.android.synthetic.main.item_team_stat.view.*

class TeamStatAdapter(res: TeamStat) : RecyclerView.Adapter<TeamStatAdapter.MyViewHolder>() {
    private var response = res

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(response1: List<Statistic>, response2: List<Statistic>, response: Team) {

            itemView.team1Stat.text = response1[adapterPosition].value
            itemView.stats.text = response1[adapterPosition].type
            itemView.team2Stat.text = response2[adapterPosition].value

        }

    }


    //override the onCreateViewHolder method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team_stat, parent, false)
        return MyViewHolder(view)
    }

    //override the onBindViewHolder method
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(response.response[0].statistics, response.response[1].statistics, response.response[0].team)
    }

    //override the getItemCount method
    override fun getItemCount(): Int {
        return response.response[0].statistics.size
    }
}