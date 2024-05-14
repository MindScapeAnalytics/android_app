package com.example.msanalytics.ui.main.swipeable_feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.msanalytics.databinding.FragmentSwipeableFeedBinding
import com.example.msanalytics.ui.main.adapters.SwipeableAdapter
import com.example.msanalytics.ui.main.models.SwipeableFeedModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SwipeableFeedFragment : Fragment() {
    private lateinit var fragmentSwipeableFeedBinding: FragmentSwipeableFeedBinding
    private val viewModel: SwipeableFeedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSwipeableFeedBinding = FragmentSwipeableFeedBinding.inflate(layoutInflater)
        val adapter = SwipeableAdapter(fragmentSwipeableFeedBinding.root)
        fragmentSwipeableFeedBinding.fragmentSwipeableFeedViewpage.adapter = adapter

        viewModel.eventList.observe(viewLifecycleOwner) {
            adapter.updateAdapterData(it)
        }
        return fragmentSwipeableFeedBinding.root
    }
}