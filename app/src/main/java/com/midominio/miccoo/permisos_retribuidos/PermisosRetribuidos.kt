package com.midominio.miccoo.permisos_retribuidos

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.midominio.miccoo.BarraSuperior
import com.midominio.miccoo.ui.theme.MiCCOOTheme
import com.midominio.miccoo.ui.theme.tarjetaExpandidaColorFondo

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun PermisosRetribuidos() {
    MiCCOOTheme {
        Scaffold(
            backgroundColor = Color.Transparent,
            modifier = Modifier
                .padding(8.dp),
            topBar = {
                BarraSuperior()
            },
            content = {
                PantallaPermisosRetribuidos(listaContenido = listaContenidoTarjetasPermisoRetribuido)
            },
        )
    }
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun PantallaPermisosRetribuidos(listaContenido: List<DataClassContenidoTarjetasPermisosRetribuidos>) {
    LazyColumn {
        items(listaContenido) { dataClassContenidoTarjetas ->
            TarjetaModeloPermisosRetribuidos(
                dataClassContenidoTarjetas
            )
        }
    }
}

@ExperimentalAnimationApi
@SuppressLint("UnusedTransitionTargetStateParameter")
@ExperimentalMaterialApi
@Composable
fun TarjetaModeloPermisosRetribuidos(
    dataClassContenido: DataClassContenidoTarjetasPermisosRetribuidos
) {

    var cambiarExpandir by rememberSaveable { mutableStateOf(false) }

    // Controla las transiciones de forma animada
    val transicionEstado = remember {
        MutableTransitionState(cambiarExpandir).apply {
            targetState = !cambiarExpandir
        }
    }

    // Actualiza las transiciones
    val transicion = updateTransition(transicionEstado, label = "transition")

    // Cambia el padding horizontal
    val tarjetaMargenHorizontal by transicion.animateDp({
        tween(durationMillis = EXPAND_ANIMATION_DURATION)
    }, label = "paddingTransicion") {
        if (cambiarExpandir) 38.dp else 4.dp
    }

    // Cambia el color de forma animada
    val superficieColorFondo by transicion.animateColor({
        tween(durationMillis = EXPAND_ANIMATION_DURATION)
    }, label = "superficieColorFondo") {
        if (cambiarExpandir) tarjetaExpandidaColorFondo else MaterialTheme.colors.onSecondary
    }

    // Controlar la rotación de la flecha
    val rotacion by transicion.animateFloat({
        tween(durationMillis = EXPAND_ANIMATION_DURATION)
    }, label = "rotacionTransicion") {
        if (cambiarExpandir) 0f else 180f
    }

    // Controlar elevación de la tarjeta
    val tarjetaElevacion by transicion.animateDp({
        tween(durationMillis = EXPAND_ANIMATION_DURATION)
    }, label = "elevacionTransicion") {
        if (cambiarExpandir) 24.dp else 4.dp
    }

    // Controlar si tiene borde redondeado o no
    val tarjetaEsquinasRedondeadas by transicion.animateDp({
        tween(
            durationMillis = EXPAND_ANIMATION_DURATION,
            easing = FastOutSlowInEasing
        )
    }, label = "transicionBordes") {
        if (cambiarExpandir) 0.dp else 16.dp
    }

    Card(
        backgroundColor = superficieColorFondo,
        elevation = tarjetaElevacion,
        modifier = Modifier
            .padding(
                horizontal = tarjetaMargenHorizontal,
                vertical = 8.dp
            )
            .clickable {
                cambiarExpandir = !cambiarExpandir
            },
        shape = RoundedCornerShape(tarjetaEsquinasRedondeadas)
    ) {
        Column {
            Row(
                modifier = Modifier.padding(all = 8.dp),
            ) {
                Image(
                    painter = painterResource(id = dataClassContenido.imagen),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                        .border(
                            1.5.dp,
                            MaterialTheme.colors.secondaryVariant,
                            RoundedCornerShape(20.dp)
                        )
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    modifier = Modifier
                        .weight(6f)
                        .height(90.dp)
                ) {
                    Text(
                        dataClassContenido.permisoRetribuido,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(1.0f)
                            .padding(top = 16.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(
                            dataClassContenido.retribucion,
                            style = MaterialTheme.typography.subtitle2,
                            modifier = Modifier
                                .weight(1.0f)
                                .padding(top = 2.dp),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .rotate(rotacion)
                        .align(alignment = CenterVertically),
                    onClick = {
                        cambiarExpandir = !cambiarExpandir
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropUp,
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            ExpandableContent(visible = cambiarExpandir, convenio = dataClassContenido.convenio)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun ExpandableContent(
    visible: Boolean = true,
    convenio: String
) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FADE_IN_ANIMATION_DURATION,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(EXPAND_ANIMATION_DURATION))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FADE_OUT_ANIMATION_DURATION,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(COLLAPSE_ANIMATION_DURATION))
    }
    AnimatedVisibility(
        visible = visible,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = convenio,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PermisosRetribuidosPreview() {
    PermisosRetribuidos()
}