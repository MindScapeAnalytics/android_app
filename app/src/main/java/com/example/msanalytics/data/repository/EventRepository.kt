package com.example.msanalytics.data.repository

import com.example.msanalytics.data.api.retrofit.backend.BackendExternalDataSource
import com.example.msanalytics.data.api.retrofit.backend.models.BackendEventModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendEventsModel
import retrofit2.Response

class EventRepository(
    private val backendExternalDataSource: BackendExternalDataSource,
) {
    suspend fun getEvents(token: String): Response<List<BackendEventsModel>> {
        return backendExternalDataSource.getEvents(token)
    }

    suspend fun createEvent(token: String, backendEventModel: BackendEventModel): Response<String> {
        return backendExternalDataSource.createEvent(token, backendEventModel)
    }

    suspend fun getEvent(token: String, id: String): Response<BackendEventsModel> {
        return backendExternalDataSource.getEvent(token, id)
    }
}