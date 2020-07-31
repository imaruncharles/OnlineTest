package com.onecupcode.onlinetest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.quize_check_box_view.view.*

 class QuizeAdapter(val answerList : ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var slectedAnswer = ""
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return VHolder(LayoutInflater.from(parent.context).inflate(R.layout.quize_check_box_view,parent,false))
    }

    override fun getItemCount(): Int {
        return answerList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.answer_text.text = answerList[position]
        holder.itemView.radio_btn.isChecked = false

        holder.itemView.setOnClickListener {
            this.slectedAnswer = answerList[position]
            holder.itemView.radio_btn.isChecked = true

           for (p in 0..answerList.size){
               if (position!=p){
                   notifyItemChanged(p)
               }
           }
        }
    }

    class VHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var answerText = itemView.findViewById<TextView>(R.id.answer_text)
        val radioBtn = itemView.findViewById<RadioButton>(R.id.radio_btn)
    }

    fun getSelectedItem(): String{
        return this.slectedAnswer
    }
}