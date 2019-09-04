package com.training.app.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseScreen : AppCompatActivity() {

    var retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.12:8090/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getlayoutRes())
        execute()
    }

    protected abstract fun getlayoutRes(): Int
    protected abstract fun execute()
}