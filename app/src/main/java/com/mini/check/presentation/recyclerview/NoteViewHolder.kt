package com.mini.check.presentation.recyclerview


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mini.check.model.Note
import kotlinx.android.synthetic.main.item_note.view.*


class NoteViewHolder(itemView: View?, itemLongClickListener: (Int) -> Unit) : RecyclerView.ViewHolder(itemView!!) {
    init {
        itemView?.setOnLongClickListener {
            itemLongClickListener(adapterPosition)
            return@setOnLongClickListener true
        }
    }

    fun bindData(note: Note) {
        itemView.item_note_content.text = note.content
    }
}// untuk mengikat komponen UI menggunakan format deklaratif