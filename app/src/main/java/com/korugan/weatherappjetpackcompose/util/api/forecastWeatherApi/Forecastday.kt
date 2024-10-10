package com.korugan.weatherappjetpackcompose.util.api.forecastWeatherApi

data class Forecastday(
    val astro: Astro,
    val date: String,
    val date_epoch: Int,
    val day: Day,
    val hour: List<Hour>
)