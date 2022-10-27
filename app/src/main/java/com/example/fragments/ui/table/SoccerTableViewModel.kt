package com.example.fragments.ui.table

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragments.model.table.ApiData
import com.example.fragments.network.APIInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class SoccerTableViewModel: ViewModel() {
    private var respose : MutableLiveData<ApiData> = MutableLiveData()

    fun getResponse(): MutableLiveData<ApiData> {
        return respose
    }

    fun makeApiCall(season: Int, leagueId: Int) {
        val base_url = "https://api-football-v1.p.rapidapi.com"
        val api = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIInterface::class.java)

        viewModelScope.launch {
            val response = api.getTableData(season, leagueId).awaitResponse()
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    respose.value = response.body()
                }
                else{
                    Log.i("Responsive", response.errorBody().toString())
                }
            }
        }
    }
}