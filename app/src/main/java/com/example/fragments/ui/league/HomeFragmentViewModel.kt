package com.example.fragments.ui.league

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragments.model.league.LeagueMain
import com.example.fragments.network.APIInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragmentViewModel : ViewModel() {

    private var response1 : MutableLiveData<LeagueMain> = MutableLiveData()

    fun getResponse() : MutableLiveData<LeagueMain> {
        return response1
    }

    fun makeApiCall() {
        val baseUrl = "https://4c1f0b2a-213b-47b6-af21-89e893ab2c25.mock.pstmn.io/"
        val api = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIInterface::class.java)

        viewModelScope.launch {
            val response = api.getLegue().awaitResponse()
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