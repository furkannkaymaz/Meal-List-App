package com.example.meallist.model

import com.google.gson.annotations.SerializedName

data class Categories (
        @SerializedName("categories")
        val categories: ArrayList<Category>
    )

    data class Category (
        @SerializedName("idCategory")
        val idCategory: String,
        @SerializedName("strCategory")
        val strCategory: String,
        @SerializedName("strCategoryThumb")
        val strCategoryThumb: String,
        @SerializedName("strCategoryDescription")
        val strCategoryDescription: String
    )

