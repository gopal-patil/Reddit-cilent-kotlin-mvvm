package com.redditsample.service.repository

import android.arch.lifecycle.LiveData
import com.redditsample.model.RedditNewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

class RedditWebService {

    val HOST_URL:String = "https://www.reddit.com/"

    @GET(".json")
    fun getAllNews(@Query("limit") limit: String,
                   @Query("after") after: String):LiveData<List<RedditNewsResponse>>


}