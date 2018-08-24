package com.redditsample.service.repository

import com.redditsample.model.RedditNewsResponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditWebApi {

    @GET(".json")
    fun getAllNews(@Query("limit") limit: String,
                   @Query("after") after: String)
            : Call<RedditNewsResponse>


}