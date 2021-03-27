package com.mini.check

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.applicationContext 


class NoteApp : Application() {

    private val applicationModule = applicationContext {
        bean(Constant.Koin.CONTEXT_APP_DI) { this@NoteApp.applicationContext }
    }

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {// melakukan dependency injection agar tidak perlu mengubah module/component
        startKoin(
            this,
            listOf(
                applicationModule,
                    noteModule
            )
        )
    }
}