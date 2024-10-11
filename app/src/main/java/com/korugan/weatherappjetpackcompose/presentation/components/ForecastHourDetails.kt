package com.korugan.weatherappjetpackcompose.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.korugan.weatherappjetpackcompose.R
import com.korugan.weatherappjetpackcompose.util.api.forecastWeatherApi.data.ForecastWeatherModel

@Composable
fun ForecastHourDetails(forecastData: ForecastWeatherModel, index: Int, hIndex: Int) {
    Column( horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(1.dp)) {
        Text(text = forecastData.forecast.forecastday[index].hour[hIndex].time.drop(11), color = Color.White)
        AsyncImage(
            model = "https:" + forecastData.forecast.forecastday[index].hour[hIndex].condition.icon,
            contentDescription = "",
            modifier = Modifier.size(80.dp)
        )
        Text(text = forecastData.forecast.forecastday[index].hour[hIndex].condition.text, color = Color.White)
        Text(text = forecastData.forecast.forecastday[index].hour[hIndex].temp_c + "℃", color = Color.White)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.humidity_svgrepo_com),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
            Text(text = forecastData.forecast.forecastday[index].hour[hIndex].humidity, color = Color.White)
        }
    }
}