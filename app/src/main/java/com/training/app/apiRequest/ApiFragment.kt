package com.training.app.apiRequest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.training.app.R
import kotlinx.android.synthetic.main.fragment_api_test.*

class ApiFragment : Fragment(), ApiListener {

    private val api: UsersApiExecuter by lazy {
        UsersApiExecuter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_api_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        api.addListener(this)
        ApiButton.setOnClickListener {
            Progress.visibility = View.VISIBLE
            api.login(ApiEmail.text.toString(), ApiPass.text.toString())
        }
    }

    override fun onSuccess(user: ResponseUser) {
        ApiResponseText.text = user.email
        Progress.visibility = View.GONE
    }

    override fun onError(error: Throwable) {
        Toast.makeText(activity!!, error.message, Toast.LENGTH_SHORT).show()
    }

}