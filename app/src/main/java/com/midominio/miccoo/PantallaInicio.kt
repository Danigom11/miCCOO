package com.midominio.miccoo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.midominio.miccoo._pagina_principal.Screens
import kotlinx.coroutines.delay

@ExperimentalAnimationApi
@Composable
fun PantallaInicio(navController: NavHostController) {
    var empezarAnimacion by remember {
        mutableStateOf(false)
    }
    val alphaAnimacion = animateFloatAsState(
        targetValue = if (empezarAnimacion) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )
    LaunchedEffect(key1 = true) {
        empezarAnimacion = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screens.PANTALLAPRINCIPAL.ruta)
    }
    AnimatedVisibility(
        visible = true,
        enter = fadeIn(
            animationSpec = tween(
                durationMillis = 3000,
                delayMillis = 100
            )
        ),
        exit = scaleOut()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.punomiccoo),
                contentDescription = "Icono aplicación",
                Modifier
                    .size(300.dp, 300.dp)
                    .alpha(alphaAnimacion.value)
            )
            Text(
                text = "miCCOO",
                fontSize = 30.sp,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}