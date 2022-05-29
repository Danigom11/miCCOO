package com.midominio.miccoo.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.midominio.miccoo.R

val ComicNeue = FontFamily(
    Font(R.font.comicneue_bold, FontWeight.Bold),
    Font(R.font.comicneue_bolditalic, FontWeight.ExtraBold),
    Font(R.font.comicneue_italic, FontWeight.Thin),
    Font(R.font.comicneue_light, FontWeight.Light),
    Font(R.font.comicneue_regular, FontWeight.Normal),
    Font(R.font.comicneue_lightitalic, FontWeight.ExtraLight)
)

// Set of Material typography styles to start with
val Tipografia = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)