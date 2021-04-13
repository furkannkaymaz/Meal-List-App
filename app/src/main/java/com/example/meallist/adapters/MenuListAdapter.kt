package com.example.meallist.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.meallist.R
import com.example.meallist.model.Meal
import com.example.meallist.ui.fragments.MealActivity
import com.example.rocketapp.managers.ServiceManager


class MenuListAdapter(private var spots: ArrayList<Meal>)
    : RecyclerView.Adapter<MenuListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            inflater.inflate(
                R.layout.item_menu,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val spot = spots[position]

      holder.text.text = spot.strArea

        holder.layout.setOnClickListener { a ->
            ServiceManager().getFilters(spot.strArea,
                {

                val i = Intent(a.context, MealActivity::class.java)
                    a.context.startActivity(i)

                },
                {
                }
            )
        }






    }

    override fun getItemCount(): Int {
        return spots.size
    }
    fun setSpots(spots: ArrayList<Meal>) {
        this.spots = spots
    }
    fun getSpots(): ArrayList<Meal> {
        return spots }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var text : TextView = view.findViewById(R.id.menuItem)
        var layout : ConstraintLayout = view.findViewById(R.id.layoutMenu)


    }

}