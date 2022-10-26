package com.example.fragments.model.league


import com.google.gson.annotations.SerializedName

data class Season(
    val coverage: Coverage,
    val current: Boolean,
    val end: String,
    val start: String,
    val year: Int
)