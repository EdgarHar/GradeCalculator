package com.example.gradecalculator


const val ATTENDANCE_PERCENTAGE = 0.1
const val HOMEWORK_PERCENTAGE = 0.2
const val MIDTERM_ONE_PERCENTAGE = 0.1
const val MIDTERM_TWO_PERCENTAGE = 0.2
const val PRESENTATION_PERCENTAGE = 0.1
const val FINAL_PERCENTAGE = 0.3

class Calculator() {

    fun calculate(
        attendanceGrade: String,
        midtermOneGrade: String,
        midtermTwoGrade: String,
        presentationGrade: String,
        finalProjectGrade: String,
        homeworkGrades: List<String>
    ): Double {

        var homeworkGrade = homeworkGrades
            .map { it.toInt() }
            .average()
        return (ATTENDANCE_PERCENTAGE * attendanceGrade.toDouble()
                + HOMEWORK_PERCENTAGE * homeworkGrade
                + MIDTERM_ONE_PERCENTAGE * midtermOneGrade.toDouble()
                + MIDTERM_TWO_PERCENTAGE * midtermTwoGrade.toDouble()
                + PRESENTATION_PERCENTAGE * presentationGrade.toDouble()
                + FINAL_PERCENTAGE * finalProjectGrade.toDouble())
    }


}