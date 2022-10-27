package com.example.fragments.ui.fixture

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R

import kotlinx.android.synthetic.main.days.view.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import java.util.stream.Collectors
import java.util.stream.Stream


//extend recyclerview adapter
class DateAdapter(var context : Context) : RecyclerView.Adapter<DateAdapter.DateViewHolder>() {

    class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    //inflate view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        return DateViewHolder(
            LayoutInflater.from(context).inflate(R.layout.days, parent, false)
        )
    }

    //bind view
    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {

        val cal = Calendar.getInstance()
        cal.add(Calendar.DATE, -14)
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val date1 = sdf.format(cal.time)

        val dateList = Stream.iterate(LocalDate.parse(date1), { d -> d.plusDays(1) })
            .limit(29)
            .collect(Collectors.toList())

//        //create 14 days back from today using calendar and add it to the list
//        val cal2 = Calendar.getInstance()
//        cal.add(Calendar.DATE, -14)
//        val sdf2 = SimpleDateFormat("yyyy-MM-dd")
//        val date2 = sdf.format(cal.time)





        holder.itemView.date.text = dateList[position].toString()

    }

    override fun getItemCount(): Int {
        return 15
    }
}