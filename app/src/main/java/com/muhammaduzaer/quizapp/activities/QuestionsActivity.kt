package com.muhammaduzaer.quizapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.muhammaduzaer.quizapp.R
import com.muhammaduzaer.quizapp.adapter.OptionsAdapter
import com.muhammaduzaer.quizapp.models.Questions
import com.muhammaduzaer.quizapp.models.Quiz
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {

    var quizzes : MutableList<Quiz>? = null
    var questions: MutableMap<String, Questions>? = null
    var index = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        setUpFireStore()
        setUpEventListener()
    }

    private fun setUpEventListener() {
        buttonPrevious.setOnClickListener {
            index--
            bindViews()
        }

        buttonNext.setOnClickListener {
            index++
            bindViews()
        }

        buttonSubmit.setOnClickListener {
            Log.d("FINALQUIZ", questions.toString())

            val intent = Intent(this, ResultActivity::class.java)
            val json = Gson().toJson(quizzes!![0])
            intent.putExtra("QUIZ", json)
            startActivity(intent)
        }
    }

    private fun setUpFireStore() {
        val firestore = FirebaseFirestore.getInstance()
        val date = intent.getStringExtra("DATE")
        if(date != null) {
            firestore.collection("quizzes").whereEqualTo("title", date)
                .get()
                .addOnSuccessListener {
                    if(it != null && !it.isEmpty) {
                        quizzes = it.toObjects(Quiz::class.java)
                        questions = quizzes!![0].questions
                        bindViews()
                    }
                }

        }

    }



    private fun bindViews() {
        buttonPrevious.visibility = View.GONE
        buttonSubmit.visibility = View.GONE
        buttonNext.visibility = View.GONE

        if (index == 1) {
            buttonNext.visibility = View.VISIBLE
        }
        else if(index == questions!!.size) {
            buttonSubmit.visibility = View.VISIBLE
            buttonPrevious.visibility = View.VISIBLE

        } else {
            buttonPrevious.visibility = View.VISIBLE
            buttonNext.visibility = View.VISIBLE
        }

        val question = questions!!["question$index"]
        question?.let {
            textViewDescription.text = it.description
            val optionsAdapter = OptionsAdapter(this, it)
            recyclerViewOptionsList.layoutManager = LinearLayoutManager(this)
            recyclerViewOptionsList.adapter = optionsAdapter
            recyclerViewOptionsList.setHasFixedSize(true)
        }


    }
}