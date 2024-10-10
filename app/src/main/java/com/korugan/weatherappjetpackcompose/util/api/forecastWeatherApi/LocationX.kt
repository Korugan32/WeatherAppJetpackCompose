package com.korugan.weatherappjetpackcompose.util.api.forecastWeatherApi

data class LocationX(
    val country: String,
    val lat: Double,
    val localtime: String,
    val localtime_epoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    val tz_id: String
)