package com.redditsample.service.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.redditsample.RedditApplication
import com.redditsample.model.RedditNews
import com.redditsample.model.RedditNewsItem
import com.redditsample.model.RedditNewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RedditWebDataRepo {
    private var redditWebApi: RedditWebApi = RedditApplication.getApplication().getRetrofit().create(RedditWebApi::class.java)

    fun getAllNews(after: String, limit: String = "10"): LiveData<RedditNews> {
        val data = MutableLiveData<RedditNews>()

        var response = redditWebApi.getAllNews(limit, after).enqueue(object : Callback<RedditNewsResponse> {
            override fun onFailure(call: Call<RedditNewsResponse>?, t: Throwable?) {
                Log.e("RedditWebDataRepo", "onFailure")
            }

            override fun onResponse(call: Call<RedditNewsResponse>?, response: Response<RedditNewsResponse>) {
                Log.e("RedditWebDataRepo", "onResponse")
                val dataResponse = response.body()?.data

                val news = dataResponse?.children?.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                data.value = RedditNews(
                        dataResponse?.after.orEmpty(),
                        dataResponse?.before.orEmpty(),
                        news!!)
            }

        })
        return data
    }


}