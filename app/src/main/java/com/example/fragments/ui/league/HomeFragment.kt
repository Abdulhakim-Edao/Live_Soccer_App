package com.example.fragments.ui.league

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.fragments.R
import com.example.fragments.ui.teamStat.TeamStatActivity

//import com.example.fragments.ui.fixtures.FixturesActivity

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            var intent = Intent(requireContext(), TeamStatActivity::class.java)
            startActivity(intent)

    }




}