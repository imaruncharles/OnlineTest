package com.onecupcode.onlinetest.model

import com.google.gson.annotations.SerializedName

/*
* response_code":0,"results*/
data class ResultResponseModel(
    @SerializedName("response_code")val response_code : String,@SerializedName("results") val results: ArrayList<ResultModel> )