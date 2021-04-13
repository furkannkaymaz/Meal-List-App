package com.example.rocketapp.managers


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface ServiceEndpoints {
     @GET("list.php?a=list")
    fun getMenuList(): Call<String>

    @GET("categories.php")
    fun getCategories(): Call<String>

    @GET("filter.php?")
    fun getfilter(@Query("a") a:String ): Call<String>

    @GET("lookup.php?")
    fun getDetail(@Query("i") a:String ): Call<String>


}