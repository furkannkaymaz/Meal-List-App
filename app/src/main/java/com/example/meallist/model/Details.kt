package com.example.meallist.model

import com.google.gson.annotations.SerializedName

data class Detail (
    @SerializedName("meals")
    val meals: ArrayList<Detaildata>
)

data class Detaildata (
    @SerializedName("idMeal")
    val idMeal: String,
    @SerializedName("strArea")
    val strArea: String,
    @SerializedName("strMealThumb")
    val strMealThumb: String,
    @SerializedName("strInstructions")
    val strInstructions: String,
    @SerializedName("strMeal")
    val strMeal: String,
)

