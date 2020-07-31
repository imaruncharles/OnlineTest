package com.onecupcode.onlinetest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onecupcode.onlinetest.network.ApiHelper

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OnlineTestViewModel::class.java)){
            return OnlineTestViewModel(apiHelper) as T
        }

        throw IllegalAccessException("Unknown class name" + "")
    }
}