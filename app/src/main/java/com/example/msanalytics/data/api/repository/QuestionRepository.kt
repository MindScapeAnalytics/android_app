package com.example.msanalytics.data.api.repository

import com.example.msanalytics.data.api.retrofit.backend.BackendExternalDataSource
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAnswerModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendQuestionModel
import retrofit2.Response

class QuestionRepository constructor(
    private val backendExternalDataSource: BackendExternalDataSource
) {
    suspend fun getQuestions(): Response<BackendQuestionModel> {
        return backendExternalDataSource.getQuestions()
    }

    suspend fun sendAnswers(answerModel: BackendAnswerModel): Response<String> {
        return backendExternalDataSource.sendAnswers(answerModel)
    }
}