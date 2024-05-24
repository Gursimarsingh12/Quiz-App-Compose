package com.app.quizappcompose.model

data class QuestionModel(
    val question: String,
    val imageResId: Int,
    val options: List<String>,
    val correctOption: Int
)