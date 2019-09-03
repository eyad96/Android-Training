package com.training.app

import android.widget.Toast
import com.training.app.screens.BaseScreen

class MainActivity : BaseScreen() {

    override fun getlayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun execute() {
        Toast.makeText(this, getString(R.string.app_name), Toast.LENGTH_SHORT).show()
    }


}
