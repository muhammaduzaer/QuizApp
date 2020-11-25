package com.muhammaduzaer.quizapp.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.muhammaduzaer.quizapp.R
import com.muhammaduzaer.quizapp.models.Quiz
import com.muhammaduzaer.quizapp.utils.ColorPicker
import com.muhammaduzaer.quizapp.utils.IconPicker

class QuizAdapter(val context: Context, val quizzes: List<Quiz>) :
    RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.quiz_items, parent, false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.textViewTitle.text = quizzes[position].title
        holder.container.setBackgroundColor(Color.parseColor(ColorPicker.getColor()))
        holder.imageViewIcon.setImageResource(IconPicker.getIcons())
    }

    override fun getItemCount(): Int {
        return quizzes.size
    }

    inner class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageViewIcon: ImageView = itemView.findViewById(R.id.imageViewQuizIcon)
        var textViewTitle: TextView = itemView.findViewById(R.id.textViewQuizTitle)
        var container: ConstraintLayout = itemView.findViewById(R.id.layoutContainer)
    }
}