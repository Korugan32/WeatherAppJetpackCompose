package com.korugan.weatherappjetpackcompose.presentation.screens.forecast

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.korugan.weatherappjetpackcompose.presentation.viewmodel.WeatherViewModel
import com.korugan.weatherappjetpackcompose.util.api.NetworkResponse

@Composable
fun ForecastPage(navController: NavHostController, viewModel: WeatherViewModel, index: Int) {
    val forecastWeatherResult = viewModel.weatherForecastResult_.observeAsState()
    when (val result = forecastWeatherResult.value) {
        is NetworkResponse.Error -> {
            Text(text = result.message, color = Color.White)
        }

        NetworkResponse.Loading -> {
            CircularProgressIndicator()
        }

        is NetworkResponse.Success -> {
            ForecastDetails(result.data, navController, index)
        }

        null -> {}
    }

}