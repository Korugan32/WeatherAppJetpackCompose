package com.korugan.weatherappjetpackcompose.util.api.forecastWeatherApi.data

data class Astro(
    val is_moon_up: String,
    val is_sun_up: String,
    val moon_illumination: String,
    val moon_phase: String,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)