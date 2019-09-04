package com.training.app.foodExample

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiRequestExecute {

    private lateinit var api: FoodApi
    private lateinit var listner: FoodApiListener

    private val retrofit: Retrofit by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


        Retrofit.Builder()
            .baseUrl("https://developers.zomato.com/api/v2.1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun executeRequest() {
        api = retrofit.create(FoodApi::class.java)
        api.getLocations("jordan", 10, "fa9f94f64bac795e8cd10b32efb4d6ad")
            .enqueue(object : Callback<FoodResponse> {
                override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
                    listner.onError(t)
                }

                override fun onResponse(call: Call<FoodResponse>, response: Response<FoodResponse>) {
                    listner.onSuccess(response.body()!!)
                }
            })
    }

    fun addListener(listner: FoodApiListener) {
        this.listner = listner
    }

}