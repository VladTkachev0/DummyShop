package com.example.retrofitloginlearn.model

data class Products(
    val limit: Int,
    val products: List<ProductX>,
    val skip: Int,
    val total: Int
)