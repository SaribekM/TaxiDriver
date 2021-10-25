package com.example.taxidriver.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taxidriver.R
import com.example.taxidriver.model.Driver
import com.example.taxidriver.service.DriverDiffCallback
import com.example.taxidriver.ui.RecyclerFragment

class DriverAdapter(val activity: Activity, private val drivers: MutableList<Driver>) :
    RecyclerView.Adapter<DriverAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name = view.findViewById<TextView>(R.id.textViewName)
        val photo = view.findViewById<ImageView>(R.id.imageView)
        val rating = view.findViewById<RatingBar>(R.id.ratingBar)
        val desc = view.findViewById<TextView>(R.id.textViewDesc)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.list_items, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val photo = holder.photo
        val name = holder.name
        val rating = holder.rating
        val desc = holder.desc

        name.text = drivers[position].name
        photo.setImageResource(drivers[position].photo)
        rating.rating = drivers[position].rating
        desc.text = drivers[position].desc

        holder.itemView.setOnClickListener {
            Toast.makeText(
                activity,
                drivers[position].name,
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    override fun getItemCount(): Int {
        return drivers.size
    }


}