package com.example.foodorderapp.domain.repository

import com.example.foodorderapp.domain.model.Meals
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/*This interface will provide all the mechanisms to implement API calls for the meals API
*
* */
interface IMealsRequestAPI {
    @GET("random.php")
   suspend fun getRandomMealResponse(): Response<Meals>

    @GET("random.php")
    fun getRandomMealCall(): Call<Meals>
}