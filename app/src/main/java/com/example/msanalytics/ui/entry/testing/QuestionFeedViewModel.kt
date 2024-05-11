package com.example.msanalytics.ui.entry.testing

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.msanalytics.R
import com.example.msanalytics.data.api.repository.QuestionRepository
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAnswerModel
import com.example.msanalytics.data.api.retrofit.backend.models.serialization.SerializationService
import com.example.msanalytics.ui.entry.models.QuestionFeedModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionFeedViewModel @Inject constructor(
    private val repository: QuestionRepository
) : ViewModel() {
    private val _questionList: MutableLiveData<ArrayList<QuestionFeedModel>> = MutableLiveData()
    val questionList: LiveData<ArrayList<QuestionFeedModel>> get() = _questionList

    init {
        viewModelScope.launch {
//            _testingList.postValue(SerializationService()
//                .backendTestingModelToTestingAdapterModelList(
//                    repository.getQuestions().body()))
            val questionFeedModelList = ArrayList<QuestionFeedModel>()
            questionFeedModelList.add(QuestionFeedModel("Как у тебя дела?"))
            questionFeedModelList.add(QuestionFeedModel("Что ты сегодня делал?"))
            questionFeedModelList.add(QuestionFeedModel("У тебя есть собака?"))
            questionFeedModelList.add(QuestionFeedModel("У тебя есть кошка?"))
            questionFeedModelList.add(QuestionFeedModel("У тебя упадническое настроение?"))
            questionFeedModelList.add(QuestionFeedModel("Вы ели сеголня?"))
            questionFeedModelList.add(QuestionFeedModel("Вы хотите выкинутся из окна?"))
            questionFeedModelList.add(QuestionFeedModel("Как у тебя дела?"))
            questionFeedModelList.add(QuestionFeedModel("Что ты сегодня делал?"))
            questionFeedModelList.add(QuestionFeedModel("У тебя есть собака?"))
            questionFeedModelList.add(QuestionFeedModel("У тебя есть кошка?"))
            questionFeedModelList.add(QuestionFeedModel("У тебя упадническое настроение?"))
            questionFeedModelList.add(QuestionFeedModel("Вы ели сеголня?"))
            questionFeedModelList.add(QuestionFeedModel("Вы хотите выкинутся из окна?"))
            _questionList.postValue(questionFeedModelList)
        }
    }

    fun navToMain(v: View) {
        v.findNavController().navigate(R.id.mainActivity)
    }

    fun sendAnswers(backendAnswerModel: BackendAnswerModel, v: View) {
        viewModelScope.launch {
            if (repository.sendAnswers(backendAnswerModel).code() == 200) {
                v.findNavController().navigate(R.id.mainActivity)
            }
        }
    }

    fun refreshQuestions() {
        viewModelScope.launch {
            _questionList.postValue(SerializationService()
                .backendQuestionModelToQuestionFeedModelList(
                    repository.getQuestions().body()))
        }
    }
}