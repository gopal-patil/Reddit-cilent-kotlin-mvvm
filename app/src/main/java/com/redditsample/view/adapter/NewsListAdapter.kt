package com.redditsample.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.redditsample.model.RedditNews

class NewsListAdapter(private var newsList: List<RedditNews>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var context: Context
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        context = p0.context;
        return NewsViewHolder(View(context))
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {

    }

    inner class NewsViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }
}