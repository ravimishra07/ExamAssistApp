package com.examassistapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.examassistapp.adapters.NotesAdapter
import com.examassistapp.models.PaperResponse
import com.examassistapp.R

class NotesFragment : Fragment() {

    var rb_paperRecyclerView: RecyclerView? = null

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


        val adapter = activity?.let { NotesAdapter(it, myListData) }
        rb_paperRecyclerView!!.setHasFixedSize(true)
        rb_paperRecyclerView!!.layoutManager = LinearLayoutManager(activity)
        rb_paperRecyclerView!!.adapter = adapter



        return  view
    }

}