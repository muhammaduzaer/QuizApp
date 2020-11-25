package com.muhammaduzaer.quizapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.muhammaduzaer.quizapp.R
import com.muhammaduzaer.quizapp.activities.logins.LoginActivity
import com.muhammaduzaer.quizapp.adapter.QuizAdapter
import com.muhammaduzaer.quizapp.models.Quiz
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    lateinit var adapter: QuizAdapter
    private var quizList = mutableListOf<Quiz>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()

        populateDummyData()
        setUpViews()

        textViewLogOut.setOnClickListener{
            firebaseAuth.signOut()
            val logOutfromDrawer = Intent(this, LoginActivity::class.java)
            startActivity(logOutfromDrawer)
            finish()
        }
    }

    private fun populateDummyData() {
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
        quizList.add(Quiz("12-12-2020", "13-12-2020"))
    }

    fun setUpViews() {
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        adapter = QuizAdapter(this, quizList )
        recylerViewQuiz.layoutManager = GridLayoutManager(this, 1)
        recylerViewQuiz.adapter = adapter
    }


}


