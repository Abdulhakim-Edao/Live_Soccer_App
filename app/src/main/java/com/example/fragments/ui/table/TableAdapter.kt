package com.example.fragments.ui.table


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fragments.R
import com.example.fragments.model.table.ApiData
import com.example.fragments.model.table.Standing
import kotlinx.android.synthetic.main.item_standings.view.*

class TableAdapter(res: ApiData) : RecyclerView.Adapter<TableAdapter.MyViewHolder>() {
    private var response = res
    //create a view holder class
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //create a function to bind the data to the view
        fun bind(standing: List<List<Standing>>) {
            itemView.teamName.text = standing[0][adapterPosition].team.name
            itemView.rank.text = standing[0][adapterPosition].rank.toString()
            itemView.points.text = standing[0][adapterPosition].points.toString()
            itemView.goals.text = standing[0][adapterPosition].all.goals.`for`.toString()
            itemView.goalsAgainst.text = standing[0][adapterPosition].all.goals.against.toString()
            itemView.goalsDiff.text = standing[0][adapterPosition].goalsDiff.toString()
            Glide.with(itemView.context).load(standing[0][adapterPosition].team.logo).into(itemView.logo)
        }
    }


    //override the onCreateViewHolder method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_standings, parent, false)
        return MyViewHolder(view)
    }

    //override the onBindViewHolder method
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(response.response[0].league.standings)
    }

    //override the getItemCount method
    override fun getItemCount(): Int {
        //check if the response is not null
        return if (response.response.isNotEmpty()) {
            response.response[0].league.standings[0].size
        } else {
            0
        }
    }
}