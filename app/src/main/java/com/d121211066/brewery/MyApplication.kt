package com.d121211066.brewery

import android.app.Application
import com.d121211066.brewery.data.AppContainer
import com.d121211066.brewery.data.DefaultAppContainer

class MyApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}