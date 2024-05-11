package com.example.msanalytics.ui.entry.models

data class QuestionFeedModel(
    val question: String = "",
    var answer: Boolean = false,
    var index: Int = 0,
    var passed: Boolean = false
) {
    private val ANSWER_YES: Boolean = true
    private val ANSWER_NO: Boolean = false
}
