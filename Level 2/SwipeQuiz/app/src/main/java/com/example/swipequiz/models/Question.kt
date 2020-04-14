package com.example.swipequiz.models

data class Question (
    var question: String,
    var answer: Boolean
) {
    companion object {
        val QUESTIONS = arrayOf(
            Question("A 'val' and a 'var' are the same", false),
            Question("In Kotlin 'when' replaces Java's 'switch' operator", true),
            Question("I didn't start late due to personal circumstances", false),
            Question("I didn't underestimate this course", false),
            Question("Mobile Application Development has exciting assignments", true)
        )
    }
}