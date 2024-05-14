package com.example.msanalytics.ui.main.event

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.msanalytics.R
import com.example.msanalytics.databinding.FragmentEventBinding
import com.example.msanalytics.databinding.FragmentSwipeableFeedBinding
import com.example.msanalytics.databinding.ItemSwipeableFeedBinding
import com.example.msanalytics.ui.main.adapters.EventAdapter
import com.example.msanalytics.ui.main.converters.Converter
import com.example.msanalytics.ui.main.models.EventParticipantsFeedModel
import com.example.msanalytics.ui.main.models.SwipeableFeedModel
import com.example.msanalytics.ui.main.swipeable_feed.SwipeableFeedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventFragment : Fragment() {
    private val viewModel: EventViewModel by viewModels()
    private lateinit var fragmentEventBinding: FragmentEventBinding
    private val eventParticipantsFeedItems = ArrayList<EventParticipantsFeedModel>()
    private lateinit var swipeableFeedModel: SwipeableFeedModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        eventParticipantsFeedItems.add(EventParticipantsFeedModel(emptyArray(), "", EventParticipantsFeedModel().FIRST_TYPE))
        /*eventParticipantsFeedItems.add(EventParticipantsFeedModel(emptyArray(), "Крицин Даниил", EventParticipantsFeedModel().SECOND_TYPE))
        eventParticipantsFeedItems.add(EventParticipantsFeedModel(emptyArray(), "Хазов Семён", EventParticipantsFeedModel().SECOND_TYPE))
        eventParticipantsFeedItems.add(EventParticipantsFeedModel(emptyArray(), "Казакова Полина", EventParticipantsFeedModel().SECOND_TYPE))*/
        fragmentEventBinding = FragmentEventBinding.inflate(layoutInflater)

        swipeableFeedModel = arguments?.getSerializable("data") as SwipeableFeedModel
        viewModel.getEventData(swipeableFeedModel.id.toString())
        viewModel.event.observe(viewLifecycleOwner) {
            fragmentEventBinding.fragmentEventEventName.text = it.name
            fragmentEventBinding.fragmentEventEventCategory.text = it.description
            fragmentEventBinding.fragmentEventHeaderImage.setImageBitmap(Converter().stringToBitMap(it.data))
        }

        fragmentEventBinding.fragmentEventPlacesRecycler.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        fragmentEventBinding.fragmentEventPlacesRecycler.adapter =
            EventAdapter(eventParticipantsFeedItems)
        return fragmentEventBinding.root
    }
}