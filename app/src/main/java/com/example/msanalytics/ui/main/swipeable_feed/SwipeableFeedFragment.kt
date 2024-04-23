package com.example.msanalytics.ui.main.swipeable_feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.msanalytics.databinding.FragmentSwipeableFeedBinding
import com.example.msanalytics.ui.entry.start.StartViewModel
import com.example.msanalytics.ui.main.event.EventViewModel

class SwipeableFeedFragment : Fragment() {
    private lateinit var binding: FragmentSwipeableFeedBinding
    private val viewModel: SwipeableFeedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSwipeableFeedBinding.inflate(layoutInflater)
        return binding.root
    }
}