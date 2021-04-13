package com.example.meallist.ui.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ddtech.ddverifier.managers.Globals
import com.example.meallist.MainActivity
import com.example.meallist.R
import com.example.meallist.adapters.CategoriesAdapter
import com.example.meallist.adapters.SelectedCategory
import com.example.meallist.databinding.ActivityMealBinding

class MealActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMealBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rcycView.layoutManager = GridLayoutManager(this
            , 2)
        binding.rcycView.adapter = SelectedCategory(Globals.shared.selectedCategory!!)

         binding.btnBack.setOnClickListener {
             var i =Intent(this,MainActivity::class.java)
             startActivity(i)
             finish()
             overridePendingTransition(0, 0);
         }




    }
}