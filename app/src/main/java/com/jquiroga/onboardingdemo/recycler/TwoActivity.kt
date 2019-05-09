package com.jquiroga.onboardingdemo.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jquiroga.onboardingdemo.Movie
import com.jquiroga.onboardingdemo.MovieHelper
import com.jquiroga.onboardingdemo.R
import kotlinx.android.synthetic.main.activity_two.*

class TwoActivity : AppCompatActivity() {

    private lateinit var gLinearLayoutManager: LinearLayoutManager
    private lateinit var gAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val laoMovies: ArrayList<Movie> = MovieHelper.getMoviesFromJson("movies.json", this)

        gLinearLayoutManager = LinearLayoutManager(this)

        rcvMainContainer.layoutManager = gLinearLayoutManager

        gAdapter = MoviesAdapter(laoMovies)

        rcvMainContainer.adapter = gAdapter

    }

}
