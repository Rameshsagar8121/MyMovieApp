package com.example.mydemoproject.common

import com.example.mydemoproject.Network.APIService
import com.example.mydemoproject.Network.Retrofit

object Common {

    private const val BASE_URL="https://www.omdbapi.com/ "
    val getAPIService:APIService
    get() = Retrofit.getRetrofitClient(BASE_URL).create(APIService::class.java)

}