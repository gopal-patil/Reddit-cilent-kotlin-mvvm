package com.redditsample.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.redditsample.service.repository.RedditWebDataRepo
import javax.inject.Inject

class RedditDataViewModel(application: Application):AndroidViewModel(application){

    lateinit var  dataObserver : LiveData<RedditDataViewModel>

    @Inject lateinit var dataRepo: RedditWebDataRepo

    init {
        dataRepo.getAllNews("")
    }


}