package com.onecupcode.onlinetest.network

class ApiHelper(private var apiServices: ApiServices) {
    suspend fun getOnlineTest(amount: Int,category: Int,difficulty: String,type: String) = apiServices.getOnlineTest(amount,category,difficulty,type)
}