package com.mini.check


import androidx.room.Room
import com.mini.check.database.Database
import com.mini.check.database.NoteRepository
import com.mini.check.presentation.viewmodel.NoteViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext


val noteModule = applicationContext {

    // Create Database
    bean(name = Constant.Koin.DATABASE_DI) {
        Room
            .databaseBuilder(
                get(Constant.Koin.CONTEXT_APP_DI),
                Database::class.java,
                    Constant.Table.DB_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    // Create NoteRepository
    bean { get<Database>(Constant.Koin.DATABASE_DI).noteDao() }
    bean { NoteRepository(get()) }

    // Create NoteViewModel
    viewModel { NoteViewModel(get()) }

}