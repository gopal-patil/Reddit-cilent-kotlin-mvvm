package com.redditsample.service.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.redditsample.model.RedditNewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RedditWebDataRepo @Inject constructor(private val redditWebApi: RedditWebApi) {


    fun getAllNews( after: String, limit: String="10") : LiveData<RedditNewsResponse>{

        val data :MutableLiveData<RedditNewsResponse> = MutableLiveData()
        redditWebApi.getAllNews(limit,after).enqueue(object : Callback<RedditNewsResponse>{
            override fun onFailure(call: Call<RedditNewsResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<RedditNewsResponse>?, response: Response<RedditNewsResponse>?) {
                data.value = response?.body()
            }
        })
        return data
    }



}