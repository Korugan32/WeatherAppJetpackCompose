package com.korugan.weatherappjetpackcompose.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.korugan.weatherappjetpackcompose.util.api.forecastWeatherApi.ForecastWeatherModel
import com.korugan.weatherappjetpackcompose.util.api.NetworkResponse
import com.korugan.weatherappjetpackcompose.util.api.RetrofitInstance
import com.korugan.weatherappjetpackcompose.util.api.todayWeatherApi.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val weatherApi = RetrofitInstance.weatherApi
    private val forecastWeatherApi = RetrofitInstance.weatherForecastApi
    private val weatherForecastResult = MutableLiveData<NetworkResponse<ForecastWeatherModel>>()
    val weatherForecastResult_ : LiveData<NetworkResponse<ForecastWeatherModel>> = weatherForecastResult
    private val weatherResult = MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult_ : LiveData<NetworkResponse<WeatherModel>> = weatherResult

    fun getTodayData(city: String) {
        weatherResult.value = NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val response = weatherApi.getWeather("d47f96efd4814cfbbdb123512242505", city)
                if (response.isSuccessful){
                    response.body()?.let {
                        weatherResult.value = NetworkResponse.Success(it)
                    }
                }else{
                    weatherResult.value = NetworkResponse.Error("Error")
                }
            }catch (e : Exception){
                weatherResult.value = NetworkResponse.Error("Error : $e")
            }

        }
    }

    fun getForecastData(city: String) {
        weatherForecastResult.value = NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val response = forecastWeatherApi.getForecastWeather("d47f96efd4814cfbbdb123512242505", city, "5")
                if (response.isSuccessful){
                    response.body()?.let {
                        weatherForecastResult.value = NetworkResponse.Success(it)
                    }
                }else{
                    weatherForecastResult.value = NetworkResponse.Error("Error")
                }
            }catch (e : Exception){
                weatherForecastResult.value = NetworkResponse.Error("Error : $e")
            }

        }
    }

}