package com.mini.check.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mini.check.Constant
// melakukan deklarasi dependensi sebagai respons terhadap perubahan
// status siklus proses aktivitas dan fragment.

@Dao
interface NoteDao {

    @Query("SELECT * FROM ${Constant.Table.NOTE}")
    fun loadAllNotesLiveData(): LiveData<List<NoteDb>>

    @Insert
    fun insertNote(note: NoteDb)

    @Query("DELETE FROM ${Constant.Table.NOTE} WHERE id=:noteId")
    fun deleteNote(noteId: String)

}
//Untuk mengakses database perlu membuat interface annotation @Dao ,
//  method diatas  harusnya diakses melalui background thread.
