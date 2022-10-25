package com.miu.retrofituser.network

import com.example.fragments.models.fixtures.FixturesResponse


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

// Creating the API Interface able to send the request and get the response.
interface APIInterface {

//    @Headers("X-RapidAPI-Key: 2641dba45emsh054b2ab43feb888p1c791bjsnc5420fc267ac",
//        "X-RapidAPI-Host: api-football-v1.p.rapidapi.com")


//   @GET("/v3/fixtures?league=39&season=2022&from=2022-10-22&to=2022-10-24")
//   fun  getFixtures(): Call<FixturesResponse>

    @GET("posts")
    fun getFixtures(): Call<FixturesResponse>

//    @GET("v3/fixtures?league={id}&season={year}&from=2022-10-22&to=2022-10-24")
//    fun  getFixtures(@Path("id" ) id: Int, @Path("year") year: String): Call<List<LiveFixture>>

}

