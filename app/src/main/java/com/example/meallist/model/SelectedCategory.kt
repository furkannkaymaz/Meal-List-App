package com.example.meallist.model

import com.google.gson.annotations.SerializedName

data class SelectedCategory (
    @SerializedName("meals")
    val meals: ArrayList<SelectedMeals>
)

data class SelectedMeals (
    @SerializedName("strMeal")
    val strMeal: String,
    @SerializedName("strMealThumb")
    val strMealThumb: String,
    @SerializedName("idMeal")
    val idMeal: String
)

