package com.example.gradecalculator

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
import org.junit.Assert.assertEquals

class CalculateTest {

    val calculator = Calculator()
    @Test
    fun testAllGradesZero() {
        val grade = calculator.calculate("0", "0", "0", "0", "0", listOf("0", "0", "0", "0", "0"))
        assertEquals(0.0, grade, 0.0)
    }

    @Test
    fun testAllGradesHundred() {
        val grade = calculator.calculate("100", "100", "100", "100", "100", listOf("100", "100", "100", "100", "100"))
        assertEquals(100.0, grade, 0.0)
    }

    @Test
    fun testHomeworkGradeWithDecimal() {
        val grade = calculator.calculate("80", "70", "75", "85", "90", listOf("90", "85.5", "80.5", "95.2", "92.7"))
        assertEquals(83.188, grade, 0.1)
    }

    @Test
    fun testGrades1() {
        val grade = calculator.calculate("100", "100", "100", "100", "100", listOf("90", "85", "80", "80", "70"))
        assertEquals(96.2, grade, 0.01)
    }

    @Test
    fun testGrades2() {
        val grade = calculator.calculate("100", "100", "100", "100", "100", listOf("0", "0", "0", "0", "0"))
        assertEquals(80.0, grade, 0.01)
    }

    @Test
    fun testGrades3() {
        val grade = calculator.calculate("80", "70", "75", "85", "90", listOf("100", "100", "100", "100", "100"))
        assertEquals(85.5, grade, 0.01)
    }

    @Test
    fun testGrades4() {
        val grade = calculator.calculate("95", "92", "96", "97", "98", listOf("91", "92", "94", "97", "96"))
        assertEquals(95.8, grade, 0.1)
    }

    @Test
    fun testGrades5() {
        val grade = calculator.calculate("50", "55", "45", "40", "30", listOf("59", "55", "50", "45", "40"))
        assertEquals(42.46, grade, 0.01)
    }

    @Test
    fun testGrades6() {
        val grade = calculator.calculate("90", "85", "80", "75", "70", listOf("80", "75", "70", "85", "90"))
        assertEquals(78.0, grade, 0.01)
    }

}