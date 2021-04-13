package com.example.meallist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.meallist.adapters.CategoriesAdapter
import com.example.meallist.ui.fragments.MainFragment
import com.example.rocketapp.managers.ServiceManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var mainFragment: MainFragment = MainFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, mainFragment)
            .commit()


    }
}