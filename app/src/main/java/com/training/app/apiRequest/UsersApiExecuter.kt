package com.training.app.apiRequest

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit

class UsersApiExecuter : ApiRequestManager() {

    private lateinit var api: TestApi
    private lateinit var listener: ApiListener

    fun login(email: String , baqdones: String) {
        api = retrofit.create(TestApi::class.java)
        api.login(email , baqdones)
            .enqueue(object : Callback<Response> {
                override fun onFailure(call: Call<Response>, t: Throwable) {
                    listener.onError(t)
                }

                override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                    listener.onSuccess(response.body()!!.data)
                }
            })
    }

    fun addListener(listener: ApiListener) {
        this.listener = listener
    }


}
