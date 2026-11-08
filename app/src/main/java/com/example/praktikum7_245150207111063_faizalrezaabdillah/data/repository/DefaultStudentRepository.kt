package com.example.praktikum7_245150207111063_faizalrezaabdillah.data.repository

import com.example.praktikum7_245150207111063_faizalrezaabdillah.data.model.Student
import com.example.praktikum7_245150207111063_faizalrezaabdillah.data.remote.StudentRemoteDataSource
import com.example.praktikum7_245150207111063_faizalrezaabdillah.data.remote.dto.toStudent
import com.example.praktikum_6_245150207111063_faizalrezaabdillah.data.repository.StudentRepository

class DefaultStudentRepository(
    private val remoteDataSource: StudentRemoteDataSource
) : StudentRepository {
    override suspend fun getStudents(): List<Student> =
        remoteDataSource.getStudents().map { it.toStudent() }
    override suspend fun getStudent(id: Int): Student =
        remoteDataSource.getStudent(id).toStudent()
    override suspend fun searchStudents(query: String): List<Student> =
        remoteDataSource.searchStudents(query).map { it.toStudent() }
}