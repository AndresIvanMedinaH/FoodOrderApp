package com.example.foodorderapp.ui.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorderapp.data.repository.IMealsRepository
import com.example.foodorderapp.domain.model.ChoosenRandomMeal
import com.example.foodorderapp.domain.model.Meal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private  val  iMealsRepository: IMealsRepository) : ViewModel() {
    //this variable represents
    //iMealsRepository:IMealsRepository(IMealsRepository)

    //UDF encapsulation
    private var _choosenRandomMealLiveData = MutableLiveData<Meal>()
    val choosenRndmMealLiveData: LiveData<Meal>
        get() = _choosenRandomMealLiveData


    /*
    * this func provide the mechanism to bring from
    * a repository a through a random call
    * to the API
    * random data*/
    /*To use with Response*/
    internal fun getRandomMeal() {
        viewModelScope.launch(Dispatchers.IO) {
            val meal = iMealsRepository.getMeal()
            meal?.let {
                _choosenRandomMealLiveData.postValue(meal)
                Log.d("Test", "${meal?.strMealThumb}")
            }
        }
    }

    internal fun getChoosenRandomMealDetail():ChoosenRandomMeal{
        val choosenRandomMeal = ChoosenRandomMeal(
            _choosenRandomMealLiveData.value?.strMeal.toString(),
        _choosenRandomMealLiveData.value?.strMealThumb.toString(),
        _choosenRandomMealLiveData.value?.strInstructions.toString())
        return  choosenRandomMeal
    }

    fun observeRandomMealLiveData(): LiveData<Meal> {
        return choosenRndmMealLiveData
    }


    /*
        /*To use with Call*/
        fun retrieveRandomMealCall() {
            IMealsRequestAPI.getRandomMealCall().enqueue(object : Callback<Meals> {
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

    */


}
