package com.marsya.idn.foodapp.fragment

import com.marsya.idn.foodapp.adapter.RecipesAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.idn.adeeva.model.DataRecipes
import com.idn.adeeva.model.Recipes
import com.marsya.idn.foodapp.databinding.FragmentBreakfastBinding


class BreakfastFragment : Fragment() {
    private lateinit var breakfastBinding: FragmentBreakfastBinding
    private var list : ArrayList <Recipes> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        breakfastBinding = FragmentBreakfastBinding.inflate(inflater, container, false)
        return breakfastBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataBreakfast)
        breakfastBinding.rvBreakfast.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager (context, 2)
            val recipesAdapter = RecipesAdapter (list)
            adapter = recipesAdapter
        }

    }

}