package com.jquiroga.onboardingdemo.pagerRecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper

import com.jquiroga.onboardingdemo.Movie
import com.jquiroga.onboardingdemo.MovieHelper
import com.jquiroga.onboardingdemo.R
import kotlinx.android.synthetic.main.activity_pager_recycler.*

class PagerRecyclerActivity : AppCompatActivity(), OnSnapPositionChangeListener {

    override fun onSnapPositionChange(poPosition: Int) {
        Log.d("9988", "position $poPosition")
    }

    private lateinit var gLinearLayoutManager: LinearLayoutManager
    private lateinit var gPagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager_recycler)

        val laoMovies: ArrayList<Movie> = MovieHelper.getMoviesFromJson("movies.json", this)

        gLinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        rcvPager.layoutManager = gLinearLayoutManager

        gPagerAdapter = PagerAdapter(laoMovies)

        rcvPager.adapter = gPagerAdapter

        val rcvSnapHelper = PagerSnapHelper()

        rcvSnapHelper.attachToRecyclerView(rcvPager)

        //val listener = SnapOnScrollListener(rcvSnapHelper, SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL_STATE_IDLE, this)

        //rcvPager.addOnScrollListener(listener)

        rcvPager.attachSnapHelperWithListener(rcvSnapHelper, SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL, this)

    }

}
