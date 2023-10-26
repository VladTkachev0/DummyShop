package com.example.retrofitloginlearn.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val mainApi:MainApi by lazy {
        retrofit.create(MainApi::class.java)
    }
}