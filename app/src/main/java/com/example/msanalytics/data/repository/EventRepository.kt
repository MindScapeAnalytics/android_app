package com.example.msanalytics.data.repository

import com.example.msanalytics.data.api.retrofit.backend.BackendExternalDataSource
import com.example.msanalytics.data.api.retrofit.backend.models.BackendEventModel
import retrofit2.Response

class EventRepository(
    private val backendExternalDataSource: BackendExternalDataSource,
) {
    suspend fun getEvents(): Response<BackendEventModel> {
        TODO("add api method")
    }
}