package com.example.fragments.model.league


import com.google.gson.annotations.SerializedName

data class Response(
    val country: Country,
    val league: League,
    val seasons: List<Season>
)