package com.onecupcode.onlinetest

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.onecupcode.onlinetest.model.ResultResponseModel
import com.onecupcode.onlinetest.network.ApiHelper
import com.onecupcode.onlinetest.network.RetrofitBuilder
import com.onecupcode.onlinetest.viewmodel.OnlineTestViewModel
import com.onecupcode.onlinetest.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.quize_view.*
import kotlinx.android.synthetic.main.result_lay_out.*

class OnlineTestActivity : AppCompatActivity() {
    private  var resultResponseModel: ResultResponseModel? = null
    private var  countOfQuize: Int = 0
    private lateinit var onlineTestViewModel: OnlineTestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quize_view)

        val factory = ViewModelFactory(ApiHelper(RetrofitBuilder.apiServices))
        onlineTestViewModel = ViewModelProvider(this,factory).get(OnlineTestViewModel::class.java)
        onlineTestViewModel.getOnlineTest(10,11,"easy","multiple").observe(this, Observer {

            it.apply {
                if (data != null) {
                    resultResponseModel = data
                    if (!resultResponseModel?.results?.isEmpty()!!){
                       setUpQuestions(0)
                        countOfQuize++
                    }
                }else{
                    resultResponseModel = null
                }
            }
        })

        nextBtn.setOnClickListener {
            if ((answer_recycler.adapter as QuizeAdapter).getSelectedItem() == ""){

            }else{
                if (resultResponseModel!=null){
                    if (!resultResponseModel?.results?.isEmpty()!!){
                        resultResponseModel?.results!![countOfQuize-1].selectedAnswer = (answer_recycler.adapter as QuizeAdapter).getSelectedItem()
                        if(countOfQuize<resultResponseModel?.results?.size!!){
                            setUpQuestions(countOfQuize)
                            countOfQuize++
                        }else if (resultResponseModel?.results?.size!! == countOfQuize){
                            setResult()
                        }
                    }
                }
                else{
                    countOfQuize=0
                }
            }

        }
    }

    @SuppressLint("SetTextI18n")
    fun setUpQuestions(position: Int){
        questionsNumText.text = "Questions ${position+1}"
        questionsText.text = resultResponseModel?.results?.get(position)?.question
        answer_recycler.adapter = QuizeAdapter(resultResponseModel!!.results[position].incorrect_answers)
    }

    override fun onBackPressed() {

    }

    fun setResult(){
        resultLay.visibility = View.VISIBLE
        resultRecyclerView.adapter = ResultAdapter(resultResponseModel?.results!!)
        var score = 0

        for (result in resultResponseModel?.results!!){
            if (result.correct_answer.equals(result.selectedAnswer)){
                score++
            }
        }

        scoretext.text = "$score"
    }

}