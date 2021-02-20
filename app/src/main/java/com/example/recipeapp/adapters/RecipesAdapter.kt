package com.example.recipeapp.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.databinding.RecipesRowLayoutBinding
import com.example.recipeapp.models.FoodRecipe
import com.example.recipeapp.models.Result
import com.example.recipeapp.ui.MainActivity
import com.example.recipeapp.ui.RecipeDetailsActivity
import com.example.recipeapp.util.RecipesDiffUtil

class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.MyViewHolder>() {

    private var recipes = emptyList<Result>()

    class MyViewHolder(private val binding: RecipesRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(result: Result){
            binding.result = result
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipesRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentRecipe = recipes[position]
        holder.bind(currentRecipe)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,RecipeDetailsActivity::class.java)

            val list = arrayListOf<String>("samsung","apple","test")
            intent.putStringArrayListExtra("recipe", list)
            holder.itemView.context.startActivity(intent)

        }

    }

    private fun putExtrasInIntent(intent: Intent,currentRecipe:Result){
        intent.putExtra("aggregateLikes",currentRecipe.aggregateLikes)
       // intent.putExtra("extendedIngredients",currentRecipe.extendedIngredients)
        intent.putExtra("id",currentRecipe.id)
        intent.putExtra("image",currentRecipe.image)
        intent.putExtra("readyInMinutes",currentRecipe.readyInMinutes)
        intent.putExtra("sourceUrl",currentRecipe.sourceUrl)
        intent.putExtra("summary",currentRecipe.summary)
        intent.putExtra("title",currentRecipe.aggregateLikes)
        intent.putExtra("aggregateLikes",currentRecipe.title)
        intent.putExtra("vegan",currentRecipe.vegan)
        intent.putExtra("veryHealthy",currentRecipe.veryHealthy)
        intent.putExtra("aggregateLikes",currentRecipe.aggregateLikes)
        intent.putExtra("aggregateLikes",currentRecipe.aggregateLikes)
        intent.putExtra("aggregateLikes",currentRecipe.aggregateLikes)


    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    fun setData(newData: FoodRecipe){
        val recipesDiffUtil =
            RecipesDiffUtil(recipes, newData.results)
        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
        recipes = newData.results
        diffUtilResult.dispatchUpdatesTo(this)
    }
}