package com.example.praktikum7_245150207111063_faizalrezaabdillah.ui.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.praktikum_6_245150207111063_faizalrezaabdillah.data.repository.StudentRepository
import com.example.praktikum_6_245150207111063_faizalrezaabdillah.ui.home.HomeUiState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class HomeViewModel(
    private val repository: StudentRepository
) : ViewModel() {
    var uiState by mutableStateOf(HomeUiState())
        private set
    init { loadStudents() }
    fun loadStudents() {
        uiState = uiState.copy(isLoading = true, errorMessage = null, searchQuery = "")
        repository.getStudents { result ->
            result
                .onSuccess { data ->
                    uiState = uiState.copy(students = data, isLoading = false, errorMessage = null)
                }
                .onFailure { error ->
                    uiState = uiState.copy(
                        isLoading = false,
                        errorMessage = error.message ?: "Gagal mengambil data"
                    )
                }
        }
    }

    fun onSearchQueryChanged(query: String) {
        uiState = uiState.copy(searchQuery = query)
    }

    fun searchStudents() {
        val query = uiState.searchQuery.trim()
        if (query.isEmpty()) {
            loadStudents()
            return
        }
        uiState = uiState.copy(isLoading = true, errorMessage = null)
        repository.searchStudents(query) { result ->
            result
                .onSuccess { data ->
                    uiState = uiState.copy(students = data, isLoading = false, errorMessage = null)
                }
                .onFailure { error ->
                    uiState = uiState.copy(
                        isLoading = false,
                        errorMessage = error.message ?: "Gagal mencari data"
                    )
                }
        }
    }
}