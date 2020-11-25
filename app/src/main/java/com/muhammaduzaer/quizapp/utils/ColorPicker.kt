package com.muhammaduzaer.quizapp.utils

class ColorPicker {
    val colors = arrayOf(
        "#34c9ab",
        "#1b9615",
        "#dea9f2",
        "#bfe04a",
        "#e0ba62",
        "#ddc827"
    )
    var currentColorIndex = 0

    fun getColor():String{
        currentColorIndex = (currentColorIndex + 1) % colors.size
        return colors[currentColorIndex]
    }
}