package com.redditsample.service.repository

import com.redditsample.model.RedditNewsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

class RestAPI @Inject constructor(private val redditWebApi: RedditWebApi) {


    fun getAllNews(limit:String = "10", after: String){
//        return redditWebApi.getAllNews(limit,after)
    }




}