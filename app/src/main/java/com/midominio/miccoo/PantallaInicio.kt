package com.midominio.miccoo

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.graphics.TransformOrigin
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
    val animacionTexto by animateFloatAsState(
        targetValue = 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessVeryLow
        )
    )
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        empezarAnimacion = true
        delay(2000)
        navController.popBackStack()
        navController.navigate(Screens.PANTALLAPRINCIPAL.ruta)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = empezarAnimacion,
            enter = fadeIn(
                animationSpec = tween(
                    durationMillis = 800,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    })
            ),
            exit = scaleOut(
                animationSpec = tween(
                    durationMillis = 1000,
                    delayMillis = 10
                )
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.punomiccoo),
                contentDescription = "Icono aplicación",
                Modifier
                    .size(300.dp, 300.dp)
                //.alpha(alphaAnimacion.value)

            )
        }
        AnimatedVisibility(
            visible = empezarAnimacion,
            enter = scaleIn(transformOrigin = TransformOrigin(0f, 0f)) +
                    fadeIn(),
            exit = scaleOut()
        ) {
            Text(
                text = "miCCOO",
                fontSize = 30.sp,
                color = MaterialTheme.colors.onPrimary,
                //modifier = Modifier.alpha(alphaAnimacion.value)
            )
        }
    }
}