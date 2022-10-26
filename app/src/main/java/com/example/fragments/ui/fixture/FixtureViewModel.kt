package com.example.fragments.ui.fixture

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragments.model.fixture.FixtureMain
import com.example.fragments.network.APIInterface

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.util.*

class FixtureViewModel : ViewModel(){
    private var response1 : MutableLiveData<FixtureMain> = MutableLiveData()
    //create variables to read from layout


    fun getResponse() : MutableLiveData<FixtureMain>{
        return response1
    }

    fun makeApiCall(season:Int, leagueId:Int, date: Date) {
        val baseUrl = "https://9790f1b9-1f8d-4cd6-ad26-83b79e2c5aee.mock.pstmn.io"
        val api = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIInterface::class.java)

        viewModelScope.launch {
            val response = api.getFixtureData(season, leagueId, date).awaitResponse()
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response1.value = response.body()
                }
                else{
                    Log.i("Response", response.errorBody().toString())
                }
            }
        }
    }
}