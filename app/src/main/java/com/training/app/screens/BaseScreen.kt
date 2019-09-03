package com.training.app.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getlayoutRes())
        execute()
    }

    protected abstract fun getlayoutRes(): Int
    protected abstract fun execute()
}