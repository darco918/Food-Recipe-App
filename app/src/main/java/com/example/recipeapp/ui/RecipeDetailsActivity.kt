package com.example.recipeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.navArgs
import com.example.recipeapp.R
import com.example.recipeapp.adapters.ViewPagerAdapter
import com.example.recipeapp.ui.fragments.viewpagerfragments.IngredientsFragment
import com.example.recipeapp.ui.fragments.viewpagerfragments.InstructionsFragment
import com.example.recipeapp.ui.fragments.viewpagerfragments.RecipeOverviewFragment
import kotlinx.android.synthetic.main.activity_recipe_details.*

class RecipeDetailsActivity : AppCompatActivity() {
    private val args by navArgs<RecipeDetailsActivityArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        val resultBundle = Bundle()
        resultBundle.putParcelable("recipeBundle", args.result)

        val fragments = ArrayList<Fragment>()
        fragments.add(RecipeOverviewFragment())
        fragments.add(IngredientsFragment())
        fragments.add(InstructionsFragment())

        val mAdapter = ViewPagerAdapter(
            resultBundle,
            fragments,
            supportFragmentManager
        )

        val viewpager =
            findViewById<androidx.viewpager.widget.ViewPager>(R.id.viewPagerDetailsActivity)
        viewpager.adapter = mAdapter
        indicator.setViewPager(viewpager)

    }
}