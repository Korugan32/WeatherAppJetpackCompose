package com.korugan.weatherappjetpackcompose.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.korugan.weatherappjetpackcompose.util.api.forecastWeatherApi.data.ForecastWeatherModel

@Composable
fun Forecast(forecastData: ForecastWeatherModel, index : Int, navController : NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.clickable { navController.navigate("forecastDetails" + "?index=${index}") } ) {
        AsyncImage(model = "https:" + forecastData.forecast.forecastday[index].day.condition.icon, contentDescription = "", modifier = Modifier.size(150.dp))
        Text(text = forecastData.forecast.forecastday[index].date, color = Color.White)
        Text(text = forecastData.forecast.forecastday[index].day.condition.text, color = Color.White)
    }
}