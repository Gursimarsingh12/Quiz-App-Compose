package com.app.quizappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.app.quizappcompose.screens.GetStartedScreen
import com.app.quizappcompose.screens.QuestionsScreen

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.GetStartedScreen
    ) {
        composable<Screens.GetStartedScreen> {
            GetStartedScreen(
                moveToQuestionsScreen = {
                    name ->
                    navController.navigate(
                        Screens.QuestionsScreen(name = name)
                    ) {
                        popUpTo(Screens.GetStartedScreen) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Screens.QuestionsScreen> {
            val args = it.toRoute<Screens.QuestionsScreen>()
            QuestionsScreen(
                moveToGetStartedScreen = {
                    navController.navigate(Screens.GetStartedScreen){
                        popUpTo(Screens.GetStartedScreen){
                            inclusive = true
                        }
                    }
                },
                name = args.name
            )
        }
    }
}