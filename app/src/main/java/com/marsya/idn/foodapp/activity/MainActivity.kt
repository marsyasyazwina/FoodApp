package com.marsya.idn.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.marsya.idn.foodapp.R
import com.marsya.idn.foodapp.databinding.ActivityMainBinding
import com.marsya.idn.foodapp.fragment.BreakfastFragment
import com.marsya.idn.foodapp.fragment.DessertFragment
import com.marsya.idn.foodapp.fragment.VegetarianFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setCurrentFragment(BreakfastFragment())
        mainBinding .navMain.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.icBreakfast -> setCurrentFragment(BreakfastFragment())
                R.id.icVegetarian -> setCurrentFragment(VegetarianFragment())
                R.id.icDessert -> setCurrentFragment(DessertFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flMain, fragment)
            commit()
        }
    }
}