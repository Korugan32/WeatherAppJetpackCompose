package com.korugan.weatherappjetpackcompose.util.api.forecastWeatherApi

import com.korugan.weatherappjetpackcompose.util.api.forecastWeatherApi.ForecastWeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiForecast {
    @GET("/v1/forecast.json")
    suspend fun getForecastWeather(
        @Query("key") apiKey : String,
        @Query("q") city : String,
        @Query("days") days : String,
    ) : Response<ForecastWeatherModel>
}
