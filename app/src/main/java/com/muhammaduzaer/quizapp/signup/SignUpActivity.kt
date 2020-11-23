package com.muhammaduzaer.quizapp.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.muhammaduzaer.quizapp.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        buttonRegister.setOnClickListener{
            signUpUser()
        }
    }

    private fun signUpUser() {

        val email: String = editTextNewEmail.text.toString()
        val password: String = editTextNewPassword.text.toString()
        val confirmPassword: String = editTextConfirmPassword.text.toString()


        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(this, "Registration Failed, Please try again later.", Toast.LENGTH_SHORT).show()
                }
            }

            .addOnFailureListener {
                Toast.makeText(this, it.localizedMessage,
                    Toast.LENGTH_SHORT).show()
            }
    }
}