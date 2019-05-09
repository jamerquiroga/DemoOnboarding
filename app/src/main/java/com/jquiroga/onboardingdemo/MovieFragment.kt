package com.jquiroga.onboardingdemo


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    var gsTitle: String? = null
    var gsRating: String? = null
    var gsOverview: String? = null
    var gsPosterUri: String? = null
    var goActivity: MainActivity? = null

    companion object {

        // Method for creating new instances of the fragment
        fun newInstance(poMovie: Movie): MovieFragment {

            // Store the movie data in a Bundle object
            val args = Bundle()
            args.putString(MovieHelper.KEY_TITLE, poMovie.title)
            args.putInt(MovieHelper.KEY_RATING, poMovie.rating)
            args.putString(MovieHelper.KEY_POSTER_URI, poMovie.posterUri)
            args.putString(MovieHelper.KEY_OVERVIEW, poMovie.overview)

            // Create a new MovieFragment and set the Bundle as the arguments
            // to be retrieved and displayed when the view is created
            val fragment = MovieFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        val args = arguments

        args?.let {
            gsTitle = args.getString(MovieHelper.KEY_TITLE)
            gsRating = String.format("%d/10", args.getInt(MovieHelper.KEY_RATING))
            gsOverview = args.getString(MovieHelper.KEY_OVERVIEW)
            gsPosterUri = args.getString(MovieHelper.KEY_POSTER_URI)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()

    }

    fun initUI() {

        if (gsTitle != null && gsRating != null && gsOverview != null && gsPosterUri != null) {
            titleTextView.text = gsTitle
            ratingTextView.text = gsRating
            overviewTextView.text = gsOverview
        }

        gsPosterUri.let {

            // Download the image and display it using Picasso
            Picasso.with(activity)
                .load(resources.getIdentifier(gsPosterUri, "drawable", activity!!.packageName))
                .into(posterImageView)
        }

    }

}
