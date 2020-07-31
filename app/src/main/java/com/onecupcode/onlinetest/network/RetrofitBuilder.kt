package com.onecupcode.onlinetest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://opentdb.com"

    private fun getRetrofit() : Retrofit{

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiServices: ApiServices = getRetrofit().create(ApiServices::class.java)
}