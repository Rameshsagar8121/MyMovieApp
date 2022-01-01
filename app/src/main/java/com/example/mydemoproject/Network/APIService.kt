package com.example.mydemoproject.Network

import com.example.mydemoproject.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("?s=movies&apiKey=5c2fc16b/Search")
    fun getMovieList():Call<MutableList<MovieModel>>
}