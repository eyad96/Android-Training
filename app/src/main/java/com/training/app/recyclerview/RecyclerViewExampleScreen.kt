package com.training.app.recyclerview

import android.annotation.SuppressLint
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.training.app.R
import com.training.app.screens.BaseScreen
import kotlinx.android.synthetic.main.screen_recyclerview_example.*

class RecyclerViewExampleScreen : BaseScreen() {

    override fun getlayoutRes(): Int {
        return R.layout.screen_recyclerview_example
    }

    @SuppressLint("WrongConstant")
    override fun execute() {
        RecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        RecyclerView.adapter = RecyclerViewAdapter(
            arrayListOf(
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf"),
                User(name = "EYAD", pass = "asfafdsadf")
            )
        )
        (RecyclerView.adapter as RecyclerViewAdapter).context = this
        RecyclerView.addItemDecoration()
    }

}

private fun RecyclerView.addItemDecoration() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
