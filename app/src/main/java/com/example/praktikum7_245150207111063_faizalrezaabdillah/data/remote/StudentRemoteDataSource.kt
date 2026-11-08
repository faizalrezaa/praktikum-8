package com.example.praktikum7_245150207111063_faizalrezaabdillah.data.remote

import com.example.praktikum7_245150207111063_faizalrezaabdillah.data.remote.dto.UserDto

class StudentRemoteDataSource(
    private val api: StudentApiService
) {
    suspend fun getStudents(): List<UserDto> =
        api.getUsers(limit = 10).users
    suspend fun getStudent(id: Int): UserDto =
        api.getUser(id)
    suspend fun searchStudents(query: String): List<UserDto> =
        api.searchUsers(query).users
}