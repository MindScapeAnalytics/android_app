package com.example.msanalytics.ui.entry.adapters

interface QuestionTouchHelperAdapter {
    fun onItemMove(fromPosition: Int, toPosition: Int)
    fun onItemDismiss(position: Int)
    fun onItemSwipeLeft(position: Int)
    fun onItemSwipeRight(position: Int)
}