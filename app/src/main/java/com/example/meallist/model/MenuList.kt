package com.example.meallist.model

import com.google.gson.annotations.SerializedName

data class Menu (
    @SerializedName("meals")
    val meals: ArrayList<Meal>
)

data class Meal (
    @SerializedName("strArea")
    val strArea: String
)

