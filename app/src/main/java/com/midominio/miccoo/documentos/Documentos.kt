package com.midominio.miccoo.documentos

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.midominio.miccoo.BarraSuperior
import com.midominio.miccoo.nomina_calculadora.TextoTitulo
import com.midominio.miccoo.nomina_calculadora.alturaCuadros
import com.midominio.miccoo.ui.theme.MiCCOOTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun Documentos() {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    MiCCOOTheme {
        Scaffold(
            backgroundColor = Color.Transparent,
            modifier = Modifier
                .padding(8.dp),
            topBar = {
                BarraSuperior()
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .padding(start = 10.dp, end = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.size(60.dp))

                    Column(
                        modifier = Modifier
                            .height(alturaCuadros)
                            .border(
                                BorderStroke(
                                    width = 2.dp,
                                    brush = Brush.horizontalGradient(
                                        listOf(
                                            Color.Green,
                                            Color.Red
                                        )
                                    )
                                ),
                                shape = RoundedCornerShape(5)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TextoTitulo(texto = "- Estatuto de los trabajadores")
                        TextoTitulo(texto = "- Convenio de Logística de Guadalajara")
                        TextoTitulo(texto = "- Acuerdo de transporte")
                        TextoTitulo(texto = "- Solicitudes")
                        TextoTitulo(texto = "- Guías")
                        Spacer(modifier = Modifier.size(60.dp))
                        OutlinedButton(
                            onClick = {
                                context.startActivity(
                                    Intent(Intent.ACTION_VIEW).also {
                                        it.data =
                                            Uri.parse("https://www.dropbox.com/sh/hdaljab5ml0zane/AAAmt2Jdr42b2_BBjcmEpcB4a?dl=0")
                                    }
                                )
                            },
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(width = 1.dp, color = Color.Red)
                        ) {
                            Text(
                                text = "VER DOCUMENTOS",
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 26.sp
                            )
                        }
                    }
                }
            }
        )
    }
}