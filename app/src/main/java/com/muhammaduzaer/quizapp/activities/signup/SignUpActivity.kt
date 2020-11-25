package com.muhammaduzaer.quizapp.activities.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.muhammaduzaer.quizapp.activities.MainActivity
import com.muhammaduzaer.quizapp.R
import com.muhammaduzaer.quizapp.activities.logins.LoginActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        firebaseAuth = FirebaseAuth.getInstance()

        buttonRegister.setOnClickListener{
            signUpUser()
        }

        textViewSignIn.setOnClickListener{
            val signUpToSignIn = Intent(this, LoginActivity::class.java)
            startActivity(signUpToSignIn)
            finish()
        }
    }

    private fun signUpUser() {

        val email = editTextNewEmail.text.toString()
        val password = editTextNewPassword.text.toString()
        val confirmPassword = editTextConfirmPassword.text.toString()

        if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(this, "Email and Password Cannot be blank.", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Password doesn't match, please enter again.", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                    val signUpToMain = Intent(this, MainActivity::class.java)
                    startActivity(signUpToMain)
                    finish()
                }
                else {
                    Toast.makeText(this, "Registration Failed, Please try again later.", Toast.LENGTH_SHORT).show()
                }
            }

    }
}