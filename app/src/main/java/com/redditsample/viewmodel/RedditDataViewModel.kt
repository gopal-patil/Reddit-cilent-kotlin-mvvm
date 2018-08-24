package com.redditsample.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.redditsample.RedditApplication
import com.redditsample.model.RedditNews
import com.redditsample.service.repository.RedditWebApi
import com.redditsample.service.repository.RedditWebDataRepo
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class RedditDataViewModel : ViewModel() {

    private var newsList = MutableLiveData<RedditNews>();
    lateinit var dataRepo: RedditWebDataRepo

    init {
        dataRepo = RedditWebDataRepo()
    }

    fun getNewsList(after:String):LiveData<RedditNews>{
       return  dataRepo.getAllNews(after)
    }



}