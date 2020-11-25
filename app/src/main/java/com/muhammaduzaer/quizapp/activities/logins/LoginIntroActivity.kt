package com.muhammaduzaer.quizapp.activities.logins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.muhammaduzaer.quizapp.activities.MainActivity
import com.muhammaduzaer.quizapp.R
import kotlinx.android.synthetic.main.activity_login_intro.*
import java.lang.Exception

class LoginIntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_intro)

        val auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            redirect("MAIN")
        }

        buttonGetStarted.setOnClickListener {
            redirect("LOGIN")
        }
    }

    private fun redirect(name: String) {
        val intent = when(name) {
            "LOGIN" -> Intent(this, LoginActivity::class.java)
            "MAIN" -> Intent(this, MainActivity::class.java)
            else -> throw Exception("no path exists")
        }
        startActivity(intent)
        finish()
    }
}