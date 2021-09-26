package com.examassistapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.examassistapp.FirebaseUtil
import com.examassistapp.R
import com.examassistapp.models.Document
import com.examassistapp.models.DocumentData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.DocumentSnapshot




class TestActivity : AppCompatActivity() {
  lateinit var textView: TextView
    lateinit var  mFirestore: FirebaseFirestore
    private var documentArray: MutableList<Document> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        textView = findViewById(R.id.textView)

        // Initialize Firestore and the main RecyclerView
        mFirestore = FirebaseUtil.getFirestore()


        readData();
    }

    private fun readData(){
        val db = Firebase.firestore
        db.collection("doc")
            .get()
            .addOnSuccessListener { result ->

                if(!result.isEmpty){
//                    documentArray = result.toObjects(Document::class.java)
//                    textView.text = documentArray.first().documentTitle
                    for (document in result) {
                        Log.d("TestActivity", "${document.id} => ${document.data}")
                        val doc: Document = document.toObject(Document::class.java)
                        documentArray.add(doc)
                        textView.text = documentArray.first().documentTitle //?: "hooo"
                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TestActivity", "Error getting documents.", exception)
            }
    }
}