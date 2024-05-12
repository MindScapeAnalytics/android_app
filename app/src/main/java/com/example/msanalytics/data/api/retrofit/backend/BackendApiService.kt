package com.example.msanalytics.data.api.retrofit.backend

import com.example.msanalytics.data.api.retrofit.backend.models.BackendAccountModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAnswerModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendQuestionModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendTokenModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

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
}