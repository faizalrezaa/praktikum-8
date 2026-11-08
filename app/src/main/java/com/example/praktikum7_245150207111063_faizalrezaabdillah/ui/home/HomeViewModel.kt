package com.example.praktikum7_245150207111063_faizalrezaabdillah.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.praktikum_6_245150207111063_faizalrezaabdillah.data.repository.StudentRepository
import com.example.praktikum_6_245150207111063_faizalrezaabdillah.ui.home.HomeUiState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: StudentRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    init {
        observeSearch()
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    @OptIn(FlowPreview::class)
    private fun observeSearch() {
        viewModelScope.launch {
            searchQuery
                .debounce(500)
                .distinctUntilChanged()
                .collectLatest { query ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = true,
                        errorMessage = null
                    )
                    try {
                        val data = if (query.isBlank()) {
                            repository.getStudents()
                        } else {
                            repository.searchStudents(query)
                        }
                        _uiState.value = HomeUiState(students = data)
                    } catch (e: CancellationException) {
                        throw e
                    } catch (e: Exception) {
                        _uiState.value = HomeUiState(
                            errorMessage = e.message ?: "Pencarian gagal"
                        )
                    }
                }
        }
    }

    fun retry() {
        refresh()
    }

    fun refresh() {
        val query = searchQuery.value
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
            try {
                val data = if (query.isBlank()) {
                    repository.getStudents()
                } else {
                    repository.searchStudents(query)
                }
                _uiState.value = _uiState.value.copy(
                    students = data,
                    isLoading = false,
                    errorMessage = null
                )
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "Refresh gagal"
                )
            }
        }
    }
}

class HomeViewModelFactory(
    private val repository: StudentRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}
