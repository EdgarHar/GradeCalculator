package com.example.gradecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gradecalculator.ui.theme.GradeCalculatorTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var midtermOneGrade by remember { mutableStateOf("100") }
            var midtermTwoGrade by remember { mutableStateOf("100") }
            var attendanceGrade by remember { mutableStateOf("100") }
            var presentationGrade by remember { mutableStateOf("100") }
            var finalProjectGrade by remember { mutableStateOf("100") }
            var homeworkGrades = remember { mutableStateOf(listOf<String>()) }
            GradeCalculatorTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                }
                Column (
                    verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(17.dp)) {
                    
                    Spacer(modifier = Modifier.offset(20.dp))
                    GradeComposable(grade = attendanceGrade, onChange = {newGrade -> attendanceGrade = newGrade},
                        "Attendance and Participation")
                    GradeComposable(grade = presentationGrade, onChange = {newGrade -> presentationGrade = newGrade},
                        "Group Presentation")
                    GradeComposable(grade = midtermOneGrade, onChange = {newGrade -> midtermOneGrade = newGrade},
                        "Midterm 1")
                    GradeComposable(grade = midtermTwoGrade, onChange = {newGrade -> midtermTwoGrade = newGrade},
                        "Midterm 2")
                    GradeComposable(grade = finalProjectGrade, onChange =  {newGrade -> finalProjectGrade = newGrade},
                        "Final Project")

                    Row(
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        GradeComposable(grade = homeworkGrades.value[1], onChange = {newGrade -> homeworkGrades} , gradeType = )
                    }
                }


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GradeCalculatorTheme {
    }
}

@Composable
fun GradeComposable(grade:String, onChange: (String) -> Unit, gradeType: String, modifier: Modifier = Modifier) {

    TextField(
        value = grade,
        onValueChange = {onChange(it)},
        label = { Text(text = gradeType) },
        modifier = modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}