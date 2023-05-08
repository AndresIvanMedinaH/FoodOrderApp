package com.example.foodorderapp.core.di
/*
import com.example.foodorderapp.data.remote.retrofit.MealsRequestAPI
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
            .baseUrl("www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun providesMealsRequestAPI(retrofit: Retrofit) : MealsRequestAPI {
        return  retrofit.create(MealsRequestAPI::class.java)
    }

}*/