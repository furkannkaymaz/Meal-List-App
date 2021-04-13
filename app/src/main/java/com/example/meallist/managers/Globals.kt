package com.ddtech.ddverifier.managers

import android.graphics.Bitmap
import android.view.SurfaceControl
import com.example.meallist.model.*

import java.util.*
import kotlin.collections.ArrayList

public class Globals {

    companion object {
        private var instance: Globals? = null

        val shared: Globals
            get() {
                if (instance == null) {
                    instance = Globals()
                }

                return instance!!
            }
    }



    val BaseWebservice = "https://www.themealdb.com/api/json/v1/1/"
    var selectedCategory : ArrayList<SelectedMeals>? = null
//    var selectedMeal : ArrayList<Detaildata>? = null

}