package com.training.app.foodExample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.app.R
import kotlinx.android.synthetic.main.fragment_food.*

class FoodFragment : Fragment() , FoodApiListener {

    private val api: ApiRequestExecute by lazy {
        ApiRequestExecute()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_food , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        api.addListener(this)
        api.executeRequest()
    }

    override fun onSuccess(data: FoodResponse) {
        FoodRecycler.layoutManager = LinearLayoutManager(activity!! , LinearLayoutManager.VERTICAL , false)
        FoodRecycler.adapter = FoodAdapter(data.location_suggestions)
        (FoodRecycler.adapter as FoodAdapter).context = activity!!
    }

    override fun onError(ex: Throwable) {
        Toast.makeText(activity!! , ex.message , Toast.LENGTH_SHORT).show()
    }
}