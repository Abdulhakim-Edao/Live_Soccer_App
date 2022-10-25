package com.example.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments.ui.fixtures.FixturesActivity

class HomeFragment : Fragment(R.layout.fragment_home) {

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            var intent = Intent(requireContext(), FixturesActivity::class.java)
            startActivity(intent)

        }




}