package com.example.test.presentation.application

import android.app.Application
import com.example.test.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@MainApplication)
            modules(appModules)
        }
    }
}