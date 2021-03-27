package com.mini.check.database

import androidx.lifecycle.LiveData
import com.mini.check.model.Note
import java.util.*

class NoteRepository(private val noteDao: NoteDao) {

    fun saveNote(content: String) {
        val noteDb = NoteDb(id = generateUuid(), content = content)
        noteDao.insertNote(noteDb)
    }

    fun loadNotesLiveData(): LiveData<List<NoteDb>> {
        return noteDao.loadAllNotesLiveData()
    }

    private fun generateUuid(): String = UUID.randomUUID().toString()

    fun deleteNote(note: Note) {
        noteDao.deleteNote(note.id)
    }

}
// membuat fungsi untuk mengaktifkan tombol sebagaimana mestinya
// generateUuid = method yang di gunakan untuk mengenerate Id random