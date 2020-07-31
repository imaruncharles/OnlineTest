package com.onecupcode.onlinetest.model

import com.google.gson.annotations.SerializedName


/*
* {"category":"Entertainment: Film",
* "type":"multiple","difficulty":"easy",
* "question":"What breed of dog was Marley in the film &quot;Marley &amp; Me&quot; (2008)?",
* "correct_answer":"Labrador Retriever",
* "incorrect_answers":["Golden Retriever","Dalmatian","Shiba Inu"]*/

data class ResultModel(@SerializedName("category") val category: String,
                       @SerializedName("type") val type: String,
                       @SerializedName("question") val question: String,
                       @SerializedName("correct_answer") val correct_answer: String,
                       var selectedAnswer: String,
                       @SerializedName("incorrect_answers") val incorrect_answers: ArrayList<String>)