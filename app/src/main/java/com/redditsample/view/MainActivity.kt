package com.redditsample.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.redditsample.R
import com.redditsample.viewmodel.RedditDataViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewModel = ViewModelProviders.of(this).get(RedditDataViewModel::class.java)

        viewModel.getNewsList("").observe(this,
                Observer { data ->
                    Log.e("MainActivity", "Data$data");
                })

       var map = HashMap<String,String>()
        map["str"] = "str"


    }
}
