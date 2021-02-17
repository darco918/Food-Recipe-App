package com.example.recipeapp

import com.example.recipeapp.models.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoodRecipesApi {
    @GET("/recipes/complexSearch") // endpoint
    suspend fun getRecipes(
        @QueryMap queries: Map<String, String>

    ): Response<FoodRecipe>

}