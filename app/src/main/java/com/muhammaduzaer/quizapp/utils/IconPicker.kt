package com.muhammaduzaer.quizapp.utils

import com.muhammaduzaer.quizapp.R

class IconPicker {

    val icons = arrayOf(
        R.drawable.icon1_science,
        R.drawable.icon2_book,
        R.drawable.icon3_book,
        R.drawable.icon4_computer,
        R.drawable.icon5_scholarship,
        R.drawable.icon6_glasses
    )

    var currentIcon = 0

    fun getIcons(): Int {
        currentIcon = (currentIcon + 1) % icons.size
        return icons[currentIcon]
    }
}