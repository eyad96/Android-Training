package com.training.app.fakeApi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.training.app.R
import java.lang.Exception

class ListenerTest : Fragment() , RequestListener {

    private val requestManager: ApiRequestManager by lazy {
        ApiRequestManager()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_test_2222 , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestManager.addListener(this)
        requestManager.sendRequest(5)
    }

    override fun onSuccess(data: User) {
        Log.d("Request Test Success" , " The Details is $data")

    }

    override fun onError(ex: Exception) {
        Log.e("Request Test Error " , "The Error is : ${ex.message}")
    }

    override fun onCurrentStatus(status: String) {
        Log.d("Request Test State : " , " The Current State is : $status")
    }

    //ann .. object

}