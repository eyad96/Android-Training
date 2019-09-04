package com.training.app.foodExample

interface FoodApiListener {

    fun onSuccess(data: FoodResponse)

    fun onError(ex: Throwable)

}
