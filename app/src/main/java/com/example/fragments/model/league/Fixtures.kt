package com.example.fragments.model.league


import com.google.gson.annotations.SerializedName

data class Fixtures(
    val events: Boolean,
    val lineups: Boolean,
    @SerializedName("statistics_fixtures")
    val statisticsFixtures: Boolean,
    @SerializedName("statistics_players")
    val statisticsPlayers: Boolean
)