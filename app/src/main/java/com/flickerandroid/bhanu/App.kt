package com.flickerandroid.bhanu

import android.app.Application
import com.flickerandroid.bhanu.data.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by: Bhanu Prakash
 * Created on: 01,September,2019
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
    private fun initKoin(){
        startKoin {
            androidContext(this@App)
            modules(
                viewModelModule
            )
        }
    }
}