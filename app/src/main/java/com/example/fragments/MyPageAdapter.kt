package com.example.fragments

import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.fragments.ui.league.HomeFragment
import com.example.fragments.ui.league.WorkFragment

class MyPageAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> HomeFragment()
            1-> WorkFragment()
            else->Fragment()
        }
    }

}