package com.example.recipeapp.ui.fragments.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeapp.MainViewModel
import com.example.recipeapp.R
import com.example.recipeapp.adapters.RecipesAdapter
import com.example.recipeapp.models.FoodRecipe
import com.example.recipeapp.util.Constants.Companion.API_KEY
import com.example.recipeapp.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipes.view.*

@AndroidEntryPoint
class RecipesFragment : Fragment() {
    private lateinit var mView: View
    private val mAdapter by lazy { RecipesAdapter() }
    private lateinit var mainViewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_recipes, container, false)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        setUpRecyclerView()
        requestApiData()

        return mView
    }

    private fun applyQueries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()

        queries["number"] = "50"
        queries["apiKey"] = API_KEY
        queries["type"] = "main course"
        queries["diet"] = "vegan"
        queries["addRecipeInformation"] = "true"
        queries["fillIngredients"] = "true"

        return queries
    }

    private lateinit var foodRecipes: FoodRecipe

    private fun requestApiData() {
        mainViewModel.getRecipes(applyQueries())
        mainViewModel.recipesResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is NetworkResult.Succes -> {
                    hideShimmerEffect()
                    response.data?.let { mAdapter.setData(it) }
                    foodRecipes = response.data!!


                }
                is NetworkResult.Error -> {
                    hideShimmerEffect()
                    Toast.makeText(
                        requireContext(),
                        response.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is NetworkResult.Loading -> {
                    showShimmerEffect()
                }
            }
        }
    }

    private fun setUpRecyclerView() {
        mView.recyclerview.adapter = mAdapter
        mView.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        showShimmerEffect()
    }

    private fun showShimmerEffect() {
        mView.recyclerview.showShimmer()
    }

    private fun hideShimmerEffect() {
        mView.recyclerview.hideShimmer()
    }


}