package com.example.foodorderapp.data.repository

import com.example.foodorderapp.domain.model.Meal


interface IMealsRepository {
    suspend fun getMeal(): Meal
}