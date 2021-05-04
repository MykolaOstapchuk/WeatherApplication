package com.example.weatherapplication.api

import com.example.weatherapplication.model.Post
import com.example.weatherapplication.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost() : Response<Post>

    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") city : String,
        @Query("units") units : String,
        @Query("appid") apikey : String
    ) : Response<Weather>
}

