package com.training.app.foodExample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.training.app.R
import kotlinx.android.synthetic.main.row_food.view.*

class FoodAdapter(private val data: ArrayList<FoodEntity>) : RecyclerView.Adapter<ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_food, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.Title.text = data[position].city_name
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val Title = view.Title
}