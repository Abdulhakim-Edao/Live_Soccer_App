package com.example.fragments.model.fixture


import com.google.gson.annotations.SerializedName

data class Away(
    val id: Int,
    val logo: String,
    val name: String,
    val winner: Boolean
)