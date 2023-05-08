package com.example.foodorderapp.ui.presentation

//import com.example.foodorderapp.data.remote.retrofit.MealsRequestAPI
//import dagger.hilt.android.lifecycle.HiltViewModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorderapp.data.remote.retrofit.RetrofitInstance
import com.example.foodorderapp.domain.pojo.Meal
import com.example.foodorderapp.domain.pojo.Meals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//import javax.inject.Inject

//@HiltViewModel
class HomeViewModel /*@Inject constructor*/() :ViewModel() {

    //UDF encapsulation
    private var _randomMealLiveData = MutableLiveData<Meal>()
    val rndmMealLiveData: LiveData<Meal>
    get() = _randomMealLiveData



    /*To use with Response*/
    fun getRandomMeal() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = RetrofitInstance.api.getRandomMealResponse()
            val meals = result.body()?.meals
            meals?.let {
                val randomMeal = meals[0]
                _randomMealLiveData.postValue(randomMeal)
                Log.d("Test", "${randomMeal?.strMealThumb}")
            }
        }
    }


    /*To use with Call*/
    fun retrieveRandomMealCall() {
        RetrofitInstance.api.getRandomMealCall().enqueue(object : Callback<Meals> {
            //Successful connection
            override fun onResponse(call: Call<Meals>, result: Response<Meals>) {
                val meals = result.body()?.meals
                meals?.let {
                    val randomMeal = meals[(0..meals.size).random()]
                    _randomMealLiveData.value = randomMeal
                }

            }
            //fail connection
            override fun onFailure(call: Call<Meals>, t: Throwable) {
                Log.d("HomeFragment", t.message.toString())
            }
        })
    }


    fun observeRandomMealLiveData(): LiveData<Meal> {
        return rndmMealLiveData
    }

   }
