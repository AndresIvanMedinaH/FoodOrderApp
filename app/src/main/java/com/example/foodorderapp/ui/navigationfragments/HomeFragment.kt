package com.example.foodorderapp.ui.navigationfragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.foodorderapp.databinding.FragmentHomeBinding
import com.example.foodorderapp.domain.model.Meal
import com.example.foodorderapp.domain.model.Meals
import com.example.foodorderapp.ui.presentation.HomeViewModel
import com.example.foodorderapp.ui.randommealactivity.DetailRandomActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getRandomMeal()
        observeRandomMeal()
        onRandomMealClicked()
    }

    private fun observeRandomMeal() {
        viewModel.observeRandomMealLiveData().observe(
            viewLifecycleOwner
        ) { meal ->
            meal?.let {
                Glide.with(this@HomeFragment)
                    .load(meal.strMealThumb)
                    .into(binding.imgRandomMeal)
                this.randomMeal = meal
            }
        }
    }


    private fun onRandomMealClicked(){
        binding.cardRandomMeal.setOnClickListener{
            val intent =  Intent(activity, DetailRandomActivity::class.java)
            intent.putExtra(MEAL_ID,randomMeal.idMeal)
            intent.putExtra(MEAL_NAME,randomMeal.strMeal)
            intent.putExtra(MEAL_THUMB,randomMeal.strMealThumb)
            startActivity(intent)
        }
    }

private lateinit var randomMeal : Meal
    companion object{
        const val MEAL_ID ="com.example.foodorderapp.ui.fragments.idMeal"
        const val MEAL_NAME="com.example.foodorderapp.ui.fragments.nameMeal"
        const val MEAL_THUMB="com.example.foodorderapp.ui.fragments.thumbMeal"
    }

}


