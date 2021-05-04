package com.example.weatherapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapplication.repository.Repository

class MainViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.Factory  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(repository) as T
        throw IllegalArgumentException(modelClass.name + "Not found.")
    }

}