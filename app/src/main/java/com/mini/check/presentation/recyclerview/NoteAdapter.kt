package com.mini.check.presentation.recyclerview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mini.check.model.Note
import com.mini.check.R

//ViewGroup yang menampilkan item yang dimuat ke dalam adaptor.
class NoteAdapter(private val itemLongClickListener: (Int) -> Unit) : RecyclerView.Adapter<NoteViewHolder>() {

    private var data: MutableList<Note> = mutableListOf()

    fun getDataAtPosition(position: Int): Note = data[position]

    fun setData(data: MutableList<Note>) {
        val diffResult = DiffUtil.calculateDiff(//digunakan oleh DiffUtil saat menghitung perbedaan antara dua list.
                NoteDiffUtilCallback(this.data, data)
        )

        this.data = data
        diffResult.dispatchUpdatesTo(this)
    }

    fun updateData(data: MutableList<Note>) {
        val diffResult = DiffUtil.calculateDiff(
                NoteDiffUtilCallback(this.data, data)
        )

        this.data.clear()
        this.data.addAll(data)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_note, parent, false)

        return NoteViewHolder(itemView, itemLongClickListener)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            holder.bindData(data[position])
        }
    }
}