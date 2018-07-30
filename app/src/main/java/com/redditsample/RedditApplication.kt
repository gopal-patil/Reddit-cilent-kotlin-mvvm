package com.redditsample

import android.app.Application
import com.redditsample.di.DaggerNetworkComponent
import com.redditsample.di.NetworkComponent

class RedditApplication : Application() {


    companion object {
        lateinit var newComponent: NetworkComponent
    }

    override fun onCreate() {
        super.onCreate()
        newComponent = DaggerNetworkComponent.builder().build()
    }
}