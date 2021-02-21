package com.example.recipeapp.adapters

import android.os.Bundle
import androidx.fragment.app.*

class ViewPagerAdapter(private val resultBundle: Bundle,
                       private val fragments: ArrayList<Fragment>,
                       fm: FragmentManager
): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        fragments[position].arguments = resultBundle
        return fragments[position]
    }
}