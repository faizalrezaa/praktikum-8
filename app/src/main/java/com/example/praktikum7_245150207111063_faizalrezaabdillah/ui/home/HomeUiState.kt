package com.example.praktikum_6_245150207111063_faizalrezaabdillah.ui.home

import com.example.praktikum7_245150207111063_faizalrezaabdillah.data.model.Student

data class HomeUiState(
    val students: List<Student> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val searchQuery: String = ""
)