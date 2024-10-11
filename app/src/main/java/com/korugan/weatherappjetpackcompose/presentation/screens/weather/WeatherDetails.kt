package com.korugan.weatherappjetpackcompose.presentation.screens.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
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
import com.korugan.weatherappjetpackcompose.util.api.todayWeatherApi.data.WeatherModel

@Composable
fun WeatherDetails(todayData: WeatherModel) {
    Column() {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            AsyncImage(model = "https:" + todayData.current.condition.icon, contentDescription = "", modifier = Modifier.size(180.dp))
            Text(text = todayData.current.condition.text, color = Color.White)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Column(modifier = Modifier.padding(10.dp)) {
            Row {
                Icon(imageVector = Icons.Outlined.LocationOn, contentDescription = "", tint = Color.White)
                Text(text = todayData.location.name, color = Color.White)
                Text(text = "/", color = Color.White)
                Text(text = todayData.location.country, color = Color.White)
            }

            Row {
                Icon(
                    painter = painterResource(id = R.drawable.humidity_svgrepo_com),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp),
                    tint = Color.White
                )
                Text(text = todayData.current.humidity, color = Color.White)
            }
            Row {
                Text(text = "℃/℉ " + todayData.current.temp_c + " / " + todayData.current.temp_f, color = Color.White)
            }
            Row {
                Text(text = "Wind Direction: ", color = Color.White)
                Text(text = todayData.current.wind_dir, color = Color.White)
            }
            Row {
                Text(text = "Wind KPH: ", color = Color.White)
                Text(text = todayData.current.wind_kph, color = Color.White)
            }
            Row {
                Text(text = "Windchill:  ", color = Color.White)
                Text(text = todayData.current.windchill_c, color = Color.White)
            }
        }
    }
}