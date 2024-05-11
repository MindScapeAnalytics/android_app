package com.example.msanalytics.ui.entry.adapters

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class QuestionItemTouchHelperCallback constructor(
    private val adapter: QuestionItemTouchHelperAdapter
): ItemTouchHelper.Callback() {
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        adapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        when (direction) {
            ItemTouchHelper.START -> {
                adapter.onItemSwipeLeft(viewHolder.adapterPosition)
            }
            ItemTouchHelper.END -> {
                adapter.onItemSwipeRight(viewHolder.adapterPosition)
            }
        }
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }
}