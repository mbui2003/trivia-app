package com.bignerdranch.android.geoquiz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val IS_CHEATER_KEY = "IS_CHEATER_KEY"
const val NUM_CORRECT_ANSWERS_KEY = "NUM_CORRECT_ANSWERS_KEY"


class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val questionBank = listOf(
        Question(R.string.question_durant, true),
        Question(R.string.question_curry, false),
        Question(R.string.question_lebron, true),
        Question(R.string.question_kobe, false),
        Question(R.string.question_jordan, true),
        Question(R.string.question_rose, true)
    )

    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

    var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    var numCorrectAnswers: Int
        get() = savedStateHandle.get(NUM_CORRECT_ANSWERS_KEY) ?: 0
        set(value) = savedStateHandle.set(NUM_CORRECT_ANSWERS_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev() {
        currentIndex = if (currentIndex > 0) {
            currentIndex - 1
        } else {
            0
        }

    }
}