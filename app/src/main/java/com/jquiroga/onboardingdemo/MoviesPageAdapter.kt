package com.jquiroga.onboardingdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MoviesPageAdapter(fragmentManager: FragmentManager, private val movies: ArrayList<Movie>) :
    FragmentStatePagerAdapter(fragmentManager){

    override fun getItem(position: Int): Fragment {
        return MovieFragment.newInstance(movies[position])
    }

    override fun getCount(): Int {
        return movies.size
    }

}

