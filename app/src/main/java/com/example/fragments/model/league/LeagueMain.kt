package com.example.fragments.model.league


import com.google.gson.annotations.SerializedName

data class LeagueMain(
    val errors: List<Any>,
    val `get`: String,
    val paging: Paging,
    val parameters: Parameters,
    val response: List<Response>,
    val results: Int
)