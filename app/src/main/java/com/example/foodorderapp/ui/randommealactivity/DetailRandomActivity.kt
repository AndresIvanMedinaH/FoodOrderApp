package com.example.foodorderapp.ui.randommealactivity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.foodorderapp.databinding.ActivityDetailRandomBinding
import com.example.foodorderapp.domain.model.ChoosenRandomMeal
import com.example.foodorderapp.ui.navigationfragments.HomeFragment
import com.example.foodorderapp.ui.presentation.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailRandomActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailRandomBinding
    private val viewModel: HomeViewModel by viewModels()
    lateinit var chosenRandomMeal: ChoosenRandomMeal


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailRandomBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getMealDetailFromIntent()
        viewModel.observeRandomMealLiveData().observe(this) {
        }
        chosenRandomMeal = viewModel.getChoosenRandomMealDetail()
        Log.d("instructions", chosenRandomMeal.mealInstructions)

    }


    private fun setInfoOnViewWithViewModel() {
        viewModel.observeRandomMealLiveData().observe(
            this
        ) { meal ->
            meal?.let {
                Glide.with(applicationContext)
                    .load(meal.strMealThumb)
                    .into(binding.imageMealDetail)
            }
            binding.collapsingToolbar.title = meal.strMeal
            binding.tvMealRecipe.text = meal.strInstructions
        }
    }

    private fun printInfoFromViewModel() {
        Log.d(
            "VMInfo", "name:${viewModel.choosenRndmMealLiveData.value?.strMeal}" +
                    "thumb:${viewModel.choosenRndmMealLiveData.value?.strMealThumb}" +
                    "Instructions:${viewModel.choosenRndmMealLiveData.value?.strInstructions}"
        )
    }


    private lateinit var mealID: String
    private lateinit var mealName: String
    private lateinit var mealThumb: String
    private fun getMealDetailFromIntent() {
        val intent = intent

        mealID = intent.getStringExtra(HomeFragment.MEAL_ID).toString()
        mealName = intent.getStringExtra(HomeFragment.MEAL_NAME).toString()
        mealThumb = intent.getStringExtra(HomeFragment.MEAL_THUMB).toString()

    }

    private fun setInfoOnView() {
        Glide.with(applicationContext)
            .load(mealThumb)
            .into(binding.imageMealDetail)
        binding.collapsingToolbar.title = mealName
    }

}