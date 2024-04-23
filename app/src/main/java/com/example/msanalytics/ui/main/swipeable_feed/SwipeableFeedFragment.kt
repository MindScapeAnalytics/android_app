package com.example.msanalytics.ui.main.swipeable_feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.msanalytics.databinding.FragmentSwipeableFeedBinding
import com.example.msanalytics.databinding.ItemSwipeableFeedBinding
import com.example.msanalytics.ui.entry.start.StartViewModel
import com.example.msanalytics.ui.main.adapters.SwipeableAdapter
import com.example.msanalytics.ui.main.event.EventViewModel
import com.example.msanalytics.ui.main.models.SwipeableFeedModel

class SwipeableFeedFragment : Fragment() {
    private lateinit var fragmentSwipeableFeedBinding: FragmentSwipeableFeedBinding
    private lateinit var itemSwipeableFeedBinding: ItemSwipeableFeedBinding
    private val swipeableFeedItems = ArrayList<SwipeableFeedModel>()
    private val viewModel: SwipeableFeedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val item1 = SwipeableFeedModel("hello","itismy", emptyArray())
        swipeableFeedItems.add(item1)
        val item2 = SwipeableFeedModel("hello1","itismy1", emptyArray())
        swipeableFeedItems.add(item2)
        val item3 = SwipeableFeedModel("hello2","itismy2", emptyArray())
        swipeableFeedItems.add(item3)
        itemSwipeableFeedBinding = ItemSwipeableFeedBinding.inflate(layoutInflater)
        fragmentSwipeableFeedBinding = FragmentSwipeableFeedBinding.inflate(layoutInflater)
        fragmentSwipeableFeedBinding.fragmentSwipeableFeedViewpage.adapter =
            SwipeableAdapter(swipeableFeedItems)
        return fragmentSwipeableFeedBinding.root
    }
}