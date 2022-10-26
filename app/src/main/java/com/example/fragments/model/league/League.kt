package com.example.fragments.model.league


import com.google.gson.annotations.SerializedName

data class League(
    val id: Int,
    val logo: String,
    val name: String,
    val type: String
)