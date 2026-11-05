
package com.example.praktikum_6_245150207111063_faizalrezaabdillah.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktikum7_245150207111063_faizalrezaabdillah.ui.detail.DetailUiState


@Composable
fun DetailScreen(
    uiState: DetailUiState,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "Detail Student",
            style = MaterialTheme.typography.headlineMedium
        )

        when {
            uiState.errorMessage != null -> {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            "Mahasiswa Tidak Ditemukan",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text(uiState.errorMessage)

                        Button(onClick = onBack) {
                            Text("Kembali ke Home")
                        }
                    }
                }
            }


            uiState.student != null -> {
                val student = uiState.student

                student?.let { data ->
                    Text(data.name, style = MaterialTheme.typography.headlineSmall)
                    Text("Email: ${data.email}")
                    Text("University: ${data.university}")
                }

                Button(onClick = onBack) {
                    Text("Kembali")
                }
            }
        }
    }
}
