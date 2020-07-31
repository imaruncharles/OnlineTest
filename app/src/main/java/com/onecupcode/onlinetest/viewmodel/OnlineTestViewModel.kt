package com.onecupcode.onlinetest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.onecupcode.onlinetest.network.ApiHelper
import com.onecupcode.onlinetest.network.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class OnlineTestViewModel(private val apiHelper: ApiHelper): ViewModel() {

    fun getOnlineTest(amount: Int,category: Int,difficulty: String,type: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiHelper.getOnlineTest(amount,category,difficulty,type)))
        }catch (exception: Exception){
            emit(Resource.error(data = null,message = exception.message ?: "Error Occurred"))
        }
    }
}