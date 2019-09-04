package com.training.app.foodExample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface FoodApi {

    @GET("locations")
    fun getLocations(
        @Query("query") query: String,
        @Query("count") count: Long,
        @Header("user-key") userKey: String
    ): Call<FoodResponse>

}