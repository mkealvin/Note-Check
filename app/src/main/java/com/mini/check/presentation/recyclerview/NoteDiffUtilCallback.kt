package com.mini.check.presentation.recyclerview


import androidx.recyclerview.widget.DiffUtil
import com.mini.check.model.Note


class NoteDiffUtilCallback(private val oldData: MutableList<Note>,
                           private val newData: MutableList<Note>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int,
                                 newItemPosition: Int): Boolean {
        return oldData[oldItemPosition].id == newData[newItemPosition].id
    }

    override fun getOldListSize(): Int = oldData.size

    override fun getNewListSize(): Int = newData.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldData[oldItemPosition] == newData[newItemPosition]
    }
}
//kelas yang menghitung perbedaan antara dua daftar dan mengeluarkan daftar
// operasi pembaruan yang mengubah daftar pertama menjadi yang kedua.