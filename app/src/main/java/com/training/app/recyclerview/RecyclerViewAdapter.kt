package com.training.app.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.training.app.R
import kotlinx.android.synthetic.main.row_recyclerview.view.*

class RecyclerViewAdapter(private val data: ArrayList<User>) :
    RecyclerView.Adapter<MyViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_recyclerview, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.username.text = data[position].name
        holder.password.text = data[position].pass
        holder.item.setOnClickListener {
            Toast.makeText(context , "The Item Number is : $position" , Toast.LENGTH_SHORT).show()
        }
    }


}

class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val username = view.Username
    val password = view.password
    val item = view.Item
}

data class User(
    val name: String,
    val pass: String = "123456798"
)