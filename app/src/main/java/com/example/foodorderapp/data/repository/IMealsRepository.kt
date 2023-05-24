package com.example.foodorderapp.data.repository

import com.example.foodorderapp.domain.model.Meal
import com.example.foodorderapp.domain.model.MealDetail


interface IMealsRepository {
    suspend fun getMeal():Meal
    suspend fun getResultsOfMealByID(id:Int):MealDetail
}