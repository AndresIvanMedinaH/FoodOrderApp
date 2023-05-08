package com.example.foodorderapp.data.remote.retrofit

import com.example.foodorderapp.domain.pojo.Meals
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MealsRequestAPI {
    @GET("random.php")
   suspend fun getRandomMealResponse(): Response<Meals>

    @GET("random.php")
    fun getRandomMealCall(): Call<Meals>
}