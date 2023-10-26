package com.example.retrofitloginlearn.api

import com.example.retrofitloginlearn.model.User
import com.example.retrofitloginlearn.model.AuthRequest
import com.example.retrofitloginlearn.model.Products
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface MainApi {
    @POST("auth/login")
    suspend fun auth(@Body authRequest: AuthRequest): User

    @GET("products")
    suspend fun getAllProduct(): Response<Products>


    @GET("products/search")
    suspend fun getProductByName(@Query("q") name: String): Response<Products>
}