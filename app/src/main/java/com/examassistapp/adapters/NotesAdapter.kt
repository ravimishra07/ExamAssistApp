package com.examassistapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.examassistapp.Models.PaperResponse
import com.examassistapp.R
import com.examassistapp.ViewUtils

class NotesAdapter(private val context: Context, private val data: Array<PaperResponse>) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodlist: PaperResponse = data[position]
        holder.txt_name.text = foodlist.name
        holder.ll_notes.background = ViewUtils.instance.drawCircle(
            ContextCompat.getColor(
                context,
                ViewUtils.instance.colorGenerator()
            )
        )
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txt_name = itemView.findViewById<TextView>(R.id.txt_name)
        val ll_notes = itemView.findViewById<LinearLayout>(R.id.ll_notes_icon)
    }
}