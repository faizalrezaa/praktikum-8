package com.example.praktikum7_245150207111063_faizalrezaabdillah.data.remote.dto

data class UserResponse(
    val users: List<UserDto>,
    val total: Int,
    val skip: Int,
    val limit: Int
)