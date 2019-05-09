package com.jquiroga.onboardingdemo.pagerRecycler

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

fun RecyclerView.attachSnapHelperWithListener(
    poSnapHelper: SnapHelper,
    poBehavior: SnapOnScrollListener.Behavior = SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL,
    poOnSnapPositionChangeListener: OnSnapPositionChangeListener
) {

    poSnapHelper.attachToRecyclerView(this)

    val goSnapOnScrollChangeListener = SnapOnScrollListener(poSnapHelper, poBehavior, poOnSnapPositionChangeListener)

    addOnScrollListener(goSnapOnScrollChangeListener)

}