package com.aldoapp.noteapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aldoapp.noteapp.R
import com.aldoapp.noteapp.model.NoteModel
import kotlinx.android.synthetic.main.item_notes.view.*

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
//?=no null
    private var listData: MutableList<NoteModel> = ArrayList<NoteModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //To change body of created functions use File | Settings | File Templates.
        //mengatur item layout pada adapter
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        //To change body of created functions use File | Settings | File Templates.
        //mengatur jumlah file yang ada di adapter
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //To change body of created functions use File | Settings | File Templates.
        //menampilkan dan mengatur data

        val data = listData[position]

        if (data != null) {
            holder.title_tv.text = data.title
            holder.description_tv.text = data.description
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title_tv = itemView.title_tv
        val description_tv = itemView.description_tv
    }

    private fun add(data: NoteModel) {
        listData.add(data)
        notifyItemInserted(listData.size - 1)
    }

    fun addAll(posItem: List<NoteModel>) {
        for (response in posItem) {
            add(response)
        }
    }

}