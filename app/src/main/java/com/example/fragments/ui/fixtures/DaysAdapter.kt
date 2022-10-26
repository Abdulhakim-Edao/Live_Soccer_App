package com.example.fragments.ui.fixtures

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.ui.fixtures.Days
import com.example.fragments.ui.fixtures.FixtureDateAdapter
import kotlinx.android.synthetic.main.days.view.*
import java.text.SimpleDateFormat
import java.util.*


class ChildItemAdapter internal constructor(childItemList: List<Days>) : RecyclerView.Adapter<ChildItemAdapter.ChildViewHolder>() {
    private val childItemList: List<Days>

    // Constructor
    init {
        ChildItemList = childItemList
    }


    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ChildItemAdapter.ChildViewHolder {

        // Here we inflate the corresponding
        // layout of the child item
        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                com.example.fragments.R.layout.days_test,
                viewGroup, false
            )
        return ChildViewHolder(view)
    }
    override fun onBindViewHolder(childViewHolder: ChildItemAdapter.ChildViewHolder, position: Int) {
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
        childViewHolder.itemView.date.text = dateList[position].toString()

//        holder.itemView.date.setOnClickListener{
//            var fragment = LiveFixturesFragment(dateList[position], leagueId)
//            var activity = context as FixturesActivity
//            activity.supportFragmentManager!!.beginTransaction().replace(R.id.fixtures_container, fragment).addToBackStack(null).commit()
//        }
    }


    override fun getItemCount(): Int {

        // This method returns the number
        // of items we have added
        // in the ChildItemList
        // i.e. the number of instances
        // of the ChildItemList
        // that have been created
        return ChildItemList.size
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    internal inner class ChildViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var ChildItemTitle: TextView

        init {
            ChildItemTitle = itemView.findViewById(
                com.example.fragments.R.id.child_item_title
            )
        }
    }
}