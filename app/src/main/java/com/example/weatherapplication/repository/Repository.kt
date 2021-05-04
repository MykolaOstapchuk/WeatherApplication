package com.example.weatherapplication.repository

import com.example.weatherapplication.api.Retrofitinstance
import com.example.weatherapplication.model.Post
import com.example.weatherapplication.model.Weather
import com.example.weatherapplication.utils.Constants.Companion.UNITS
import retrofit2.Response

class Repository {

    suspend fun getPost() : Response<Post> {
        return Retrofitinstance.api.getPost();
    }

    suspend fun getWeather(city : String , apikey : String) : Response<Weather>{
        return Retrofitinstance.api.getWeather(city,UNITS,apikey)
    }
}