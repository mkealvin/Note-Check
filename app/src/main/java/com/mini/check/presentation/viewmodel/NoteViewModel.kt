package com.mini.check.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mini.check.database.NoteRepository
import com.mini.check.map
import com.mini.check.model.Note

//menampilkan daftar data di aplikasi, dan penyimpanan daftar data ke ViewModel
class NoteViewModel(private val noteRepository: NoteRepository) : ViewModel() {

    private lateinit var notesResult: LiveData<List<Note>>

    init {
        subscribeNoteResult()
    }

    fun saveNote(content: String) {
        noteRepository.saveNote(content)
    }

    fun deleteNote(note: Note) {
        noteRepository.deleteNote(note)
    }

    fun listenNotesResult(): LiveData<List<Note>> {
        return notesResult
    }

    private fun subscribeNoteResult() {
        notesResult = noteRepository.loadNotesLiveData().map { data ->
            data.reversed().map { Note(it.id, it.content) }
        }
    }

}