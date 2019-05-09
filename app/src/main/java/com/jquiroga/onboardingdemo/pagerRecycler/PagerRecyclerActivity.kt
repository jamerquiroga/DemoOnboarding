package com.jquiroga.onboardingdemo.pagerRecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper

import com.jquiroga.onboardingdemo.Movie
import com.jquiroga.onboardingdemo.MovieHelper
import com.jquiroga.onboardingdemo.R
import com.jquiroga.onboardingdemo.pagerRecycler.data.Onboarding
import com.jquiroga.onboardingdemo.pagerRecycler.data.OnboardingData
import com.jquiroga.onboardingdemo.pagerRecycler.steps.OnboardingAdapter
import kotlinx.android.synthetic.main.activity_pager_recycler.*

class PagerRecyclerActivity : AppCompatActivity(), OnSnapPositionChangeListener {

    override fun onSnapPositionChange(poPosition: Int) {
        Log.d("9988", "position $poPosition")
        gOnboardingAdapter.updateFocus(poPosition)

    }

    private lateinit var gLinearLayoutManager: LinearLayoutManager
    private lateinit var gLinearLayoutManager2: LinearLayoutManager
    private lateinit var gPagerAdapter: PagerAdapter
    private lateinit var gOnboardingAdapter: OnboardingAdapter

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

        //Custom pager focus

        val laoOnboarding: ArrayList<Onboarding>? = OnboardingData().getDataForOnboarding()

        laoOnboarding?.let {

            val loOnboarding: Onboarding = laoOnboarding[0]

            loOnboarding.isViewFocused = true

            gLinearLayoutManager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

            rcvFocusPager.layoutManager = gLinearLayoutManager2

            gOnboardingAdapter = OnboardingAdapter(laoOnboarding)

            rcvFocusPager.adapter = gOnboardingAdapter

        }
    }

}
