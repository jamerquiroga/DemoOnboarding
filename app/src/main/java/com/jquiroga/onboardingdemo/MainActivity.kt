package com.jquiroga.onboardingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: MoviesPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the list of movies from the JSON file
        val movies = MovieHelper.getMoviesFromJson("movies.json", this)

        viewPagerAdapter = MoviesPageAdapter(supportFragmentManager, movies)
        viewPager.adapter = viewPagerAdapter

    }

    /*
        replaceFragment(movies, moviesIndex)

        // Disable the Prev Button when showing the first movie
        prevButton.isEnabled = false

        prevButton.setOnClickListener {
            if (moviesIndex > 0) {
                moviesIndex--

                replaceFragment(movies, moviesIndex)

                if (moviesIndex == 0) {
                    prevButton.isEnabled = false
                }

                if (moviesIndex == movies.size - 2) {
                    nextButton.isEnabled = true
                }
            }
        }

        nextButton.setOnClickListener {
            if (moviesIndex < movies.size - 1) {
                moviesIndex++

                replaceFragment(movies, moviesIndex)

                if (moviesIndex == movies.size - 1) {
                    nextButton.isEnabled = false
                }
                if (moviesIndex == 1) {
                    prevButton.isEnabled = true
                }
            }
        }

        */

    /*
    private fun replaceFragment(movies: ArrayList<Movie>, moviesIndex: Int) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, MovieFragment.newInstance(movies[moviesIndex]))
            .commit()

    }

    */
}
