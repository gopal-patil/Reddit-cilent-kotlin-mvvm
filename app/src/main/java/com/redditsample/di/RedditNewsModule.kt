package com.redditsample.di

import com.redditsample.service.repository.RedditWebApi
import com.redditsample.service.repository.RestAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RedditNewsModule {

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): RedditWebApi = retrofit.create(RedditWebApi::class.java)

}