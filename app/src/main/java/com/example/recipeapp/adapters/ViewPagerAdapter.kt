package com.example.recipeapp.adapters

import androidx.fragment.app.*
import com.example.recipeapp.ui.fragments.viewpagerfragments.IngredientsFragment
import com.example.recipeapp.ui.fragments.viewpagerfragments.InstructionsFragment
import com.example.recipeapp.ui.fragments.viewpagerfragments.RecipeOverviewFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when( position){
            0 -> RecipeOverviewFragment.newInstance()
            1 -> IngredientsFragment.newInstance()
            2 -> InstructionsFragment.newInstance()
            else ->RecipeOverviewFragment.newInstance()

        }
    }

    override fun getCount() = 3

}
