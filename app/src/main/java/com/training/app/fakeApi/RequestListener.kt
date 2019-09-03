package com.training.app.fakeApi

import java.lang.Exception

interface RequestListener {

    fun onSuccess(data: User)

    fun onError(ex: Exception)

    fun onCurrentStatus(status: String)

}
