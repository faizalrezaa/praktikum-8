package com.example.praktikum7_245150207111063_faizalrezaabdillah.data.repository

import com.example.praktikum7_245150207111063_faizalrezaabdillah.data.model.Student
import com.example.praktikum7_245150207111063_faizalrezaabdillah.data.remote.StudentRemoteDataSource
import com.example.praktikum7_245150207111063_faizalrezaabdillah.data.remote.dto.toStudent
import com.example.praktikum_6_245150207111063_faizalrezaabdillah.data.repository.StudentRepository

class DefaultStudentRepository(
    private val remoteDataSource: StudentRemoteDataSource
) : StudentRepository {
    override fun getStudents(
        callback: (Result<List<Student>>) -> Unit
    ) {
        remoteDataSource.getStudents { result ->
            callback(result.map { users -> users.map { it.toStudent() } })
        }
    }
    override fun searchStudents(
        query: String,
        callback: (Result<List<Student>>) -> Unit
    ) {
        remoteDataSource.searchStudents(query) { result ->
            callback(result.map { users -> users.map { it.toStudent() } })
        }
    }
    override fun getStudent(
        id: Int,
        callback: (Result<Student>) -> Unit
    ) {
        remoteDataSource.getStudent(id) { result ->
            callback(result.map { it.toStudent() })
        }
    }
}