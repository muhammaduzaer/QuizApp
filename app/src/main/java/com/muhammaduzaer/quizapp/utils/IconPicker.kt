package com.muhammaduzaer.quizapp.utils

import com.muhammaduzaer.quizapp.R

object IconPicker {

    private val icons = arrayOf(
        R.drawable.icon1_science,
        R.drawable.icon2_book,
        R.drawable.icon3_book,
        R.drawable.icon4_computer,
        R.drawable.icon5_scholarship,
        R.drawable.icon6_glasses,
        R.drawable.icon7_lamp,
        R.drawable.icon8_bell,
        R.drawable.icon9_ideabulb,
        R.drawable.icon10_pencil,
        R.drawable.icon11_abacus,
        R.drawable.icon12_winner
    )

    private var currentIcon = 0

    fun getIcons(): Int {
        currentIcon = (currentIcon + 1) % icons.size
        return icons[currentIcon]
    }
}