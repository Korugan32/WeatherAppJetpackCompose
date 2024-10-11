package com.korugan.weatherappjetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.korugan.weatherappjetpackcompose.ui.theme.WeatherAppJetpackComposeTheme
import com.korugan.weatherappjetpackcompose.util.navigation.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppJetpackComposeTheme {
            Navigation()
            }
        }
    }
}