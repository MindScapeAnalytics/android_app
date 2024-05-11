package com.example.msanalytics.ui.entry.adapters

interface QuestionItemTouchHelperAdapter {
    fun onItemMove(fromPosition: Int, toPosition: Int)
    fun onItemDismiss(position: Int)
    fun onItemSwipeLeft(position: Int)
    fun onItemSwipeRight(position: Int)
}