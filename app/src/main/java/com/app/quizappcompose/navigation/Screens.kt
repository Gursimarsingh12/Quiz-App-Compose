package com.app.quizappcompose.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {
    @Serializable
    data object GetStartedScreen : Screens()
    @Serializable
    data class QuestionsScreen(val name: String) : Screens()
}