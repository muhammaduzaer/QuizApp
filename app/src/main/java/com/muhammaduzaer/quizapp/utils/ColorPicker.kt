package com.muhammaduzaer.quizapp.utils

object ColorPicker {
    val colors = arrayOf(
        "#34c9ab",
        "#1b9615",
        "#dea9f2",
        "#bfe04a",
        "#e0ba62",
        "#ddc827",
        "#393ca8",
        "#6a1ea8",
        "#ea7ee8",
        "#4c4c4c",
        "#3ba4af",
        "#bf5311",
        "#a8a89c"

    )
    var currentColorIndex = 0

    fun getColor():String{
        currentColorIndex = (currentColorIndex + 1) % colors.size
        return colors[currentColorIndex]
    }
}