package com.example.foodorderapp.domain.model


import java.io.Serializable

data class MealDetail(
    val idMeal: String="",
    val mealName: String="",
    val area: String="",
    val mealThumb: String="",
    val mealInstructions: String=""
) : Serializable