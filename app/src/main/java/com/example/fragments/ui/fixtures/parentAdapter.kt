package com.example.fragments.ui.fixtures

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.example.fragments.models.fixtures.FixturesResponse
import com.example.fragments.ui.fixtures.ParentItem
import kotlinx.android.synthetic.main.item_live_fixture.view.*

//class ParentItemAdapter internal constructor(private val itemList: List<ParentItem>) :
//    RecyclerView.Adapter<ParentItemAdapter.ParentViewHolder>() {

class ParentItemAdapter( val itemList: List<ParentItem>) : RecyclerView.Adapter<ParentItemAdapter.ParentViewHolder>() {
    private val itemList: List<ParentItem>

}
    // An object of RecyclerView.RecycledViewPool
    // is created to share the Views
    // between the child and
    // the parent RecyclerViews
    var viewPool : RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ParentViewHolder {

        // Here we inflate the corresponding
        // layout of the parent item
        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                com.example.fragments.R.layout.outer_recycler_view,
                viewGroup, false
            )
        return ParentViewHolder(view)
    }


override fun onBindViewHolder(parentViewHolder: ParentViewHolder, position: Int) {

//
//    holder.itemView.home_team_name_text_view.text = res.title
//    holder.itemView.away_team_name_text_view.text = res.title

        // Create an instance of the ParentItem
        // class for the given position

    val parentItem = itemList[position]

        // For the created instance,
        // get the title and set it
        // as the text for the TextView

//        parentViewHolder.ParentItemTitle.text = parentItem.parentItemTitle

        // Create a layout manager
        // to assign a layout
        // to the RecyclerView.

        // Here we have assigned the layout
        // as LinearLayout with vertical orientation
        val layoutManager = LinearLayoutManager(
            parentViewHolder.ChildRecyclerView
                .context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        // Since this is a nested layout, so
        // to define how many child items
        // should be prefetched when the
        // child RecyclerView is nested
        // inside the parent RecyclerView,
        // we use the following method
        layoutManager.initialPrefetchItemCount = parentItem
            .getChildItemList()
            .size

        // Create an instance of the child
        // item view adapter and set its
        // adapter, layout manager and RecyclerViewPool
        val childItemAdapter = ChildItemAdapter(
            parentItem
                .getChildItemList()
        )
        parentViewHolder.ChildRecyclerView.layoutManager = layoutManager
        parentViewHolder.ChildRecyclerView.adapter = childItemAdapter
        parentViewHolder.ChildRecyclerView
            .setRecycledViewPool(viewPool)
    }

    // This method returns the number
    // of items we have added in the
    // ParentItemList i.e. the number
    // of instances we have created
    // of the ParentItemList
    override fun getItemCount(): Int {
//        return itemList.size
        return 10
    }


    // This class is to initialize
    // the Views present in
    // the parent RecyclerView
    inner class ParentViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val ParentItemTitle: TextView
        val ChildRecyclerView: RecyclerView

        init {
            ParentItemTitle = itemView
                .findViewById(
                    com.example.fragments.R.id.parent_item_title
                )
            ChildRecyclerView = itemView
                .findViewById(
                    com.example.fragments.R.id.child_recyclerview
                )
        }
    }
}