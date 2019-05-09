package com.jquiroga.onboardingdemo.recycler

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jquiroga.onboardingdemo.Movie
import com.jquiroga.onboardingdemo.R
import kotlinx.android.synthetic.main.item_row.view.*

class MoviesAdapter(private val gaoMovies: ArrayList<Movie>): RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        val inflateView = parent.inflate(R.layout.item_row, false)
        return MoviesHolder(inflateView)
    }

    override fun getItemCount() = gaoMovies.size

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        val loItemMovie = gaoMovies[position]
        holder.bindMovie(loItemMovie)
    }

    class MoviesHolder(private val poView: View): RecyclerView.ViewHolder(poView), View.OnClickListener{

        private var loMovie: Movie? = null

        init {
            poView.setOnClickListener(this)
        }

        fun bindMovie(poMovie: Movie){
            this.loMovie = poMovie
            poView.txtTitle.text = poMovie.title
        }

        override fun onClick(view: View?) {
            Log.d("9988", "Click")
        }

        companion object {

            private val MOVIE_KEY = "MOVIE"
        }

    }
}