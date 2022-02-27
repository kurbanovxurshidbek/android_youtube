package com.example.android_youtube.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_youtube.R
import com.example.android_youtube.adapter.FeedAdapter
import com.example.android_youtube.adapter.FilterAdapter
import com.example.android_youtube.model.Feed
import com.example.android_youtube.model.Filter

class MainActivity : AppCompatActivity() {
    lateinit var recyclerFilter: RecyclerView
    lateinit var recyclerFeed: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerFilter = findViewById<RecyclerView>(R.id.recyclerFilter)
        recyclerFilter.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        recyclerFeed = findViewById<RecyclerView>(R.id.recyclerFeed)
        recyclerFeed.setLayoutManager(GridLayoutManager(this, 1))

        refreshFilterAdapter(getAllFilters())
        refreshFeedAdapter(getAllFeeds())
    }

    fun refreshFilterAdapter(filters: ArrayList<Filter>) {
        val adapter = FilterAdapter(this, filters)
        recyclerFilter.adapter = adapter
    }

    fun refreshFeedAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerFeed.adapter = adapter
    }

    fun getAllFilters(): ArrayList<Filter> {
        var filters: ArrayList<Filter> = ArrayList()
        filters.add(Filter("Computer Programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Development"))
        return filters
    }

    fun getAllFeeds(): ArrayList<Feed> {
        val feeds: ArrayList<Feed> = ArrayList<Feed>()
        feeds.add(Feed(R.drawable.im_user_1, R.drawable.im_video_1))
        feeds.add(Feed(R.drawable.im_user_2, R.drawable.im_video_2))
        feeds.add(Feed(R.drawable.im_user_3, R.drawable.im_video_3))
        feeds.add(Feed(R.drawable.im_user_1, R.drawable.im_video_1))
        feeds.add(Feed(R.drawable.im_user_2, R.drawable.im_video_2))
        feeds.add(Feed(R.drawable.im_user_3, R.drawable.im_video_3))
        return feeds
    }
}