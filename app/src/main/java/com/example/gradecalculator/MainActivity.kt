package com.example.gradecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradecalculator.ui.theme.GradeCalculatorTheme


val calculator = Calculator()

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
@Preview
fun MainScreen() {
    var midtermOneGrade by remember { mutableStateOf("100") }
    var midtermTwoGrade by remember { mutableStateOf("100") }
    var attendanceGrade by remember { mutableStateOf("100") }
    var presentationGrade by remember { mutableStateOf("100") }
    var finalProjectGrade by remember { mutableStateOf("100") }
    var homeworkGrades = remember {
        mutableStateListOf<String>()
            .also { list -> repeat(5) { list.add("100") } }
    }
    var totalGrade by remember { mutableStateOf("") }
    GradeCalculatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(40.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(17.dp)
        ) {

            Spacer(modifier = Modifier.offset(20.dp))
            GradeComposable(
                grade = attendanceGrade,
                onChange = { newGrade -> attendanceGrade = validateBound(newGrade) },
                "Attendance and Participation",
                modifier = Modifier.fillMaxWidth()
            )
            GradeComposable(
                grade = presentationGrade,
                onChange = { newGrade ->
                    presentationGrade = validateBound(newGrade)
                },
                "Group Presentation",
                modifier = Modifier.fillMaxWidth()
            )
            GradeComposable(
                grade = midtermOneGrade,
                onChange = { newGrade -> midtermOneGrade = validateBound(newGrade) },
                "Midterm 1",
                modifier = Modifier.fillMaxWidth()
            )
            GradeComposable(
                grade = midtermTwoGrade,
                onChange = { newGrade -> midtermTwoGrade = validateBound(newGrade) },
                "Midterm 2",
                modifier = Modifier.fillMaxWidth()
            )
            GradeComposable(
                grade = finalProjectGrade,
                onChange = { newGrade -> finalProjectGrade = validateBound(newGrade) },
                "Final Project",
                modifier = Modifier.fillMaxWidth()
            )

            Box {
                Text(text = "Homeworks")
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(0.dp, 20.dp)
                ) {
                    repeat(5) {
                        GradeComposable(
                            grade = homeworkGrades[it],
                            onChange = { newGrade ->
                                homeworkGrades[it] = validateBound(newGrade)
                            },
                            gradeType = "${it + 1}",
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            Button(onClick = {
                totalGrade = calculator.calculate(
                    attendanceGrade,
                    midtermOneGrade,
                    midtermTwoGrade,
                    presentationGrade,
                    finalProjectGrade,
                    homeworkGrades
                ).toString()
            }) {

                Text(text = "Calculate")
            }

            Text(text = totalGrade)


        }
    }

}

@Composable
fun GradeComposable(
    grade: String,
    onChange: (String) -> Unit,
    gradeType: String,
    modifier: Modifier = Modifier
) {

    TextField(
        value = grade,
        onValueChange = { onChange(it) },
        label = { Text(text = gradeType) },
        modifier = modifier,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

fun validateLength(text: String) = text.length <= 3

fun validateBound(text: String): String {
    try {
        if (text.toDouble() in 0.0..100.0) {
            return text
        } else if (text.toDouble() < 0) return ""
        else return "100"
    } catch (e: java.lang.NumberFormatException) {
        return "0"
    }
}

