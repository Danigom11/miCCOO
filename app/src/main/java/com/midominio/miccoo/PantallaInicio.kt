package com.midominio.miccoo

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.midominio.miccoo._pagina_principal.Screens
import com.midominio.miccoo.ui.theme.ComicNeue
import kotlinx.coroutines.delay

@ExperimentalAnimationApi
@Composable
fun PantallaInicio(navController: NavHostController) {
    var empezarAnimacion by remember {
        mutableStateOf(false)
    }
    val alphaAnimacion = animateFloatAsState(
        targetValue = if (empezarAnimacion) 1f else 0f,
        animationSpec = tween(durationMillis = 2000)
    )
    val tamanoAnimacion = animateDpAsState(
        targetValue = 150.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessVeryLow
        )
    )
    val animacionTexto by animateFloatAsState(
        targetValue = 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessVeryLow
        )
    )
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
                    durationMillis = 2000,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    })
            ),
            exit = scaleOut()
        ) {
            Image(
                contentScale = ContentScale.FillHeight,
                painter = painterResource(id = R.drawable.punomiccoo),
                contentDescription = "Icono aplicación",
                modifier = Modifier
                    .alpha(alphaAnimacion.value)
                    .size(tamanoAnimacion.value)
                    .clip(CircleShape)
                //.alpha(alphaAnimacion.value)

            )
        }
        Spacer(modifier = Modifier.size(20.dp))
        AnimatedVisibility(
            visible = empezarAnimacion,
            enter = scaleIn(transformOrigin = TransformOrigin(0f, 0f)) +
                    fadeIn(),
            exit = scaleOut()
        ) {
            Text(
                text = "miCCOO",
                fontSize = 50.sp,
                color = MaterialTheme.colors.onPrimary,
                style = TextStyle(
                    fontFamily = ComicNeue
                ),
                modifier = Modifier.weight(animacionTexto)
            )
        }
    }
}