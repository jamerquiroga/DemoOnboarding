package com.jquiroga.onboardingdemo.pagerRecycler

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

class SnapOnScrollListener(
    private var poSnapHelper: SnapHelper,
    var poBehavior: Behavior = Behavior.NOTIFY_ON_SCROLL,
    var poOnSnapPositionChangeListener: OnSnapPositionChangeListener? = null
) : RecyclerView.OnScrollListener() {

    enum class Behavior {
        NOTIFY_ON_SCROLL,
        NOTIFY_ON_SCROLL_STATE_IDLE
    }

    private var goSnapPosition = RecyclerView.NO_POSITION

    override fun onScrolled(poRecyclerView: RecyclerView, dx: Int, dy: Int) {
        if (poBehavior == Behavior.NOTIFY_ON_SCROLL){
            maybeNotifySnapPositionChange(poRecyclerView)
        }
    }

    override fun onScrollStateChanged(poRecyclerView: RecyclerView, newState: Int) {
        if(poBehavior == Behavior.NOTIFY_ON_SCROLL_STATE_IDLE
            && newState == RecyclerView.SCROLL_STATE_IDLE){
            maybeNotifySnapPositionChange(poRecyclerView)
        }
    }

    private fun maybeNotifySnapPositionChange(poRecyclerView: RecyclerView){

        val loSnapPosition = poSnapHelper.getSnapPosition(poRecyclerView)
        val loSnapPositionChanged = this.goSnapPosition != loSnapPosition

        if(loSnapPositionChanged){
            poOnSnapPositionChangeListener?.onSnapPositionChange(loSnapPosition)
            this.goSnapPosition = loSnapPosition
        }
    }

}