package com.example.foodorderapp.ui.navigationfragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.foodorderapp.databinding.FragmentHomeBinding
import com.example.foodorderapp.ui.ViewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
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
            }
        }
    }


    private fun onRandomMealClicked() {
        binding.cardRandomMeal.setOnClickListener {

            /*
            val choosenMeal = viewModel.getMealDetail()
            Log.d("meal",choosenMeal.mealName)
            Log.d("meal",choosenMeal.mealInstructions)
            Log.d("meal",choosenMeal.mealThumb)
            */


            Log.d("ID",viewModel.choosenRndmMealLiveData.value?.idMeal.toString())

            var id =  viewModel.choosenRndmMealLiveData.value?.idMeal
            id?.let {
                viewModel.getMealByID(id)
            }


            val action = HomeFragmentDirections.actionHomeToDetail()
            findNavController().navigate(action)

        }
    }


}


