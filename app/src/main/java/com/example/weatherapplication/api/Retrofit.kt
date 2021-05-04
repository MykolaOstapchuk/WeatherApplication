package com.example.weatherapplication.api

import com.example.weatherapplication.utils.Constants.Companion.TEST_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofitinstance {

    //.baseUrl(BASE_URL)
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(TEST_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    val api : SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }

}