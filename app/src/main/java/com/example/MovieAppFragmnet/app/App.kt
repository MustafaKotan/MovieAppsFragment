package com.example.MovieAppFragmnet.app

import android.app.Application
import com.example.MovieAppFragmnet.di.appModule
import com.example.MovieAppFragmnet.di.dataModule
import com.example.MovieAppFragmnet.di.domainModule
import com.example.MovieAppFragmnet.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(networkModule, domainModule, dataModule, appModule))
        }
    }
}
