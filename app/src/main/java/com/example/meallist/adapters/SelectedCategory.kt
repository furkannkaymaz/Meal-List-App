package com.example.meallist.adapters

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.ddtech.ddverifier.managers.Globals
import com.example.meallist.R
import com.example.meallist.managers.Helpers
import com.example.meallist.model.Categories
import com.example.meallist.model.Category
import com.example.meallist.model.Meal
import com.example.meallist.model.SelectedMeals
import com.example.meallist.ui.fragments.DetailActivity
import com.example.meallist.ui.fragments.MealActivity
import com.example.rocketapp.managers.ServiceManager

class SelectedCategory(private var spots: ArrayList<SelectedMeals>)
    : RecyclerView.Adapter<SelectedCategory.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            inflater.inflate(
                R.layout.item_categories_name,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val spot = spots[position]

        holder.productName.text = spot.strMeal

        Glide.with(holder.imgCategoriName.context)
            .load(spot.strMealThumb)
            .transform(CenterCrop(), RoundedCorners(20))
            .into(holder.imgCategoriName)

        for(i in 0 until spots.size){

            if(!Helpers.shared.getLoginInfo("id.${spot.idMeal}").isNullOrEmpty()){

                Glide.with(holder.imgCategoriName.context)
                    .load(ContextCompat.getDrawable(holder.imgCategoriName.context, R.drawable.ic_star_full))
                    .transform(CenterCrop(), RoundedCorners(20))
                    .into(holder.notLiked)

            }
        }


        holder.notLiked.setOnClickListener {
            if(Helpers.shared.getLoginInfo("id.${spot.idMeal}").isNullOrEmpty()){
                Helpers.shared.saveLoginInfo("id.${spot.idMeal}",spot.idMeal)

                Glide.with(holder.imgCategoriName.context)
                    .load(ContextCompat.getDrawable(holder.imgCategoriName.context, R.drawable.ic_star_full))
                    .transform(CenterCrop(), RoundedCorners(20))
                    .into(holder.notLiked)

            }else{
                Helpers.shared.saveLoginInfo("id.${spot.idMeal}","")

                Glide.with(holder.imgCategoriName.context)
                    .load(ContextCompat.getDrawable(holder.imgCategoriName.context, R.drawable.ic_star_border))
                    .transform(CenterCrop(), RoundedCorners(20))
                    .into(holder.notLiked)
            }
        }

        holder.imgCategoriName.setOnClickListener {a->


            ServiceManager().getDetail(spot.idMeal,
                {
                    val i = Intent(a.context, DetailActivity::class.java)

                    if(!Helpers.shared.getLoginInfo("id.${spot.idMeal}").isNullOrEmpty()){
                        i.putExtra("liked","true")
                    }

                    i.putExtra("strInstructions",it.meals[0].strInstructions)
                    i.putExtra("strArea",it.meals[0].strArea)
                    i.putExtra("strMealThumb",it.meals[0].strMealThumb)
                    i.putExtra("strMeal",it.meals[0].strMeal)
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

    fun setSpots(spots: ArrayList<SelectedMeals>) {
        this.spots = spots
    }

    fun getSpots(): ArrayList<SelectedMeals> {
        return spots
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var productName: TextView = view.findViewById(R.id.productName)
        var notLiked: ImageView = view.findViewById(R.id.notLiked)
        var imgCategoriName: ImageView = view.findViewById(R.id.imgCategoriName)
        var card: ConstraintLayout = view.findViewById(R.id.card)




    }
}
