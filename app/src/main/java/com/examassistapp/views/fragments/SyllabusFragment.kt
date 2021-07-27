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


class SyllabusFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val  view =  inflater.inflate(R.layout.fragment_syllabus, container, false)

        return view
    }
}