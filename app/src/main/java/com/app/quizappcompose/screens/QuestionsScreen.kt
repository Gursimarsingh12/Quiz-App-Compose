package com.app.quizappcompose.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.quizappcompose.components.OptionsItem
import com.app.quizappcompose.utils.Constants

@Composable
fun QuestionsScreen(moveToGetStartedScreen: () -> Unit, name: String){
    val questionsList = Constants.getQuestions()
    var currentQuestionIndex by remember {
        mutableIntStateOf(0)
    }
    val question = questionsList[currentQuestionIndex]
    var selectedOptionIndex by remember {
        mutableIntStateOf(-1)
    }
    var isSubmitted by remember {
        mutableStateOf(false)
    }
    val isAnswerSelected = selectedOptionIndex != -1
    val context = LocalContext.current

    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xffA42FC1),
                            Color(0xFF6610F1),
                        )
                    ),
                    shape = RoundedCornerShape(
                        bottomStart = 50.dp,
                        bottomEnd = 50.dp
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hey $name",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.padding(10.dp))
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 10.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LinearProgressIndicator(
                        progress = { (currentQuestionIndex + 1) / questionsList.size.toFloat() },
                        trackColor = Color.Gray,
                        strokeCap = StrokeCap.Round,
                    )
                    Text(
                        text = "${currentQuestionIndex + 1} / ${questionsList.size}",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Text(
                    text = question.question,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                )
                Image(
                    painter = painterResource(id = question.imageResId),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(start = 30.dp, end = 30.dp, bottom = 20.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillBounds,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            question.options.forEachIndexed { index, option ->
                OptionsItem(
                    optionText = option,
                    isSelected = selectedOptionIndex == index,
                    isCorrect = isSubmitted && index == question.correctOption,
                    isIncorrect = isSubmitted && index == selectedOptionIndex && index != question.correctOption,
                    onClick = {
                        selectedOptionIndex = index
                        isSubmitted = false
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
            Spacer(modifier = Modifier.padding(15.dp))
            OutlinedButton(
                onClick = {
                    if(!isAnswerSelected){
                        Toast.makeText(context, "Please select any option", Toast.LENGTH_SHORT)
                            .show()
                    }else if (!isSubmitted) {
                        isSubmitted = true
                    } else {
                        selectedOptionIndex = -1
                        isSubmitted = false
                        if (currentQuestionIndex < questionsList.size - 1) {
                            currentQuestionIndex++
                        } else {
                            moveToGetStartedScreen()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF6610F1),
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color(0xFF6610F1)
                )
            ) {
                Text(text = if (isSubmitted) "Next" else "Submit")
            }
        }
    }
}

