package com.muhammaduzaer.quizapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.muhammaduzaer.quizapp.R
import com.muhammaduzaer.quizapp.models.Questions

class OptionsAdapter(val context: Context, val questions: Questions) :
    RecyclerView.Adapter<OptionsAdapter.OptionViewHolder>() {

    private var options: List<String> = listOf(questions.option1, questions.option2, questions.option3, questions.option4)

    inner class OptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var optionView = itemView.findViewById<TextView>(R.id.textViewQuizOptions)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.options_list, parent, false)
        return OptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        holder.optionView.text = options[position]
        holder.itemView.setOnClickListener{
            questions.userAnswer = options[position]
            notifyDataSetChanged()
        }
        if(questions.userAnswer == options[position]){
            holder.itemView.setBackgroundResource(R.drawable.option_item_selected_bg)
        }
        else {
            holder.itemView.setBackgroundResource(R.drawable.option_item_bg)
        }
    }

    override fun getItemCount(): Int {
        return options.size
    }


}