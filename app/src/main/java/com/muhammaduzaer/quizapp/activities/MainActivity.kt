package com.muhammaduzaer.quizapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.muhammaduzaer.quizapp.R
import com.muhammaduzaer.quizapp.activities.logins.LoginActivity
import com.muhammaduzaer.quizapp.adapter.QuizAdapter
import com.muhammaduzaer.quizapp.models.Quiz
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.top_bar.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var adapter: QuizAdapter
    private var quizList = mutableListOf<Quiz>()
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()

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

    private fun setUpViews() {
        setUpFireStore()
        setUpRecyclerView()
        setUpDatePicker()
    }

    private fun setUpDatePicker(){
        floatingButtonCalender.setOnClickListener{
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.show(supportFragmentManager, "DatePicker")
            datePicker.addOnPositiveButtonClickListener {
                Log.d("DATEPICKER", datePicker.headerText)

                val dateFormatter = SimpleDateFormat( "dd-mm-yyyy")
                val date = dateFormatter.format(Date(it))
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra("DATE", date)
                startActivity(intent)
            }
            datePicker.addOnNegativeButtonClickListener{
                Log.d("DATEPICKER", datePicker.headerText)
            }
            datePicker.addOnCancelListener {
                Log.d("DATEPICKER", "Date Picker was Cancelled.")
            }
        }
    }

    private fun setUpFireStore() {
        firestore = FirebaseFirestore.getInstance()
        val collectionReference = firestore.collection("quizzes")
        collectionReference.addSnapshotListener { value, error ->
            if(value == null || error != null) {
                Toast.makeText(this, "Error Fetching Data", Toast.LENGTH_SHORT).show()
                return@addSnapshotListener
            }
            Log.d("DATA", value.toObjects(Quiz::class.java).toString())
            quizList.clear()
            quizList.addAll(value.toObjects(Quiz::class.java))
            adapter.notifyDataSetChanged()
        }
    }

    private fun setUpRecyclerView() {
        adapter = QuizAdapter(this, quizList )
        recylerViewQuiz.layoutManager = GridLayoutManager(this, 2)
        recylerViewQuiz.adapter = adapter
    }

}


