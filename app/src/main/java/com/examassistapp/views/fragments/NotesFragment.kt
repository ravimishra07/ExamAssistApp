package com.examassistapp.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.examassistapp.adapters.NotesAdapter
import com.examassistapp.models.PaperResponse
import com.examassistapp.R
import com.examassistapp.models.Document
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class NotesFragment : Fragment() {

    var rb_paperRecyclerView: RecyclerView? = null
    private var documentArray: MutableList<Document> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_notes, container, false)

        rb_paperRecyclerView = view.findViewById(R.id.rb_paperRecyclerView)

        val myListData: Array<PaperResponse> = arrayOf<PaperResponse>(
                PaperResponse("Lows and Thermodynamics"),
                PaperResponse("The Cornot Cycle"),
                PaperResponse("Lows and Thermodynamics"),
                PaperResponse("The Cornot Cycle"),
                PaperResponse("Lows and Thermodynamics"),
                PaperResponse("The Cornot Cycle"),
                PaperResponse("Lows and Thermodynamics"),
                PaperResponse("The Cornot Cycle"),
                PaperResponse("Lows and Thermodynamics"),
                PaperResponse("The Cornot Cycle"),
                PaperResponse("Lows and Thermodynamics"),
                PaperResponse("The Cornot Cycle"),
                PaperResponse("Lows and Thermodynamics"),
                PaperResponse("The Cornot Cycle")
        )
        readData()



        return  view
    }
    private fun readData(){
        val db = Firebase.firestore
        db.collection("doc")
            .get()
            .addOnSuccessListener { result ->

                if(!result.isEmpty){

                    for (document in result) {
                        Log.d("TestActivity", "${document.id} => ${document.data}")
                        val doc: Document = document.toObject(Document::class.java)
                        documentArray.add(doc)
                    }
                    setAdapter(documentArray)
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TestActivity", "Error getting documents.", exception)
            }
    }

    fun setAdapter(doc:List<Document>){
        val adapter = activity?.let { NotesAdapter(it, doc) }
        rb_paperRecyclerView!!.setHasFixedSize(true)
        rb_paperRecyclerView!!.layoutManager = LinearLayoutManager(activity)
        rb_paperRecyclerView!!.adapter = adapter
    }

}