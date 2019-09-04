package com.training.app.math

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.training.app.R
import kotlinx.android.synthetic.main.fragment_math.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MathFragment : Fragment() {

    var retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.12:8090/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val mathManager: MathManager by lazy {
        MathManager()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_math, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mathManager.addListener(currentListener)
        AddButton.setOnClickListener {
            mathManager.execute(
                Num1.text.toString().toDouble(),
                Num2.text.toString().toDouble(),
                MathOperations.ADD
            )
        }
    }

    private val currentListener: MathmaticalListener = object : MathmaticalListener {

        override fun onAddResult(result: Double) {
            Toast.makeText(activity!!, result.toString(), Toast.LENGTH_SHORT).show()
        }

        override fun onMult(result: Double) {

        }

        override fun onSubResult(result: Double) {

        }

    }
}