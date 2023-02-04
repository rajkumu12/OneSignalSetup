package com.decode.weatherapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WetherRecyclerVIewDaysAll(val activity: Activity) :
    RecyclerView.Adapter<WetherRecyclerVIewDaysAll.MyViewHolder>() {

    private var whetherlist: List<WeatherDays>? = null
    var row_index = 0


    fun setWeather(whetherlist: List<WeatherDays>?) {
        this.whetherlist = whetherlist
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WetherRecyclerVIewDaysAll.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_vertical_row, parent, false)
        return MyViewHolder(view.rootView)
    }

    override fun onBindViewHolder(holder: WetherRecyclerVIewDaysAll.MyViewHolder, position: Int) {
        holder.bind(whetherlist?.get(position)!!, activity)
    }

    override fun getItemCount(): Int {
        if (whetherlist == null) return 0
        else return whetherlist?.size!!
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.txt_dayname)
        val wheatherImage: ImageView = view.findViewById(R.id.img_image)
        val dayDetail: TextView = view.findViewById(R.id.txt_deydetail)
        val tvtemp: TextView = view.findViewById(R.id.txt_tempreture)
        fun bind(data: WeatherDays, activity: Activity) {
           data.apply {
               tvName.text=data.dayName
               wheatherImage.setImageResource(data.image)
               dayDetail.text=data.detailDay
               tvtemp.text=data.tempreture
           }
        }
    }
}