package com.muhammaduzaer.quizapp.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.muhammaduzaer.quizapp.R
import com.muhammaduzaer.quizapp.adapter.OptionsAdapter
import com.muhammaduzaer.quizapp.models.Questions
import com.muhammaduzaer.quizapp.models.Quiz
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        bindViews()
        setUpFireStore()
    }

    private fun setUpFireStore() {
        val firestore = FirebaseFirestore.getInstance()
        firestore.collection("quizzes").whereEqualTo("title", "11-12-2020")
            .get()
            .addOnSuccessListener {
                Log.d("DATA", it.toObjects(Quiz::class.java).toString())
            }
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