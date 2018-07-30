package com.redditsample.di

import com.redditsample.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkModule::class,
        RedditNewsModule::class))
interface NetworkComponent {
    fun inject(mainActivity: MainActivity)

}