package com.example.msanalytics.ui.entry.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.msanalytics.R
import com.example.msanalytics.ui.entry.models.QuestionFeedModel

class QuestionAdapter(
    private var _questions: MutableLiveData<ArrayList<QuestionFeedModel>>,
    private var master: ArrayList<QuestionFeedModel>
): RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>(), QuestionItemTouchHelperAdapter  {
    private var questions: ArrayList<QuestionFeedModel> = ArrayList()
    private var answers: ArrayList<QuestionFeedModel> = ArrayList()
    class QuestionViewHolder constructor(
        v: View
    ): RecyclerView.ViewHolder(v) {
        private var textQuestion: TextView
        init {
            textQuestion = v.findViewById(R.id.item_testing__text_question)
        }
        fun setSwipeableFeedData(questionData: QuestionFeedModel) {
            textQuestion.text = questionData.question
        }
    }

    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        return QuestionViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_testing, parent, false
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapterData(newQuestionList: ArrayList<QuestionFeedModel>) {
        questions = newQuestionList; notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.setSwipeableFeedData(questions[position])
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        TODO("Not yet implemented")
    }

    override fun onItemDismiss(position: Int) {
        TODO("Not yet implemented")
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onItemSwipeLeft(position: Int) {
        var index: Int = 0
        for (latter in master) {
            if (latter.question == questions[position].question) {
                break
            }
            index++
        }
        answers.add(QuestionFeedModel(
            question = questions[position].question,
            answer = false,
            index = index
            ))
        questions.removeAt(position)
        notifyItemRemoved(position); notifyDataSetChanged()
        if (questions.size == 0) {
            _questions.postValue(answers)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onItemSwipeRight(position: Int) {
        var index: Int = 0
        for (latter in master) {
            if (latter.question == questions[position].question) {
                break
            }
            index++
        }
        answers.add(QuestionFeedModel(
            question = questions[position].question,
            answer = true,
            index = index
        ))
        questions.removeAt(position)
        notifyItemRemoved(position); notifyDataSetChanged()
        if (questions.size == 0) {
            _questions.postValue(answers)
        }
    }
}