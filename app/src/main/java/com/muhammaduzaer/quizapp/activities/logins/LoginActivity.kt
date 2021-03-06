package com.muhammaduzaer.quizapp.activities.logins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.muhammaduzaer.quizapp.activities.MainActivity
import com.muhammaduzaer.quizapp.R
import com.muhammaduzaer.quizapp.activities.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()

        buttonSignIn.setOnClickListener {
            signInUser()
        }

        textViewSignUp.setOnClickListener{
            val loginToSignUp = Intent(this, SignUpActivity::class.java)
            startActivity(loginToSignUp)
            finish()
        }

    }

    private fun signInUser() {
        val email = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()

        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Please enter Email and Password to continue.", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Login Successful",
                        Toast.LENGTH_SHORT).show()

                    val loginToMain = Intent(this, MainActivity::class.java)
                    startActivity(loginToMain)
                    finish()
                }
                else {
                    Toast.makeText(this, "Login Failed, please make sure you entered correct Email and Password",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}