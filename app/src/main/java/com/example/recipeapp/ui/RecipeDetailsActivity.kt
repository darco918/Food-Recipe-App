package com.example.recipeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.recipeapp.R
import com.example.recipeapp.adapters.ViewPagerAdapter
import com.example.recipeapp.ui.fragments.viewpagerfragments.IngredientsFragment
import com.example.recipeapp.ui.fragments.viewpagerfragments.InstructionsFragment
import com.example.recipeapp.ui.fragments.viewpagerfragments.RecipeOverviewFragment
import kotlinx.android.synthetic.main.activity_recipe_details.*

class RecipeDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        val recipe = intent.getStringArrayListExtra("recipe")


        Log.d("recipe", recipe?.get(0).toString())


        val fragments: ArrayList<Fragment> =
            arrayListOf(RecipeOverviewFragment(), IngredientsFragment(), InstructionsFragment())


        val viewpager = findViewById<androidx.viewpager.widget.ViewPager>(R.id.viewPagerDetailsActivity)
        val mAdapter = ViewPagerAdapter(supportFragmentManager)
        viewpager.adapter = mAdapter
        indicator.setViewPager(viewpager)

    }
}