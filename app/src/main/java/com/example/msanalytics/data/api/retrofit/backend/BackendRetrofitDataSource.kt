package com.example.msanalytics.data.api.retrofit.backend

import com.example.msanalytics.data.api.retrofit.backend.models.BackendAccountModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAnswerModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendQuestionModel
import retrofit2.Response

class BackendRetrofitDataSource(
    private val apiService: BackendApiService,
): BackendExternalDataSource {
    override suspend fun createAccount(accountModel: BackendAccountModel): Response<String> {
        return apiService.createAccount(accountModel)
    }

    override suspend fun getToken(accountModel: BackendAccountModel): Response<String> {
        return apiService.getToken(accountModel)
    }

    override suspend fun getQuestions(): Response<BackendQuestionModel> {
        return apiService.getQuestions()
    }

    override suspend fun sendAnswers(answerModel: BackendAnswerModel): Response<String> {
        return apiService.sendAnswers(answerModel)
    }
}