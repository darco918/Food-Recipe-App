package com.example.recipeapp.ui.fragments.viewpagerfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeapp.R
import com.example.recipeapp.adapters.IngredientsAdapter
import com.example.recipeapp.models.Result
import kotlinx.android.synthetic.main.fragment_ingredients.view.*


class IngredientsFragment : Fragment() {

    private val mAdapter:IngredientsAdapter by lazy{IngredientsAdapter()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_ingredients, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable("recipeBundle")

        setUpRecyclerview(view)
        myBundle?.extendedIngredients?.let{mAdapter.setData(it)}

        return view
    }

    private fun setUpRecyclerview(view:View)
    {
        view.ingredientsRecyclerview.adapter = mAdapter
        view.ingredientsRecyclerview.layoutManager = LinearLayoutManager(requireContext())
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            IngredientsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}