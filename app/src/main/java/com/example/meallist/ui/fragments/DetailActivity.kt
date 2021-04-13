package com.example.meallist.ui.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.ddtech.ddverifier.managers.Globals
import com.example.meallist.MainActivity
import com.example.meallist.R
import com.example.meallist.databinding.ActivityDetailBinding
import com.example.meallist.databinding.ActivityMealBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var strInstructions = intent.getStringExtra("strInstructions")
        var strArea = intent.getStringExtra("strArea")
        var strMealThumb = intent.getStringExtra("strMealThumb")
        var strMeal = intent.getStringExtra("strMeal")

        

        binding.productDescriptionText.text =  "Product Description : $strInstructions"
        binding.productCategory.text = "Product Category : $strMeal"
        binding.productName.text = "Product Name : $strArea"

        Glide.with(this)
            .load(strMealThumb)
            .transform(CenterCrop(), RoundedCorners(20))
            .into(binding.imgIcon)

        binding.btnBack.setOnClickListener {
            var i = Intent(this, MealActivity::class.java)
            startActivity(i)
            finish()
            overridePendingTransition(0, 0);
        }








    }
}