package com.example.praktikum_6_245150207111063_faizalrezaabdillah.data.repository



import com.example.praktikum7_245150207111063_faizalrezaabdillah.data.model.Student

interface StudentRepository {
    suspend fun getStudents(): List<Student>
    suspend fun getStudent(id: Int): Student
    suspend fun searchStudents(query: String): List<Student>
}