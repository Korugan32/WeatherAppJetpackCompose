package com.korugan.weatherappjetpackcompose.util.api.forecastWeatherApi.data

data class Day(
    val avghumidity: String,
    val avgtemp_c: String,
    val avgtemp_f: String,
    val avgvis_km: String,
    val avgvis_miles: String,
    val condition: ConditionX,
    val daily_chance_of_rain: String,
    val daily_chance_of_snow: String,
    val daily_will_it_rain: String,
    val daily_will_it_snow: String,
    val maxtemp_c: String,
    val maxtemp_f: String,
    val maxwind_kph: String,
    val maxwind_mph: String,
    val mStringemp_c: String,
    val mStringemp_f: String,
    val totalprecip_in: String,
    val totalprecip_mm: String,
    val totalsnow_cm: String,
    val uv: String
)