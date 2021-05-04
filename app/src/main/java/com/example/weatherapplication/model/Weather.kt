package com.example.weatherapplication.model

data class Weather(
    val name: String,
    val id: Number,
    val main : MainDetail,
    val weather: ArrayList<WeatherDetail>
)

data class WeatherDetail(
    val main: String,
    val description: String,
    val icon : String
)

data class MainDetail(
    val temp: Double,
    val feels_like: Double,
    val temp_min : Double,
    val temp_max : Double
)