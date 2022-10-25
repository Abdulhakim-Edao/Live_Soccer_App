package com.example.fragments.ui.fixtures;


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragments.R
import com.example.fragments.ui.fixtures.FixtureViewModel
import com.example.fragments.ui.fixtures.LiveFixturesAdapter

import kotlinx.android.synthetic.main.activity_fixtures.*
import kotlinx.android.synthetic.main.fragment_fixtures.*
import kotlinx.android.synthetic.main.item_live_fixture.view.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *            http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/

class LiveFixturesFragment(var date: String, var leagueId : Int) : Fragment() {

    lateinit var liveFixturesAdapter: LiveFixturesAdapter
    val supportFragmentManager: FragmentManager? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        initViewModel()
        return inflater.inflate(R.layout.fragment_fixtures, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    private fun initViewModel(){
        val viewModel = FixtureViewModel()
        viewModel.makeApiCall()

        viewModel.getFixture().observe(viewLifecycleOwner) {   //observe the live data

            liveFixturesAdapter = LiveFixturesAdapter(it)
            fixturesRCV.layoutManager = LinearLayoutManager(context)
            fixturesRCV.adapter = liveFixturesAdapter

        }
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//    }

}
