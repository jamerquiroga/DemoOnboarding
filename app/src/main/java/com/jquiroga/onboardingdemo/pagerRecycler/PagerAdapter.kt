package com.jquiroga.onboardingdemo.pagerRecycler


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jquiroga.onboardingdemo.Movie
import com.jquiroga.onboardingdemo.R

class PagerAdapter(private val paoMovies: ArrayList<Movie>) : RecyclerView.Adapter<PagerAdapter.PagerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerHolder {
        val loView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent,false)
        return PagerHolder(loView)
    }

    override fun getItemCount() = paoMovies.size

    override fun onBindViewHolder(holder: PagerHolder, position: Int) {
        val loMovie: Movie = paoMovies[position]
        holder.bindMovie(loMovie)
    }



    class PagerHolder(private val poView: View) : RecyclerView.ViewHolder(poView){

        fun bindMovie(poMovie: Movie){

        }

    }

}