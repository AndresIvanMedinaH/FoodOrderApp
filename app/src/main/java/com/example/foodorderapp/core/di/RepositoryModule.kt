package com.example.foodorderapp.core.di

import com.example.foodorderapp.data.repository.ApiMealsRepositoryImpl
import com.example.foodorderapp.data.repository.IMealsRepository
import com.example.foodorderapp.domain.repository.IMealsRequestAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideMealsRepository(mealsRequestAPI: IMealsRequestAPI): IMealsRepository {
        return ApiMealsRepositoryImpl(mealsRequestAPI)
    }
}