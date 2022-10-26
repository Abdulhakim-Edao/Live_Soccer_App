package com.example.fragments.model.league


import com.google.gson.annotations.SerializedName

data class Coverage(
    val fixtures: Fixtures,
    val injuries: Boolean,
    val odds: Boolean,
    val players: Boolean,
    val predictions: Boolean,
    val standings: Boolean,
    @SerializedName("top_assists")
    val topAssists: Boolean,
    @SerializedName("top_cards")
    val topCards: Boolean,
    @SerializedName("top_scorers")
    val topScorers: Boolean
)