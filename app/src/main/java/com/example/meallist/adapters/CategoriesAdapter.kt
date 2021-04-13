package com.example.meallist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.meallist.R
import com.example.meallist.model.Categories
import com.example.meallist.model.Category
import com.example.meallist.model.Meal

class CategoriesAdapter(private var spots: ArrayList<Category>)
    : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            inflater.inflate(
                R.layout.item_categories,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val spot = spots[position]

        holder.text.text = spot.strCategory

        Glide.with(holder.image.context)
            .load(spot.strCategoryThumb)
            .transform(CenterCrop(), RoundedCorners(20))
            .into(holder.image)


    }

    override fun getItemCount(): Int {
        return spots.size
    }

    fun setSpots(spots: ArrayList<Category>) {
        this.spots = spots
    }

    fun getSpots(): ArrayList<Category> {
        return spots
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var text: TextView = view.findViewById(R.id.categoriItem)
        var image: ImageView = view.findViewById(R.id.imgCategories)


    }
}

