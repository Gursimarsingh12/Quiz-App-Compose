package com.app.quizappcompose.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun OptionsItem(
    optionText: String,
    isSelected: Boolean,
    isCorrect: Boolean,
    isIncorrect: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = when {
        isCorrect -> Color.Green
        isIncorrect -> Color.Red
        isSelected -> Color(0xFF6610F1)
        else -> Color.White
    }
    val contentColor = if (isSelected || isCorrect || isIncorrect) Color.White else Color.Black
    ElevatedCard(
        onClick = {
            onClick()
        },
        shape = RoundedCornerShape(30.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .border(1.dp, Color.Black, RoundedCornerShape(30.dp)),
        colors = CardDefaults.cardColors(
            contentColor = contentColor,
            containerColor = backgroundColor,
            disabledContentColor = contentColor,
            disabledContainerColor = backgroundColor
        )
    ) {
        Text(
            text = optionText,
            style = TextStyle(
                color = contentColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 25.dp, top = 12.dp, end = 20.dp, bottom = 12.dp)
        )
    }
}

