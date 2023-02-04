package com.decode.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE
import android.text.style.AbsoluteSizeSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    lateinit var weatherlistRecy:RecyclerView
    lateinit var weatherlistDysRecy:RecyclerView
    lateinit var recyclerAdapter: WetherRecyclerVIewDays
    lateinit var recyclerAdapterDays: WetherRecyclerVIewDaysAll
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        weatherlistRecy=findViewById(R.id.recylerview_day)
        weatherlistDysRecy=findViewById(R.id.recy_allday)
        loadData()
        loadDataAll()


    }



    private fun loadDataAll() {
        var list= mutableListOf<WeatherDays>()
        list.add(WeatherDays("Today",R.drawable.cloud,"Partly Clo..","16°/8°"))
        list.add(WeatherDays("Tommorow",R.drawable.rainy,"Fog","18°/7°"))
        list.add(WeatherDays("Thu",R.drawable.cloudy_son,"Fog","12°/8°"))
        list.add(WeatherDays("Fri",R.drawable.cloudy_son,"Fog","19°/8°"))
        list.add(WeatherDays("Sat",R.drawable.sun,"Sunny","20°/12°"))
        list.add(WeatherDays("Sun",R.drawable.sun,"Sunny","15°/6°"))
        list.add(WeatherDays("Mon",R.drawable.sun,"Sunny","14°/6°"))
        weatherlistDysRecy.layoutManager= LinearLayoutManager(this)
        recyclerAdapterDays = WetherRecyclerVIewDaysAll(this)
        weatherlistDysRecy.adapter =recyclerAdapterDays
        recyclerAdapterDays.setWeather(list)
        recyclerAdapterDays.notifyDataSetChanged()
    }

    private fun loadData() {
        var list= mutableListOf<Weather>()
        list.add(Weather("Now",R.drawable.cloud,"6°C"))
        list.add(Weather("15:00",R.drawable.rainy,"9°C"))
        list.add(Weather("16:00",R.drawable.cloudy_son,"10°C"))
        list.add(Weather("16:33",R.drawable.cloudy_son,"4°C"))
        list.add(Weather("17:00",R.drawable.sun,"4.5°C"))
        list.add(Weather("18:00",R.drawable.moon,"8°C"))
        weatherlistRecy.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        recyclerAdapter = WetherRecyclerVIewDays(this)
        weatherlistRecy.adapter =recyclerAdapter
        recyclerAdapter.setWeather(list)
        recyclerAdapter.notifyDataSetChanged()

    }
}