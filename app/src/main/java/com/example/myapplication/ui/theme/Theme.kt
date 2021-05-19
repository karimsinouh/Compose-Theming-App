package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

 val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Purple500
)

 val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Purple500
)

 val LightYellow = lightColors(
    primary = Yellow500,
    primaryVariant = Yellow700,
    secondary = Yellow500
)

 val DarkYellow = darkColors(
    primary = Yellow200,
    primaryVariant = Yellow700,
    secondary = Yellow500
)

val LightBlue = lightColors(
    primary = Blue500,
    primaryVariant = Blue700,
    secondary = Blue500
)

val DarkBlue = darkColors(
    primary = Blue200,
    primaryVariant = Blue700,
    secondary = Blue500
)

val LightGreen = lightColors(
    primary = Green500,
    primaryVariant = Green700,
    secondary = Green500
)

val DarkGreen = darkColors(
    primary = Green200,
    primaryVariant = Green700,
    secondary = Green500
)


@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    themes: Themes,
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme)
        themes.dark
    else
        themes.light

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}