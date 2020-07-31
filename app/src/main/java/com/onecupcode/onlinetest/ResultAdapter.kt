package com.onecupcode.onlinetest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.onecupcode.onlinetest.model.ResultModel
import kotlinx.android.synthetic.main.answerresult_view.view.*

class ResultAdapter(val list : ArrayList<ResultModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return VHolder(LayoutInflater.from(parent.context).inflate(R.layout.answerresult_view,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.questions.text = "${position+1} )"+list[position].question
        holder.itemView.correctAnswer.text = "Correct Answer : "+list[position].correct_answer
        holder.itemView.yourAnswer.text = "Your Answer : "+list[position].selectedAnswer
    }

    class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var questions = itemView.findViewById<TextView>(R.id.questions)
        var yourAnswer  = itemView.findViewById<TextView>(R.id.yourAnswer)
        var correctAnswer = itemView.findViewById<TextView>(R.id.correctAnswer)
    }
}