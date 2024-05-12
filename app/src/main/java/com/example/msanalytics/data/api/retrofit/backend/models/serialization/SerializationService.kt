package com.example.msanalytics.data.api.retrofit.backend.models.serialization

import com.example.msanalytics.data.api.retrofit.backend.models.BackendEventModel
import com.example.msanalytics.data.api.retrofit.backend.models.BackendQuestionModel
import com.example.msanalytics.ui.entry.models.QuestionFeedModel
import com.example.msanalytics.ui.main.models.SwipeableFeedModel

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

    fun backendEventModelToSwipeableFeedModelList(
        backendEventModel: BackendEventModel?
    ): ArrayList<SwipeableFeedModel> {
        val swipeableFeedModelList = ArrayList<SwipeableFeedModel>()

        return swipeableFeedModelList
    }
}