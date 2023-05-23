package com.example.foodorderapp.data.remote.network

sealed class APIResponseStatus<T>() {


    class Loading<T>() : APIResponseStatus<T>()
    class Success<T>(val Data:T): APIResponseStatus<T>()
    class Error<T>(val messageID: Int): APIResponseStatus<T>()


    /*values used with enum class*/
//    LOADING, ERROR, SUCCESS
}