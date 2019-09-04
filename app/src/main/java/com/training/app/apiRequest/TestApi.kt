package com.training.app.apiRequest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TestApi {

    @GET("users/login")
    fun login(
        @Query("email") email: String,
        @Query("password") password: String
    ): Call<Response>

}
