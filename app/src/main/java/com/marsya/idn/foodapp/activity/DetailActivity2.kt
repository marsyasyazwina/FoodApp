package com.marsya.idn.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.idn.adeeva.model.Recipes
import com.marsya.idn.foodapp.R
import com.marsya.idn.foodapp.databinding.ActivityDetail2Binding

class DetailActivity2 : AppCompatActivity() {
    companion object {
        const val RECIPES_DATA = "recipe_data"
    }

    private lateinit var detailBinding : ActivityDetail2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetail2Binding.inflate (layoutInflater)
        setContentView(detailBinding.root)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }
        setSupportActionBar(detailBinding.tbDetail)
        val dataRecipes = intent.getParcelableExtra<Recipes>(RECIPES_DATA) as Recipes

        Glide.with(this).load(dataRecipes.pictures).into(detailBinding.ivDetail)

        detailBinding.tvNameDetail.text = dataRecipes.name
        detailBinding.tvCalories.text = dataRecipes.calories
        detailBinding.tvCarbo.text = dataRecipes.carbo
        detailBinding.tvProtein.text = dataRecipes.protein
        detailBinding.tvTittleDescription.text = dataRecipes.description
        detailBinding.tvIngeredients.text = dataRecipes.ingredients
        detailBinding.tvInstruction.text = dataRecipes.instructions
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}