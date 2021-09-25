package com.examassistapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.examassistapp.models.PaperResponse
import com.examassistapp.R

class PaperAdapter(private val context: Context, private val data: Array<PaperResponse>) : RecyclerView.Adapter<PaperAdapter.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.paper_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodlist: PaperResponse = data[position]
        holder.txt_name.text = foodlist.name

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txt_name = itemView.findViewById<TextView>(R.id.txt_name)

    }
}