package com.example.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragments.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
     lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        val game = ArrayList<Games>()
        // Create an object for the MyAdapter
        val adapter = MyAdapter(game)
        binding.vpager.adapter = adapter
        binding.tlayout.tabGravity = TabLayout.GRAVITY_FILL

        game.add(Games(1 , "              Manchister"))
        game.add(Games(2,  "              Tottenham"))
        game.add(Games(3,  "              Chelsea"))
        game.add(Games(4,  "              Manchester"))
        game.add(Games(5,  "              Newcastle"))
        game.add(Games(6,  "              Liverpool"))
        game.add(Games(7,  "              Fullham"))
        game.add(Games(8,  "              BRIGHTON & HOVE ALBION"))
        game.add(Games(9,  "              BRENTFORD"))
        game.add(Games(10,       "        EVERTON"))
        game.add(Games(11,   "            CRYSTAL PALACE"))
        game.add(Games(13,   "             AFC BOURNEMOUTH"))
        game.add(Games(14,   "             ASTON VILLA"))
        game.add(Games(15,   "             SOUTHAMPTON"))
        game.add(Games(16,   "             LEICESTER CITY"))
        game.add(Games(17,   "             WEST HAM UNITED"))
        game.add(Games(18,   "             LEEDS UNITED"))
        game.add(Games(19,   "             WOLVERHAMPTON WANDERERS"))
        game.add(Games(20,   "             NOTTINGHAM FOREST"))
        // Set the Layout Manager
        grcv.layoutManager = LinearLayoutManager(this)
        // Set adapter to your RecyclerView
        vpager.adapter = adapter

    }
//    TabLayoutMediator(binding.tlayout, binding.vpager){tab, position ->
//        when(position){
//            0->{
//                tab.text = "Leagues"
//                tab.setIcon(R.drawable.home)
//            }
//            1->{
//                tab.text = "Standing"
//                tab.setIcon(R.drawable.work)
//            }
//        }
//    }.attach()


}
