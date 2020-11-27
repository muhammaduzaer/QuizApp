package com.muhammaduzaer.quizapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammaduzaer.quizapp.R
import com.muhammaduzaer.quizapp.adapter.OptionsAdapter
import com.muhammaduzaer.quizapp.models.Questions
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        bindViews()
    }

    private fun bindViews() {
        val question = Questions(
            "Which is the bird that can fly backwards?",
            "Sunbird",
            "Kingfisher",
            "Honey Eater",
            "Humming Bird",
            "Humming Bird"
        )

        textViewDescription.text = question.description
        val optionsAdapter = OptionsAdapter(this, question)
        recyclerViewOptionsList.layoutManager = LinearLayoutManager(this)
        recyclerViewOptionsList.adapter = optionsAdapter
        recyclerViewOptionsList.setHasFixedSize(true)
    }
}