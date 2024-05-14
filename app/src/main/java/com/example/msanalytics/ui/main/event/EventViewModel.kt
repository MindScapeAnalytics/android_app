package com.example.msanalytics.ui.main.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.msanalytics.data.api.retrofit.backend.models.BackendEventModel
import com.example.msanalytics.data.api.retrofit.backend.models.serialization.SerializationService
import com.example.msanalytics.data.repository.AccountRepository
import com.example.msanalytics.data.repository.EventRepository
import com.example.msanalytics.ui.main.models.SwipeableFeedModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val accountRepository: AccountRepository
) : ViewModel() {
    private val _event: MutableLiveData<BackendEventModel> = MutableLiveData()
    val event: LiveData<BackendEventModel> get() = _event

    fun getEventData(
        id: String
    ) {
        viewModelScope.launch {
            _event.postValue(
                eventRepository.getEvent(
                    "Bearer " + accountRepository.getTokenFromLocal()?.token,
                    id
                ).body()
            )
        }
    }
}