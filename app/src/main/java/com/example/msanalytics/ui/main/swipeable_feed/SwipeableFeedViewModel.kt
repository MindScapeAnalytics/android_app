package com.example.msanalytics.ui.main.swipeable_feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.msanalytics.data.repository.QuestionRepository
import com.example.msanalytics.data.api.retrofit.backend.models.serialization.SerializationService
import com.example.msanalytics.data.repository.EventRepository
import com.example.msanalytics.ui.entry.models.QuestionFeedModel
import com.example.msanalytics.ui.main.models.SwipeableFeedModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SwipeableFeedViewModel @Inject constructor(
    private val eventRepository: EventRepository
): ViewModel(){
    private val _eventList: MutableLiveData<ArrayList<SwipeableFeedModel>> = MutableLiveData()
    val eventList: LiveData<ArrayList<SwipeableFeedModel>> get() = _eventList

    init {
        viewModelScope.launch {
            _eventList.postValue(
                TODO("add repository")
            )
        }
    }
}