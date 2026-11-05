//package com.example.praktikum6_245150207111063_faizalrezaabdillah.data.source
//
//import com.example.praktikum6_245150207111063_faizalrezaabdillah.data.model.Student
//
//
//class StudentLocalDataSource {
//    private val students = listOf(
//        Student(2026, "Alya Putri", "Teknik Informatika", 2026),
//        Student(2027, "Bima Pratama", "Teknik Informatika", 2026),
//        Student(2028, "Citra Lestari", "Teknik Informatika", 2026),
//        Student(2029, "Dinda Maharani", "Teknik Informatika", 2026),
//        Student(2030, "Rizky Ramadhan", "Teknik Informatika", 2026)
//    )
//
//    fun getStudents(): List<Student> = students
//
//    fun getStudentById(id: Int): Student? =
//        students.find { it.id == id }
//}