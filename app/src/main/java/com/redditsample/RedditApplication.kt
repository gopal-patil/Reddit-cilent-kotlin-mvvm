package com.redditsample

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.support.annotation.NonNull
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

class RedditApplication : Application() {

    init {
        INSTANCE = this
    }

    companion object {
        private var INSTANCE: RedditApplication? = null

        fun getApplication(): RedditApplication {
            return INSTANCE!!
        }
    }

    private lateinit var retrofit: Retrofit

    override fun onCreate() {
        super.onCreate()
        //setup cache
        var httpCacheDirectory = File(this.applicationContext.cacheDir, "responses")
        var cacheSize: Long = 10 * 1024 * 1024 // 10 MiB
        var cache = Cache(httpCacheDirectory, cacheSize)

        var okHttpClient = OkHttpClient()
                .newBuilder()
                .cache(cache)
                .build()

        retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://www.reddit.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    fun getRetrofit(): Retrofit {
        return retrofit
    }
}