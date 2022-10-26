package com.example.fragments.ui.fixtures


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragments.models.fixtures.FixturesResponse
import com.miu.retrofituser.network.APIInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.util.*


class FixtureViewModel : ViewModel() {

    var fixtures: MutableLiveData<FixturesResponse> = MutableLiveData()

    fun getFixture(season:Int, leagueId:Int, date: Date) : MutableLiveData<FixturesResponse> {
        return fixtures
    }

//    fun getFixture(): MutableLiveData<LiveFixture> {
//        return fixture
//    }




        fun makeApiCall(season:Int, leagueId:Int, date: Date) {
            viewModelScope.launch(Dispatchers.IO) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://9790f1b9-1f8d-4cd6-ad26-83b79e2c5aee.mock.pstmn.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val api = retrofit.create(APIInterface::class.java)
                val response = api.getFixtures(season, leagueId, date).awaitResponse()

                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        fixtures.value = response.body()

                    } else {
                        Log.i("Response", response.errorBody().toString())
                    }
                }
            }



        }

    }

//
//    fun makeApiCall() {
////        val baseUrl = "https://api-football-v1.p.rapidapi.com/"
//        val baseUrl = "https://jsonplaceholder.typicode.com/"
//
//        val api = Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(APIInterface::class.java)
//
//
//
//
//        viewModelScope.launch {
//            val response = api.getFixtures().awaitResponse()
//
//            withContext(Dispatchers.Main){
//                if(response.isSuccessful){
//                    fixtures.value = response.body()
//
//                }
//                else{
//                    Log.i("Response", response.errorBody().toString())
//                }
//            }
//        }

//    }
//
//
//}