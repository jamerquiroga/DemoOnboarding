package com.jquiroga.onboardingdemo.pagerRecycler.steps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jquiroga.onboardingdemo.R
import com.jquiroga.onboardingdemo.pagerRecycler.data.Onboarding
import kotlinx.android.synthetic.main.item_step_row.view.*

class OnboardingAdapter(private val paoOnboarding: ArrayList<Onboarding>) :
    RecyclerView.Adapter<OnboardingAdapter.StepsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepsHolder {
        val loView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_step_row, parent, false)
        return StepsHolder(loView)
    }

    override fun getItemCount() = paoOnboarding.size

    override fun onBindViewHolder(holder: StepsHolder, position: Int) {

        val loOnboarding = paoOnboarding[position]

        holder.bindStep(loOnboarding)

    }

    fun updateFocus(piPosition: Int) {

        for (loOnboarding in paoOnboarding) {
            loOnboarding.isViewFocused = false
        }

        val loFocusView: Onboarding = paoOnboarding[piPosition]

        loFocusView.isViewFocused = true

        notifyDataSetChanged()

    }

    class StepsHolder(private val poView: View) : RecyclerView.ViewHolder(poView) {

        fun bindStep(poOnboarding: Onboarding) {

            if (poOnboarding.isViewFocused)
                this.poView.imgCircle.setBackgroundResource(R.drawable.circle_gray)
            else
                this.poView.imgCircle.setBackgroundResource(R.drawable.circle_white_border_gray)

        }

    }
}