package com.example.msanalytics.data.api.retrofit.backend

import com.example.msanalytics.data.api.retrofit.backend.models.BackendAccountModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAnswerModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendEventModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendEventsModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendQuestionModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendTokenModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface BackendApiService {
    @POST("/api/v1/account")
    suspend fun createAccount(@Body backendAccountModel: BackendAccountModel): Response<String>

    @POST("/api/v1/account/token")
    suspend fun getToken(@Body backendAccountModel: BackendAccountModel): Response<BackendTokenModel>

    @GET("/api/v1/testing/questions/accentuation")
    suspend fun getQuestions(@Header("Authorization") token: String): Response<BackendQuestionModel>

    @POST("/api/v1/testing/answers")
    suspend fun sendAnswers(
        @Header("Authorization") token: String,
        @Body backendAnswerModel: BackendAnswerModel
    ): Response<String>

    @GET("/api/v1/core/events")
    suspend fun getEvents(@Header("Authorization") token: String): Response<List<BackendEventsModel>>

    @POST("/api/v1/core/events")
    suspend fun createEvent(
        @Header("Authorization") token: String,
        @Body backendEventModel: BackendEventModel
    ): Response<String>

    @GET("/api/v1/core/events/{id}")
    suspend fun getEvent(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Response<BackendEventsModel>
}