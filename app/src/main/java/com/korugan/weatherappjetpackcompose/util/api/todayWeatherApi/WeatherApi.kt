package com.korugan.weatherappjetpackcompose.util.api.todayWeatherApi

import com.korugan.weatherappjetpackcompose.util.api.todayWeatherApi.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("key") apiKey : String,
        @Query("q") city : String,
    ) : Response<WeatherModel>
}