package com.training.app.fakeApi

import com.training.app.errors.InitializationException
import com.training.app.errors.RequestError

class ApiRequestManager {

    private lateinit var responseListener: RequestListener

    fun sendRequest(userId: Int) {
        if (::responseListener.isInitialized) {
            if (userId <= 0) {
                responseListener.onError(RequestError("User Id Should Be bigger Than 0"))
            } else {
                responseListener.onCurrentStatus("Started")
                responseListener.onCurrentStatus("Loading")
                responseListener.onSuccess(User("hehehe"))
                responseListener.onCurrentStatus("Finished")
            }
        } else {
            throw InitializationException("You Should use addListener(this)")
        }
    }

    fun addListener(lis: RequestListener) {
        responseListener = lis
    }

}