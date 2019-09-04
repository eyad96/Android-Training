package com.training.app.apiRequest

interface ApiListener {

    fun onSuccess(user: ResponseUser)

    fun onError(error: Throwable)

}
