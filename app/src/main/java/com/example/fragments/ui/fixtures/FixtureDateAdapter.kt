package com.example.fragments.ui.fixtures


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragments.R

import kotlinx.android.synthetic.main.days.view.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList


class FixtureDateAdapter(var context: Context, var leagueId: Int) : RecyclerView.Adapter<FixtureDateAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureDateAdapter.MyViewHolder{
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.days, parent, false)
        var cal : Calendar = Calendar.getInstance()
        var today = cal.get(Calendar.DATE)
//        var fragment = LiveFixturesFragment(today.toString(), leagueId)
//        var activity = context as FixturesActivity
//        activity.supportFragmentManager!!.beginTransaction().add(R.id.fixtures_container, fragment).addToBackStack(null).commit()
        return MyViewHolder(view)
    }

//    override fun onBindViewHolder(holder: MyViewHolder, position: Int): LiveFixturesFragment {
//        var cal : Calendar = Calendar.getInstance()
//        var today = cal.get(Calendar.DATE)
//        return LiveFixturesFragment(today)
//    }

    override fun onBindViewHolder(holder: FixtureDateAdapter.MyViewHolder, position: Int) {
        var dateList: ArrayList<String> = ArrayList()

        var cal : Calendar = Calendar.getInstance()
        var today = cal.get(Calendar.DATE)
        var month = cal.get(Calendar.MONTH)

        var sdf = SimpleDateFormat("dd/MM/yyyy")
        var day = sdf.format(Date())
//        var month1 = sdf.format()
        for ( index in 0..14){
            dateList.add(day)
        }
        holder.itemView.date.text = dateList[position].toString()

//        holder.itemView.date.setOnClickListener{
//            var fragment = LiveFixturesFragment(dateList[position], leagueId)
//            var activity = context as FixturesActivity
//            activity.supportFragmentManager!!.beginTransaction().replace(R.id.fixtures_container, fragment).addToBackStack(null).commit()
//        }
    }

    override fun getItemCount(): Int {
        return 15
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }


}