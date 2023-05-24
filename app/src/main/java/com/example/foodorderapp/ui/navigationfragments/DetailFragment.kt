package com.example.foodorderapp.ui.navigationfragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.foodorderapp.databinding.FragmentDetailBinding
import com.example.foodorderapp.ui.ViewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentDetailBinding
    //val arguments : DetailFragmentArgs by navArgs()






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentDetailBinding.inflate(inflater, container, false)

        Log.d("PASSED_DATA",viewModel._mealDetail.value?.mealInstructions.toString())
        setDetailInfo()
        return binding.root
    }



    internal fun setDetailInfo() {
        binding.tvMealRecipe.text = viewModel._mealDetail.value?.mealInstructions
        binding.collapsingToolbar.title = viewModel._mealDetail.value?.mealName
        Glide.with(this@DetailFragment).load(viewModel._mealDetail.value?.mealThumb)
            .into(binding.imageMealDetail)
    }

}