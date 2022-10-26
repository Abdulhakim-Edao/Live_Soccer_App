package com.example.fragments.network

import com.example.fragments.model.fixture.FixtureMain
import com.example.fragments.model.league.LeagueMain
import com.example.fragments.model.teamStat.TeamStat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

//https://4c1f0b2a-213b-47b6-af21-89e893ab2c25.mock.pstmn.io/v3/fixtures/statistics?fixture=868066
interface APIInterface {
    @GET("https://4c1f0b2a-213b-47b6-af21-89e893ab2c25.mock.pstmn.io/v3/fixtures/statistics?fixture=868066")
    fun getTeamStatData(): Call<TeamStat>

    @GET("https://4c1f0b2a-213b-47b6-af21-89e893ab2c25.mock.pstmn.io/v3/leagues?country=England&season=2022")
    fun getLegue(): Call<LeagueMain>

    @GET("/v3/fixtures")
    fun getFixtureData(@Query("league") league:Int,
                @Query("season") season:Int,
                @Query("date") date: Date
    ): Call<FixtureMain>

}
package com.miu.retrofituser.network

import com.example.fragments.models.fixtures.FixturesResponse


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDate
import java.util.*

// Creating the API Interface able to send the request and get the response.
interface APIInterface {

//    @Headers("X-RapidAPI-Key: 2641dba45emsh054b2ab43feb888p1c791bjsnc5420fc267ac",
//        "X-RapidAPI-Host: api-football-v1.p.rapidapi.com")


//   @GET("/v3/fixtures?league=39&season=2022&from=2022-10-22&to=2022-10-24")
//   fun  getFixtures(): Call<FixturesResponse>

@GET("/v3/fixtures")
    fun getFixtures(@Query("league") league:Int,
                            @Query("season") season:Int,
                            @Query("date") date: Date
): Call<FixturesResponse>

//    @GET("v3/fixtures?league={id}&season={year}&from=2022-10-22&to=2022-10-24")
//    fun  getFixtures(@Path("id" ) id: Int, @Path("year") year: String): Call<List<LiveFixture>>

}

