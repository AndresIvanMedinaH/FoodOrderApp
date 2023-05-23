package com.example.foodorderapp.domain.model

import java.io.Serializable


data class ChoosenRandomMeal(
    val mealName: String,
    val mealThumb: String,
    val mealInstructions: String
) : Serializable

