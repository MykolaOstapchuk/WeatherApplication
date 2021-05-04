package com.example.weatherapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.model.Post
import com.example.weatherapplication.model.Weather
import com.example.weatherapplication.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel(){

    val myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2 : MutableLiveData<Response<Weather>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response  = repository.getPost()
            myResponse.value = response
        }
    }

    fun getWeather(city :String, apikey : String){
        viewModelScope.launch {
            val response = repository.getWeather(city,apikey)
            myResponse2.value = response
        }
    }
}