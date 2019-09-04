package com.training.app.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.training.app.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Test2Fragment : Fragment() {

    var retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.12:8090/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_test_2, container , false)
    }
}