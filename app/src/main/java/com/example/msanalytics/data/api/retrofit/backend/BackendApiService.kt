package com.example.msanalytics.data.api.retrofit.backend

import com.example.msanalytics.data.api.retrofit.backend.models.BackendAccountModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAnswerModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendQuestionModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BackendApiService {
    @POST("/api/v1/account")
    suspend fun createAccount(@Body backendAccountModel: BackendAccountModel): Response<String>

    @POST("/api/v1/account/token")
    suspend fun getToken(@Body backendAccountModel: BackendAccountModel): Response<String>

    @GET("/api/v1/questions")
    suspend fun getQuestions(): Response<BackendQuestionModel>

    @POST("/api/v1/answers")
    suspend fun sendAnswers(@Body backendAnswerModel: BackendAnswerModel): Response<String>
}