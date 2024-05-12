package com.example.msanalytics.data.repository

import com.example.msanalytics.data.api.retrofit.backend.BackendExternalDataSource
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAnswerModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendQuestionModel
import retrofit2.Response

class QuestionRepository constructor(
    private val backendExternalDataSource: BackendExternalDataSource
) {
    suspend fun getQuestions(token: String): Response<BackendQuestionModel> {
        return backendExternalDataSource.getQuestions(token)
    }

    suspend fun sendAnswers(token: String, answerModel: BackendAnswerModel): Response<String> {
        return backendExternalDataSource.sendAnswers(token, answerModel)
    }
}