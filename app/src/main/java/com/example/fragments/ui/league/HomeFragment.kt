package com.example.fragments.ui.league

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R
import kotlinx.android.synthetic.main.fragment_home.*



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
        rvStandings1.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            val viewModel = HomeFragmentViewModel()
            viewModel.makeApiCall()
            viewModel.getResponse().observe(viewLifecycleOwner) {
//                adapter = HomeAdapter(it)
            }
        }

    }

//    override fun onItemClick(position: Int) {
//        Toast.makeText(Context, "", Toast.LENGTH_LONG).show()
//    }
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