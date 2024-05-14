package com.example.msanalytics.data.api.retrofit.backend

import com.example.msanalytics.data.api.retrofit.backend.models.BackendAccountModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAnswerModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendEventModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendEventsModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendQuestionModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendTokenModel
import retrofit2.Response

class BackendRetrofitDataSource(
    private val apiService: BackendApiService,
): BackendExternalDataSource {
    override suspend fun createAccount(accountModel: BackendAccountModel): Response<String> {
        return apiService.createAccount(accountModel)
    }

    override suspend fun getToken(accountModel: BackendAccountModel): Response<BackendTokenModel> {
        return apiService.getToken(accountModel)
    }

    override suspend fun getQuestions(token: String): Response<BackendQuestionModel> {
        return apiService.getQuestions(token)
    }

    override suspend fun sendAnswers(token: String, answerModel: BackendAnswerModel): Response<String> {
        return apiService.sendAnswers(token, answerModel)
    }

    override suspend fun getEvents(token: String): Response<List<BackendEventsModel>> {
        return apiService.getEvents(token)
    }

    override suspend fun createEvent(
        token: String,
        backendEventModel: BackendEventModel
    ): Response<String> {
        return apiService.createEvent(token, backendEventModel)
    }

    override suspend fun getEvent(
        token: String,
        id: String
    ): Response<BackendEventModel> {
        return apiService.getEvent(token, id)
    }

}