package com.example.msanalytics.data.api.retrofit.backend

import com.example.msanalytics.data.api.retrofit.backend.models.BackendAccountModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAnswerModel
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
}