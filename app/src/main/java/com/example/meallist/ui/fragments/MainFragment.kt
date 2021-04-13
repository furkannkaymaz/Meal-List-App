package com.example.meallist.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.meallist.R
import com.example.meallist.adapters.CategoriesAdapter
import com.example.meallist.adapters.MenuListAdapter
import com.example.rocketapp.managers.ServiceManager


class MainFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        var menuList = view.findViewById<RecyclerView>(R.id.menuList)
        var meals = view.findViewById<RecyclerView>(R.id.meals)

        ServiceManager().getMenuList(
            {
                menuList.layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                menuList.adapter = MenuListAdapter(it.meals)

            },
            {
            }
        )

        ServiceManager().getCategories(
            {


                meals.layoutManager = GridLayoutManager(context, 3)
                meals.adapter = CategoriesAdapter(it.categories)

            },
            {
            }
        )





        return view
    }


}