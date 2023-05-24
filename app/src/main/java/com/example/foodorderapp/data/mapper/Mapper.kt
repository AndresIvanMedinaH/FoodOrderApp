package com.example.foodorderapp.data.mapper

import com.example.foodorderapp.domain.model.Meal
import com.example.foodorderapp.domain.model.MealDetail


/** Extension function to map from DTO to Detail class
 * for extracting specific data to show on detail views
 * */
fun Meal.toMealDetail(): MealDetail {
    return MealDetail(
        idMeal = this.idMeal,
        mealName = this.strMeal,
        area = this.strArea,
        mealThumb = this.strMealThumb,
        mealInstructions = this.strInstructions
    )
}