package com.example.retrofitloginlearn.repository

import com.example.retrofitloginlearn.api.RetrofitInstance
import com.example.retrofitloginlearn.model.AuthRequest
import com.example.retrofitloginlearn.model.ProductX
import com.example.retrofitloginlearn.model.Products
import com.example.retrofitloginlearn.model.User
import retrofit2.Response

class Repository {

    suspend fun getUser(authRequest: AuthRequest): User {
        return RetrofitInstance.mainApi.auth(authRequest)
    }

    suspend fun getProducts(): Response<Products> {
        return RetrofitInstance.mainApi.getAllProduct()
    }

    suspend fun getProductSearch(name: String): Response<Products> {
        return RetrofitInstance.mainApi.getProductByName(name)
    }
}

