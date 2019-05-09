package com.jquiroga.onboardingdemo.pagerRecycler

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

fun SnapHelper.getSnapPosition(poRecyclerView: RecyclerView): Int{

    val goLayoutManager = poRecyclerView.layoutManager ?: return RecyclerView.NO_POSITION
    val goSnapView = findSnapView(goLayoutManager) ?: return RecyclerView.NO_POSITION

    return goLayoutManager.getPosition(goSnapView)
}