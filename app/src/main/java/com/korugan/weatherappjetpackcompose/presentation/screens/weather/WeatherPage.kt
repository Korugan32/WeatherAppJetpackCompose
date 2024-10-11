package com.korugan.weatherappjetpackcompose.presentation.screens.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.korugan.weatherappjetpackcompose.presentation.components.Forecast
import com.korugan.weatherappjetpackcompose.presentation.viewmodel.WeatherViewModel
import com.korugan.weatherappjetpackcompose.ui.theme.DarkBlue
import com.korugan.weatherappjetpackcompose.ui.theme.DarkPurple
import com.korugan.weatherappjetpackcompose.util.api.NetworkResponse


@Composable
fun WeatherPage(navController: NavHostController, viewModel: WeatherViewModel) {

    var city by remember { mutableStateOf("") }

    val weatherResult = viewModel.weatherResult_.observeAsState()
    val forecastWeatherResult = viewModel.weatherForecastResult_.observeAsState()


    Column(
        modifier = Modifier
            .background(brush = Brush.verticalGradient(listOf(DarkBlue, DarkPurple)))
            .fillMaxSize()
            .padding(10.dp)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                textStyle = TextStyle(color = Color.White),
                modifier = Modifier.width(370.dp),
                value = city,
                onValueChange = { city = it },
                label = {
                    Text(text = "Search Any Location", color = Color.White)
                })
            IconButton(onClick = { viewModel.getTodayData(city); viewModel.getForecastData(city) }) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    tint = Color.White,
                    contentDescription = "Search",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(15.dp))
        when (val result = weatherResult.value) {
            is NetworkResponse.Error -> {
                if (city != "") {
                    Text(text = result.message, color = Color.White)
                } else {
                    Text(text = "Error : Please Enter City Name!", color = Color.White)
                }

            }

            NetworkResponse.Loading -> {
                CircularProgressIndicator()
            }

            is NetworkResponse.Success -> {
                when (val result2 = forecastWeatherResult.value) {
                    is NetworkResponse.Error -> {
                        Text(text = result2.message, color = Color.White)
                    }

                    NetworkResponse.Loading -> {
                        CircularProgressIndicator()
                    }

                    is NetworkResponse.Success -> {
                        WeatherDetails(todayData = result.data)
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            items(result2.data.forecast.forecastday.size) { index ->
                                Forecast(result2.data, index, navController)
                            }
                        }

                    }

                    null -> {}
                }
            }

            null -> {}
        }
    }
}
