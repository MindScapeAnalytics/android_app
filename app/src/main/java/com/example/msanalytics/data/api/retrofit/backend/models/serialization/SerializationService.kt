package com.example.msanalytics.data.api.retrofit.backend.models.serialization

import com.example.msanalytics.data.api.retrofit.backend.models.BackendQuestionModel
import com.example.msanalytics.ui.entry.models.QuestionFeedModel

class SerializationService {
    fun backendQuestionModelToQuestionFeedModelList(
        backendQuestionModel: BackendQuestionModel?
    ): ArrayList<QuestionFeedModel> {
        val questionFeedModelList = ArrayList<QuestionFeedModel>()
        backendQuestionModel?.questions?.forEach { it ->
            questionFeedModelList.add(QuestionFeedModel(it))
        }
        return questionFeedModelList
    }
}