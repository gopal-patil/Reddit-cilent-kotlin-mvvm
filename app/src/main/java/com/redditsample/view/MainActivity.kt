package com.redditsample.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.redditsample.R
import com.redditsample.RedditApplication

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RedditApplication.newComponent.inject(this)
    }
}
