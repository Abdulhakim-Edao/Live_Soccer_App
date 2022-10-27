package com.example.fragments.network

import com.example.fragments.model.fixture.FixtureMain
import com.example.fragments.model.league.LeagueMain
import com.example.fragments.model.table.ApiData
import com.example.fragments.model.teamStat.TeamStat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.time.LocalDate
import java.util.*


//https://4c1f0b2a-213b-47b6-af21-89e893ab2c25.mock.pstmn.io/v3/fixtures/statistics?fixture=868066
interface APIInterface {

    @Headers("X-RapidAPI-Key: 2641dba45emsh054b2ab43feb888p1c791bjsnc5420fc267ac",
        "X-RapidAPI-Host: api-football-v1.p.rapidapi.com")
    @GET("/v3/fixtures/statistics?fixture=868066")
    fun getTeamStatData(@Query("fixture") fixtureId:Int): Call<TeamStat>


    @Headers("X-RapidAPI-Key: 2641dba45emsh054b2ab43feb888p1c791bjsnc5420fc267ac",
        "X-RapidAPI-Host: api-football-v1.p.rapidapi.com")
    @GET("/v3/leagues?country=England")
    fun getLeague(): Call<LeagueMain>

    @Headers("X-RapidAPI-Key: 2641dba45emsh054b2ab43feb888p1c791bjsnc5420fc267ac",
        "X-RapidAPI-Host: api-football-v1.p.rapidapi.com")
    @GET("/v3/fixtures")
    fun getFixtureData(@Query("date") date: LocalDate,
        @Query("league") league:Int,
                @Query("season") season:Int

    ): Call<FixtureMain>


    @Headers("X-RapidAPI-Key: 2641dba45emsh054b2ab43feb888p1c791bjsnc5420fc267ac",
        "X-RapidAPI-Host: api-football-v1.p.rapidapi.com")
    @GET("/v3/standings")
    fun getTableData(@Query("season") season: Int, @Query("league") league:Int): Call<ApiData>

}

