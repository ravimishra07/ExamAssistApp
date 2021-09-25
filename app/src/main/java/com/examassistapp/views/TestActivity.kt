package com.examassistapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.examassistapp.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val db = Firebase.firestore

    }
}