package com.training.app.apiRequest

import com.training.app.recyclerview.User

data class ApiResponse(
    val message: String,
    val status: String,
    val code: Int,
    val data: ResponseUser
)

