package com.example.foodorderapp.data.remote.network

import com.example.foodorderapp.domain.repository.IMealsRequestAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: IMealsRequestAPI by lazy{
        Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IMealsRequestAPI::class.java)
    }
}