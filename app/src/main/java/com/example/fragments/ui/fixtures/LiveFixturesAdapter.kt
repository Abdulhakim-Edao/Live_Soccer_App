package com.example.fragments.ui.fixtures;

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R
import com.example.fragments.models.fixtures.*

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
 *          http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/

class LiveFixturesAdapter( var res: FixturesResponse ) : RecyclerView.Adapter<LiveFixturesAdapter.LiveFixtureViewHolder>() {

    var TAG: String = "Activity"
    inner class LiveFixtureViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveFixtureViewHolder {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_live_fixture, parent, false)

        return LiveFixtureViewHolder(view)
    }

    override fun onBindViewHolder(holder: LiveFixtureViewHolder, position: Int) {


        holder.itemView.home_team_name_text_view.text = res.title
        holder.itemView.away_team_name_text_view.text = res.title

    }

    override fun getItemCount(): Int {
        return 1
    }

}