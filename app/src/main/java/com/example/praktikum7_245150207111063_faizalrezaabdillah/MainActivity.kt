package com.example.praktikum_6_245150207111063_faizalrezaabdillah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.praktikum7_245150207111063_faizalrezaabdillah.ui.theme.Praktikum6_245150207111063_FaizalRezaAbdillahTheme
import com.example.praktikum_6_245150207111063_faizalrezaabdillah.ui.navigation.NavigationLabApp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Praktikum6_245150207111063_FaizalRezaAbdillahTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavigationLabApp()
                }
            }
        }
    }
}