package com.example.msanalytics.data.api.retrofit.backend

import com.example.msanalytics.data.api.retrofit.backend.models.BackendAccountModel
import retrofit2.Response

interface BackendExternalDataSource {
    suspend fun createAccount(): Response<String>
}