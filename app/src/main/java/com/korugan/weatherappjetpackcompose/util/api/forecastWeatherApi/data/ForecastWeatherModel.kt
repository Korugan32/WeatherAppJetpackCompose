package com.korugan.weatherappjetpackcompose.util.api.forecastWeatherApi.data

data class ForecastWeatherModel(
    val current: CurrentX,
    val forecast: Forecast,
    val location: LocationX
)