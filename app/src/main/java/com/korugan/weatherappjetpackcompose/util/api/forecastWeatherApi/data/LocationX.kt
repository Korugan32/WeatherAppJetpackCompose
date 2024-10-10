package com.korugan.weatherappjetpackcompose.util.api.forecastWeatherApi.data

data class LocationX(
    val country: String,
    val lat: String,
    val localtime: String,
    val localtime_epoch: String,
    val lon: String,
    val name: String,
    val region: String,
    val tz_id: String
)