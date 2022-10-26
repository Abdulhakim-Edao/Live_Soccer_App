package com.example.fragments.model.fixture


import com.google.gson.annotations.SerializedName

data class League(
    val country: String,
    val flag: String,
    val id: Int,
    val logo: String,
    val name: String,
    val round: String,
    val season: Int
)