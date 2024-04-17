package com.example.msanalytics.data.api.retrofit.backend

import com.example.msanalytics.data.api.retrofit.backend.models.BackendAccountModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BackendApiService {
    @POST("/api/v1/account")
    suspend fun createAccount(@Body backendAccountModel: BackendAccountModel): Response<String>
    
}