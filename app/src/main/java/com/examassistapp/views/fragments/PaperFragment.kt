package com.examassistapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.examassistapp.Adapters.PaperAdapter
import com.examassistapp.Models.PaperResponse
import com.examassistapp.R

class PaperFragment : Fragment() {

    var rb_paperRecyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_paper, container, false)

        rb_paperRecyclerView = view.findViewById(R.id.rb_paperRecyclerView)

        val myListData: Array<PaperResponse> = arrayOf<PaperResponse>(

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

        val adapter = activity?.let { PaperAdapter(it, myListData) }
        rb_paperRecyclerView!!.setHasFixedSize(true)
        rb_paperRecyclerView!!.setLayoutManager(LinearLayoutManager(activity))
        rb_paperRecyclerView!!.setAdapter(adapter)


        return view
    }
}