package com.mini.check.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mini.check.Constant


@Entity(
    tableName = Constant.Table.NOTE
)
class NoteDb(@PrimaryKey val id: String,
             val content: String)
//instasiasi database dengan nama tabel NOTE