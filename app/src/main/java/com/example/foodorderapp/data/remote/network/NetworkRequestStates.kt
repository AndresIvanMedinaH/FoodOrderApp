package com.example.foodorderapp.data.remote.network

sealed class  NetworkRequestStates {
    object Loading : NetworkRequestStates()
    object Error : NetworkRequestStates()
    object Success: NetworkRequestStates()
}