package com.training.app.foodExample

import com.google.gson.annotations.SerializedName

data class FoodResponse(
    val location_suggestions: ArrayList<FoodEntity>,
    val status: String
)

data class FoodEntity(
    val entity_type: String,

    @SerializedName("entity_id")
    val entityId: Long,
    val title: String,
    val latitude: Double,
    val longitude: Double,

    @SerializedName("city_id")
    val cityId: Long,
    val city_name: String
)
