package com.example.msanalytics.data.api.retrofit.backend

import com.example.msanalytics.data.api.retrofit.backend.models.BackendAccountModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAnswerModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendQuestionModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendTokenModel
import retrofit2.Response

interface BackendExternalDataSource {
    suspend fun createAccount(accountModel: BackendAccountModel): Response<String>
    suspend fun getToken(accountModel: BackendAccountModel): Response<BackendTokenModel>
    suspend fun getQuestions(token: String): Response<BackendQuestionModel>
    suspend fun sendAnswers(token: String, answerModel: BackendAnswerModel): Response<String>
}