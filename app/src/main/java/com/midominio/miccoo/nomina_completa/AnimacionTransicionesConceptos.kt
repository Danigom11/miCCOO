package com.midominio.miccoo.nomina_completa

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp


@ExperimentalAnimationApi
@Composable
fun AnimarVisibilidad(visible: Boolean, densidad: Density, composable: @Composable () -> Unit) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically {
            with(densidad) { -40.dp.roundToPx() }
        } + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(
            initialAlpha = 0.3f
        ),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()
    ) {
        Column {
            composable()
        }
    }
}