package com.example.recipeapp.models
import com.example.recipeapp.models.Result
import com.google.gson.annotations.SerializedName

data class FoodRecipe(
    @SerializedName("results")
    val results: List<Result>
)