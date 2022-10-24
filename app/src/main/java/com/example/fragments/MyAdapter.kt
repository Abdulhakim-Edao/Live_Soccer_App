package com.example.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class MyAdapter (var teamlist:ArrayList<Games>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.itemView.Pos.text = teamlist[position].Pos.toString()
        holder.itemView.Team.text = teamlist[position].Team

    }

    override fun getItemCount(): Int {
        return teamlist.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}