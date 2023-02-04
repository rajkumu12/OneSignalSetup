package com.decode.weatherapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WetherRecyclerVIewDays(val activity: Activity) :
    RecyclerView.Adapter<WetherRecyclerVIewDays.MyViewHolder>() {

    private var whetherlist: List<Weather>? = null
    var row_index = 0


    fun setWeather(whetherlist: List<Weather>?) {
        this.whetherlist = whetherlist
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WetherRecyclerVIewDays.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_horizontal_row, parent, false)
        return MyViewHolder(view.rootView)
    }

    override fun onBindViewHolder(holder: WetherRecyclerVIewDays.MyViewHolder, position: Int) {
        holder.bind(whetherlist?.get(position)!!, activity)
    }

    override fun getItemCount(): Int {
        if (whetherlist == null) return 0
        else return whetherlist?.size!!
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvName: TextView = view.findViewById(R.id.txt_name)
        val wheatherImage: ImageView = view.findViewById(R.id.img_image)
        val tvtemp: TextView = view.findViewById(R.id.txt_tempreture)
        fun bind(data: Weather, activity: Activity) {
           data.apply {
               tvName.text=data.dayName
               wheatherImage.setImageResource(data.image)
               tvtemp.text=data.tempreture
           }
        }
    }
}