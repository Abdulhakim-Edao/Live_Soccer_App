package com.example.fragments.ui.fixture

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.example.fragments.R
import com.example.fragments.model.fixture.FixtureMain
import com.example.fragments.model.fixture.Response

import kotlinx.android.synthetic.main.item_team_stat.view.*

import kotlinx.android.synthetic.main.activity_another_fixture.*
import kotlinx.android.synthetic.main.activity_another_fixture.view.*
import kotlinx.android.synthetic.main.item_fixture.view.*


class FixtureAdapter(res: FixtureMain) : RecyclerView.Adapter<FixtureAdapter.MyViewHolder>() {

//    var rvDate:DateAdapter? = null
    private var response = res
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(response1: List<Response>) {
            itemView.team1.text = response1[adapterPosition].teams.home.name
            itemView.team2.text = response1[adapterPosition].teams.away.name
            //set image with glide
            Glide.with(itemView.context).load(response1[adapterPosition].teams.home.logo).into(itemView.logo)
            Glide.with(itemView.context).load(response1[adapterPosition].teams.away.logo).into(itemView.logo2)
            itemView.result.text = response1[adapterPosition].goals.home.toString() + " - " + response1[adapterPosition].goals.away.toString()
        }
    }

    //override the onCreateViewHolder method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fixture, parent, false)
        return MyViewHolder(view)
    }

    //override the onBindViewHolder method
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

//        var recyclerView = holder.itemView.rvDate

        //set recyclerview for dates

//        rvDate = DateAdapter(holder.itemView.context)
//        //set adapter layout manager
////        recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
//        recyclerView.adapter = rvDate
        holder.bind(response.response)
    }

    //override the getItemCount method
    override fun getItemCount(): Int {
        return if (response.response.isNotEmpty()) {
            response.response.size
        } else {
            0
        }
    }
}