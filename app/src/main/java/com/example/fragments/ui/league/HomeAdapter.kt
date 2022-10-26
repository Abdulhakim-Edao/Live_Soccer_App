package com.example.fragments.ui.league
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R

import com.example.fragments.model.league.LeagueMain
import com.example.fragments.model.league.Response
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.item_league.view.*

class HomeAdapter(res: LeagueMain) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    private var response = res
    //create a view holder class
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //create a function to bind the data to the view
        fun bind(response: List<Response>) {
            itemView.nameTxt.text = response[adapterPosition].league.name
            Glide.with(itemView.context).load(response[adapterPosition].league.logo).into(itemView.logoImg)

        }
//        init{
//            itemView.setOnClickListener(this)
//        }
//        override fun onClick(view: View){
//            val position = adapterPosition
//            if(position != RecyclerView.NO_POSITION){
//                listener.onItemClick(position)
//            }
//
//        }

    }



    //override the onCreateViewHolder method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_league, parent, false)
        return MyViewHolder(view)
    }

    //override the onBindViewHolder method
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind( response.response)
    }

    //override the getItemCount method
    override fun getItemCount(): Int {
        return response.response.size
    }

//    interface OnItemClickListener{
//        fun onItemClick(position: Int)
//    }
}