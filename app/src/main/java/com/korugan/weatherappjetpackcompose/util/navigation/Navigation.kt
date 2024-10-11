package com.korugan.weatherappjetpackcompose.util.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.korugan.weatherappjetpackcompose.presentation.screens.forecast.ForecastPage
import com.korugan.weatherappjetpackcompose.presentation.screens.weather.WeatherPage
import com.korugan.weatherappjetpackcompose.presentation.viewmodel.WeatherViewModel

@Composable
fun Navigation() {
    val weatherViewModel: WeatherViewModel = viewModel()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "WeatherPage") {
        composable(route = "WeatherPage") {
            WeatherPage(navController, weatherViewModel)
        }
        composable(
            route = "ForecastDetails" + "?index={index}",
            arguments = listOf(
                navArgument("index") {
                    type = NavType.IntType
                }
            )
        ) {
            val index = it.arguments!!.getInt("index")
            ForecastPage(navController, weatherViewModel, index)

        }

    }

}
