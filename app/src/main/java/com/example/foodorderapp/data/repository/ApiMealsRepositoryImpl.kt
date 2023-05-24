package com.example.foodorderapp.data.repository

import com.example.foodorderapp.data.mapper.toMealDetail
import com.example.foodorderapp.domain.model.Meal
import com.example.foodorderapp.domain.model.MealDetail
import com.example.foodorderapp.domain.repository.IMealsRequestAPI
import javax.inject.Inject

class ApiMealsRepositoryImpl @Inject constructor( private val mealsRequestAPI: IMealsRequestAPI) : IMealsRepository {

    override suspend fun getMeal(): Meal{
        lateinit var randomMeal: Meal
        val result = mealsRequestAPI.getRandomMealResponse()
        val meals = result.body()?.meals
        meals?.let {
             randomMeal = meals[0]
            }
        return randomMeal
    }

    override suspend fun getResultsOfMealByID(id: Int): MealDetail {
        lateinit var meal : MealDetail
        val result = mealsRequestAPI.getMealDetail(id)
        result?.let {
            meal = result.body()?.toMealDetail() ?:MealDetail()
        }
        return meal
    }


}