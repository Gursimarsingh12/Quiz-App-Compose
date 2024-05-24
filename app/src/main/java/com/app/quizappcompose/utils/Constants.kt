package com.app.quizappcompose.utils

import com.app.quizappcompose.R
import com.app.quizappcompose.model.QuestionModel

object Constants {
    fun getQuestions(): List<QuestionModel> {
        return listOf(
            QuestionModel(
                question = "What animal is shown in the image?",
                imageResId = R.drawable.lion,
                options = listOf("Dog", "Cat", "Lion", "Tiger"),
                correctOption = 2
            ),
            QuestionModel(
                question = "Identify the fruit in the image.",
                imageResId = R.drawable.banana,
                options = listOf("Apple", "Banana", "Orange", "Pear"),
                correctOption = 1
            ),
            QuestionModel(
                question = "What is the primary color of the object in the image?",
                imageResId = R.drawable.apple,
                options = listOf("Red", "Green", "Blue", "Yellow"),
                correctOption = 0
            ),
            QuestionModel(
                question = "Which mode of transportation is shown in the image?",
                imageResId = R.drawable.trains,
                options = listOf("Car", "Bike", "Train", "Airplane"),
                correctOption = 2
            ),
            QuestionModel(
                question = "Identify the profession represented in the image.",
                imageResId = R.drawable.pilot,
                options = listOf("Doctor", "Teacher", "Firefighter", "Pilot"),
                correctOption = 3
            ),
            QuestionModel(
                question = "What type of building is shown in the image?",
                imageResId = R.drawable.office,
                options = listOf("House", "Office", "School", "Hospital"),
                correctOption = 1
            ),
            QuestionModel(
                question = "Name the sport depicted in the image.",
                imageResId = R.drawable.tennis,
                options = listOf("Basketball", "Soccer", "Tennis", "Golf"),
                correctOption = 2
            ),
            QuestionModel(
                question = "Identify the type of landscape in the image.",
                imageResId = R.drawable.mountain,
                options = listOf("Mountain", "Beach", "Forest", "Desert"),
                correctOption = 0
            ),
            QuestionModel(
                question = "What is the primary object in the image?",
                imageResId = R.drawable.laptop,
                options = listOf("Book", "Pen", "Laptop", "Headphones"),
                correctOption = 2
            ),
            QuestionModel(
                question = "Which type of weather is shown in the image?",
                imageResId = R.drawable.rainy,
                options = listOf("Sunny", "Rainy", "Snowy", "Cloudy"),
                correctOption = 1
            )
        )
    }
}