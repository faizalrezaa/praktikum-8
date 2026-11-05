package com.example.praktikum7_245150207111063_faizalrezaabdillah.data.remote.dto

import com.example.praktikum7_245150207111063_faizalrezaabdillah.data.model.Student

fun UserDto.toStudent() = Student(
    id = id,
    name = "$firstName $lastName",
    email = email,
    university = university
)