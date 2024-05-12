package com.example.msanalytics.ui.entry.question

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.msanalytics.R
import com.example.msanalytics.data.repository.QuestionRepository
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAnswerModel
import com.example.msanalytics.data.api.retrofit.backend.models.serialization.SerializationService
import com.example.msanalytics.data.repository.AccountRepository
import com.example.msanalytics.ui.entry.models.QuestionFeedModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionFeedViewModel @Inject constructor(
    private val questionRepository: QuestionRepository,
    private val accountRepository: AccountRepository
) : ViewModel() {
    private val _questionList: MutableLiveData<ArrayList<QuestionFeedModel>> = MutableLiveData()
    val questionList: LiveData<ArrayList<QuestionFeedModel>> get() = _questionList

    init {
        viewModelScope.launch {
            _questionList.postValue(SerializationService()
                .backendQuestionModelToQuestionFeedModelList(
                    questionRepository.getQuestions(
                        "Bearer " + accountRepository.getTokenFromLocal()?.token
                    ).body()))
        }
    }

    fun navToMain(v: View) {
        v.findNavController().navigate(R.id.mainActivity)
    }

    fun sendAnswers(backendAnswerModel: BackendAnswerModel, v: View) {
        viewModelScope.launch {
            if (questionRepository.sendAnswers(
                    "Bearer " + accountRepository.getTokenFromLocal()?.token,
                    backendAnswerModel
            ).code() == 202) {
                v.findNavController().navigate(R.id.mainActivity)
            }
        }
    }

    fun refreshQuestions() {
        viewModelScope.launch {
            _questionList.postValue(SerializationService()
                .backendQuestionModelToQuestionFeedModelList(
                    questionRepository.getQuestions(
                        "Bearer " + accountRepository.getTokenFromLocal()?.token
                    ).body()))
        }
    }
}