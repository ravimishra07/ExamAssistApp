package com.examassistapp.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.examassistapp.adapters.NotesAdapter
import com.examassistapp.models.PaperResponse
import com.examassistapp.R
import com.examassistapp.models.Document
import com.examassistapp.viewmodels.MainViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class NotesFragment : Fragment() {

    var notesRecyclerView: RecyclerView? = null
    private var documentArray: MutableList<Document> = mutableListOf()
    private lateinit var mainViewModel: MainViewModel
    private val mAdapter by lazy { NotesAdapter() }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_notes, container, false)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        notesRecyclerView = view.findViewById(R.id.rb_paperRecyclerView)

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
       // readData()



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
    private fun readDatabase() {
        lifecycleScope.launch {
            mainViewModel.readDocument.observe(viewLifecycleOwner, { database ->
                if (database.isNotEmpty()) {
                    Log.d("RecipesFragment", "readDatabase called!")
                    mAdapter.setData(database.first().document)
                  //  hideShimmerEffect()
                } else {
                  //  requestApiData()
                }
            })
        }
    }
    fun setAdapter(doc:List<Document>){
        val adapter = activity?.let { NotesAdapter() }
        notesRecyclerView!!.setHasFixedSize(true)
        notesRecyclerView!!.layoutManager = LinearLayoutManager(activity)
        notesRecyclerView!!.adapter = adapter
    }


//    private fun showShimmerEffect() {
//        binding.shimmerFrameLayout.startShimmer()
//        binding.shimmerFrameLayout.visibility = View.VISIBLE
//        binding.recyclerview.visibility = View.GONE
//    }
//
//    private fun hideShimmerEffect() {
//        binding.shimmerFrameLayout.stopShimmer()
//        binding.shimmerFrameLayout.visibility = View.GONE
//        binding.recyclerview.visibility = View.VISIBLE
//    }
}