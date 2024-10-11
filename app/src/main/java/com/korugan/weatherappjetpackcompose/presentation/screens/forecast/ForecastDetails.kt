package com.korugan.weatherappjetpackcompose.presentation.screens.forecast

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.korugan.weatherappjetpackcompose.R
import com.korugan.weatherappjetpackcompose.presentation.components.ForecastHourDetails
import com.korugan.weatherappjetpackcompose.ui.theme.DarkBlue
import com.korugan.weatherappjetpackcompose.ui.theme.DarkPurple
import com.korugan.weatherappjetpackcompose.util.api.forecastWeatherApi.data.ForecastWeatherModel

@Composable
fun ForecastDetails(forecastData: ForecastWeatherModel, navController: NavHostController, index: Int) {
    Column(
        modifier = Modifier
            .background(brush = Brush.verticalGradient(listOf(DarkBlue, DarkPurple)))
            .fillMaxSize()
            .statusBarsPadding(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.padding(horizontal = 155.dp))
            Text(text = forecastData.forecast.forecastday[index].date, color = Color.White)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = "https:" + forecastData.forecast.forecastday[index].day.condition.icon,
                contentDescription = "",
                modifier = Modifier.size(180.dp)
            )
            Text(text = forecastData.forecast.forecastday[index].day.condition.text, color = Color.White)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Column(modifier = Modifier.padding(10.dp)) {
            Row {
                Icon(imageVector = Icons.Outlined.LocationOn, contentDescription = "", tint = Color.White)
                Text(text = forecastData.location.name, color = Color.White)
                Text(text = "/", color = Color.White)
                Text(text = forecastData.location.country, color = Color.White)
            }

            Row {
                Icon(
                    painter = painterResource(id = R.drawable.humidity_svgrepo_com),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp),
                    tint = Color.White
                )
                Text(text = forecastData.forecast.forecastday[index].day.avghumidity, color = Color.White)
            }
            Row {
                Text(
                    text = "℃/℉ " + forecastData.forecast.forecastday[index].day.avgtemp_c + " / " + forecastData.forecast.forecastday[index].day.avgtemp_f,
                    color = Color.White
                )
            }
            Row {
                Text(text = "Wind KPH: ", color = Color.White)
                Text(text = forecastData.forecast.forecastday[index].day.maxwind_kph, color = Color.White)
            }
            Row {
                Text(text = "Chance Of Rain: ", color = Color.White)
                Text(text = forecastData.forecast.forecastday[index].day.daily_chance_of_rain, color = Color.White)
            }
            Row {
                Text(text = "Sunrise: ", color = Color.White)
                Text(text = forecastData.forecast.forecastday[index].astro.sunrise, color = Color.White)
            }
            Row {
                Text(text = "Sunset: ", color = Color.White)
                Text(text = forecastData.forecast.forecastday[index].astro.sunset, color = Color.White)
            }
            Row {
                Text(text = "Moonrise: ", color = Color.White)
                Text(text = forecastData.forecast.forecastday[index].astro.moonrise, color = Color.White)
            }
            Row {
                Text(text = "Moonset: ", color = Color.White)
                Text(text = forecastData.forecast.forecastday[index].astro.moonset, color = Color.White)
            }
            Spacer(modifier = Modifier.padding(10.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
            ) {
                items(forecastData.forecast.forecastday[index].hour.size) { hIndex ->
                    ForecastHourDetails(forecastData, index, hIndex)
                }
            }
        }
    }
}