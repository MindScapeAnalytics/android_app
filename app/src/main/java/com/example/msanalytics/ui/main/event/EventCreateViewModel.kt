package com.example.msanalytics.ui.main.event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.msanalytics.data.api.retrofit.backend.models.BackendEventModel
import com.example.msanalytics.data.repository.AccountRepository
import com.example.msanalytics.data.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventCreateViewModel @Inject constructor(
    private val accountRepository: AccountRepository,
    private val eventRepository: EventRepository
) : ViewModel() {
    fun createEvent(
        name: String,
        description: String,
        image: String,
    ) {
        viewModelScope.launch {
            eventRepository.createEvent(
                "Bearer " + accountRepository.getTokenFromLocal()?.token,
                BackendEventModel(name, description, image)
            )
        }
    }
}