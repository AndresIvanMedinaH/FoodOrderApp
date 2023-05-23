package com.example.foodorderapp.core.di

import com.example.foodorderapp.domain.repository.IMealsRequestAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun retrofitProvider(): Retrofit = Retrofit.Builder()
            .baseUrl("http://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun providesMealsRequestAPI(retrofit: Retrofit) : IMealsRequestAPI {
        return  retrofit.create(IMealsRequestAPI::class.java)
    }

}