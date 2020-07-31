package com.onecupcode.onlinetest.network
import com.onecupcode.onlinetest.model.ResultResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    //https://opentdb.com/api.php?amount=10&category=11&difficulty=easy&type=multiple
    @GET("api.php?")
    suspend fun getOnlineTest(@Query("amount") amount: Int,@Query("category") category: Int,
    @Query("difficulty") difficulty : String, @Query("type") type: String): ResultResponseModel

}