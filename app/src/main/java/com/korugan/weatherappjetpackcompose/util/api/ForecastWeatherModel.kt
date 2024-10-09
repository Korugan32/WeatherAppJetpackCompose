package com.korugan.weatherappjetpackcompose.util.api

data class ForecastWeatherModel(
    val current: CurrentX,
    val forecast: Forecast,
    val location: LocationX
)