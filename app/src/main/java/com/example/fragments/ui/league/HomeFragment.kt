package com.example.fragments.ui.league

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R
import com.example.fragments.databinding.FragmentHomeBinding
import com.example.fragments.model.league.LeagueMain
import com.example.fragments.ui.teamStat.TeamStatActivity
import kotlinx.android.synthetic.main.fragment_home.*

//import com.example.fragments.ui.fixtures.FixturesActivity

class HomeFragment : Fragment() {
//    private lateinit var binding : FragmentHomeBinding
private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<HomeAdapter.MyViewHolder>? = null
//    private var adapter : HomeAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        rvStandings.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            val viewModel = HomeFragmentViewModel()
            viewModel.makeApiCall()
            viewModel.getResponse().observe(viewLifecycleOwner) {
                adapter = HomeAdapter(it)
            }
        }

    }
//    private fun initViewModel(){
//        val viewModel = HomeFragmentViewModel()
//        viewModel.makeApiCall()
//        viewModel.getResponse().observe(viewLifecycleOwner) {
//
//            adapter = HomeAdapter(it)
//
//        }
//    }
//
//
//
//    //    inflate main activity layout and initialize the view model after the data is fetched from the API
//    override fun onResume() {
//        super.onResume()
//        binding = FragmentHomeBinding.inflate(layoutInflater)
//        setContentView(binding?.root)
//        initViewModel()
//    }


}