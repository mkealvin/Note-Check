package com.mini.check.database

import androidx.room.Database
import androidx.room.RoomDatabase
//berfungsi untuk mendeklarasikan dependensi untuk akses SQLite


@Database(
    version = 1,
    entities = [
        NoteDb::class
    ],
    exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
// Pada kode diatas membuat sebuah database dengan meng-extends RoomDatabase()
// dan mendeklarasikan Table NoteDb::class dengan annotation @Database .