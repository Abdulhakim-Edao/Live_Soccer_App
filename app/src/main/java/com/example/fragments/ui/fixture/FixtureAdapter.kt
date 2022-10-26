package com.example.fragments.ui.fixture

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.example.fragments.R
import com.example.fragments.model.fixture.FixtureMain
import com.example.fragments.model.fixture.Response
import kotlinx.android.synthetic.main.item_fixture.view.*


class FixtureAdapter(var res: FixtureMain,  var listener: OnItemClickListener) : RecyclerView.Adapter<FixtureAdapter.MyViewHolder>() {


   inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        fun bind(response1: List<Response>) {
            itemView.team1.text = response1[adapterPosition].teams.home.name
            itemView.team2.text = response1[adapterPosition].teams.away.name
            //set image with glide
            Glide.with(itemView.context).load(response1[adapterPosition].teams.home.logo).into(itemView.logo)
            Glide.with(itemView.context).load(response1[adapterPosition].teams.away.logo).into(itemView.logo2)

            itemView.result.text = response1[adapterPosition].goals.home.toString() + " - " + response1[adapterPosition].goals.away.toString()
        }
        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
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
        holder.bind(res.response)
    }

    //override the getItemCount method
    override fun getItemCount(): Int {
        return if (res.response.isNotEmpty()) {
            res.response.size
        } else {
            0
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}