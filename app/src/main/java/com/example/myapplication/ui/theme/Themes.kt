package com.example.myapplication.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

sealed class Themes (
    val dark:Colors,
    val light:Colors){

    fun getColor(): Color =light.primary

    object Purple:Themes(DarkColorPalette, LightColorPalette)
    object Yellow:Themes(DarkYellow, LightYellow)
    object Blue:Themes(DarkBlue, LightBlue)
    object Green:Themes(DarkGreen, LightGreen)

}
