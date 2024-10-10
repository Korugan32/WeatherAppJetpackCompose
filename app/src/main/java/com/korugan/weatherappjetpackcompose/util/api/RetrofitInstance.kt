package com.korugan.weatherappjetpackcompose.util.api

import com.korugan.weatherappjetpackcompose.util.api.forecastWeatherApi.WeatherApiForecast
import com.korugan.weatherappjetpackcompose.util.api.todayWeatherApi.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val URL = "https://api.weatherapi.com"

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val weatherApi : WeatherApi = getInstance().create(WeatherApi::class.java)
    val weatherForecastApi : WeatherApiForecast = getInstance().create(WeatherApiForecast::class.java)
}