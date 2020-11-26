package com.muhammaduzaer.quizapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.muhammaduzaer.quizapp.R
import com.muhammaduzaer.quizapp.activities.logins.LoginActivity
import com.muhammaduzaer.quizapp.adapter.QuizAdapter
import com.muhammaduzaer.quizapp.models.Quiz
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.top_bar.*


class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var adapter: QuizAdapter
    private var quizList = mutableListOf<Quiz>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()

        populateDummyData()
        setUpViews()

        imageButtonOpenDrawer.setOnClickListener{
            mainDrawer.openDrawer(navigation)
        }

        imageButtonCloseDrawer.setOnClickListener{
            mainDrawer.closeDrawer(navigation)
        }

        textViewLogOut.setOnClickListener{
            firebaseAuth.signOut()
            val logOutfromDrawer = Intent(this, LoginActivity::class.java)
            startActivity(logOutfromDrawer)
            finish()
        }
    }

    private fun populateDummyData() {
        quizList.add(Quiz("12-12-2020", "Quiz 1"))
        quizList.add(Quiz("12-12-2020", "Quiz 2"))
        quizList.add(Quiz("12-12-2020", "Quiz 3"))
        quizList.add(Quiz("12-12-2020", "Quiz 4"))
        quizList.add(Quiz("12-12-2020", "Quiz 5"))
        quizList.add(Quiz("12-12-2020", "Quiz 6"))
        quizList.add(Quiz("12-12-2020", "Quiz 7"))
        quizList.add(Quiz("12-12-2020", "Quiz 8"))
        quizList.add(Quiz("12-12-2020", "Quiz 9"))
        quizList.add(Quiz("12-12-2020", "Quiz 10"))
        quizList.add(Quiz("12-12-2020", "Quiz 11"))
        quizList.add(Quiz("12-12-2020", "Quiz 12"))
        quizList.add(Quiz("12-12-2020", "Quiz 13"))
        quizList.add(Quiz("12-12-2020", "Quiz 14"))
        quizList.add(Quiz("12-12-2020", "Quiz 15"))
        quizList.add(Quiz("12-12-2020", "Quiz 16"))
        quizList.add(Quiz("12-12-2020", "Quiz 17"))
        quizList.add(Quiz("12-12-2020", "Quiz 18"))
    }

    private fun setUpViews() {
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        adapter = QuizAdapter(this, quizList )
        recylerViewQuiz.layoutManager = GridLayoutManager(this, 2)
        recylerViewQuiz.adapter = adapter
    }


}


