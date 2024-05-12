package com.example.msanalytics.ui.entry.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAnswerModel
import com.example.msanalytics.databinding.FragmentQuestionFeedBinding
import com.example.msanalytics.ui.entry.adapters.QuestionAdapter
import com.example.msanalytics.ui.entry.adapters.ItemTouchHelperCallback
import com.example.msanalytics.ui.entry.models.QuestionFeedModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionFeedFragment : Fragment() {
    private val viewModel: QuestionFeedViewModel by viewModels()
    private lateinit var questionFeedBinding: FragmentQuestionFeedBinding

    private val _answers: MutableLiveData<ArrayList<QuestionFeedModel>> = MutableLiveData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        questionFeedBinding = FragmentQuestionFeedBinding.inflate(layoutInflater)
        questionFeedBinding.fragmentQuestionFeedQuestionList.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        /*ожидаение данных с сервера*/
        viewModel.questionList.observe(viewLifecycleOwner){ it ->
            val questionAdapter: QuestionAdapter = QuestionAdapter(_answers, ArrayList(it))
            questionFeedBinding.fragmentQuestionFeedQuestionList.adapter = questionAdapter
            questionAdapter.updateAdapterData(it)
            ItemTouchHelper(ItemTouchHelperCallback(questionAdapter))
                .attachToRecyclerView(questionFeedBinding.fragmentQuestionFeedQuestionList)
        }

        /*ожидание конца тестирования*/
        _answers.observe(viewLifecycleOwner){ it ->
            val backendAnswerBooleanArray = ArrayList<Boolean>()
            for (latter in it) {
                backendAnswerBooleanArray.add(false)
            }
            for (latter in it) {
                backendAnswerBooleanArray[latter.index] = latter.answer
            }
            viewModel.sendAnswers(BackendAnswerModel(backendAnswerBooleanArray),
                questionFeedBinding.root
            )
        }
        return questionFeedBinding.root
    }
}