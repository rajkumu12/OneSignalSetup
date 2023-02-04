package com.decode.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Anything : AppCompatActivity() {

    lateinit var edt_email:EditText
    lateinit var btn_login:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anything)

        edt_email=findViewById(R.id.edt_email)
        btn_login=findViewById(R.id.btn_login)

    }
}