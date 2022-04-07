package com.midominio.miccoo.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("ConflictingOnColor")
private val ColoresModoOscuro = darkColors(
    primary = primary,
    primaryVariant = primaryLight,
    secondary = secondary,
    background = Color.Black,
    onPrimary = Color.White,
    onSecondary = Color.Black

)

@SuppressLint("ConflictingOnColor")
private val ColoresModoClaro = lightColors(
    primary = primary,
    primaryVariant = primaryLight,
    secondary = secondary,
    background = fondo,
    onPrimary = Color.Black,
    onSecondary = Color.White
)

@Composable
fun MiCCOOTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val systemUiController = rememberSystemUiController()
    if (darkTheme) {
        systemUiController.setSystemBarsColor(
            color = fondo
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = Color.Black
        )
    }
    MaterialTheme(
        colors = if (darkTheme) ColoresModoOscuro else ColoresModoClaro,
        typography = Tipografia,
        shapes = Formas,
        content = content,
    )
}
