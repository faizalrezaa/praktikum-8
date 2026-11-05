package com.example.praktikum_6_245150207111063_faizalrezaabdillah.data.repository



import com.example.praktikum7_245150207111063_faizalrezaabdillah.data.model.Student

interface StudentRepository {
    fun getStudents(callback: (Result<List<Student>>) -> Unit)
    fun searchStudents(query: String, callback: (Result<List<Student>>) -> Unit)
    fun getStudent(id: Int, callback: (Result<Student>) -> Unit)
}