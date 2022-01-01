package com.example.mydemoproject.Repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mydemoproject.Network.APIService
import com.example.mydemoproject.common.Common
import com.example.mydemoproject.model.MovieModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepo {
    private val apiService:APIService

    companion object{
        private const val TAG="MainRepo"
    }
    init {
        apiService=Common.getAPIService
    }
    val getMovieModelLiveData:MutableLiveData<MutableList<MovieModel>>
    get() {
        val data:MutableLiveData<MutableList<MovieModel>> =
            MutableLiveData<MutableList<MovieModel>>()
        apiService.getMovieList().enqueue(object :Callback<MutableList<MovieModel>>{
            override fun onResponse(
                call: Call<MutableList<MovieModel>>,
                response: Response<MutableList<MovieModel>>
            ) {
                Log.e(TAG,"onResponse"+response.code())
                if (response.isSuccessful){
                    data.value=response.body()
                }
                else{
                    data.value=null
                }
            }

            override fun onFailure(call: Call<MutableList<MovieModel>>, t: Throwable) {
                Log.e(TAG,"onResponse"+t.message)
            }

        })
        return data
    }
}