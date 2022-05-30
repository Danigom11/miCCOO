package com.midominio.miccoo.tests

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.midominio.miccoo.BarraSuperior
import com.midominio.miccoo.nomina_calculadora.AnimarVisibilidad
import com.midominio.miccoo.nomina_calculadora.Boton
import com.midominio.miccoo.nomina_calculadora.TextoConcepto
import com.midominio.miccoo.ui.theme.ComicNeue
import com.midominio.miccoo.ui.theme.MiCCOOTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun Tests(viewModelTests: ViewModelTests) {
    var preguntaAzarNumero = (0..5).random()
    var estadoPreguntaAzarNumero = remember { mutableStateOf(preguntaAzarNumero) }
    val respuestaElegida = remember { mutableStateOf("") }
    val pregunta = listaTests[estadoPreguntaAzarNumero.value].pregunta
    val respuestaUno = listaTests[estadoPreguntaAzarNumero.value].respuestaCorrecta
    val respuestaDos = listaTests[estadoPreguntaAzarNumero.value].respuestaIncorrectaUno
    val respuestaTres =
        listaTests[estadoPreguntaAzarNumero.value].respuestaIncorrectaDos
    val densidad = LocalDensity.current
    var visibleTests by rememberSaveable { mutableStateOf(true) }
    var visibleTestsSiguiente by rememberSaveable { mutableStateOf(false) }

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
                    AnimarVisibilidad(visible = visibleTests, densidad = densidad) {
                        Column {
                            Spacer(modifier = Modifier.size(30.dp))
                            TextoConcepto(texto = "¡PONTE A PRUEBA!")
                            Spacer(modifier = Modifier.size(20.dp))
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 30.dp, end = 30.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = pregunta,
                                        color = MaterialTheme.colors.onPrimary,
                                        fontSize = 24.sp,
                                        style = TextStyle(
                                            fontFamily = ComicNeue
                                        ),

                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                                Spacer(modifier = Modifier.size(10.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = respuestaElegida.value == respuestaUno,
                                        onClick = { respuestaElegida.value = respuestaUno },
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = Color.Green,
                                            unselectedColor = Color.Red,
                                            disabledColor = Color.LightGray
                                        )
                                    )
                                    Text(
                                        text = respuestaUno,
                                        color = MaterialTheme.colors.onPrimary,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = respuestaElegida.value == respuestaDos,
                                        onClick = { respuestaElegida.value = respuestaDos },
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = Color.Green,
                                            unselectedColor = Color.Red,
                                            disabledColor = Color.LightGray
                                        )
                                    )
                                    Text(
                                        text = respuestaDos,
                                        color = MaterialTheme.colors.onPrimary,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = respuestaElegida.value == respuestaTres,
                                        onClick = { respuestaElegida.value = respuestaTres },
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = Color.Green,
                                            unselectedColor = Color.Red,
                                            disabledColor = Color.LightGray
                                        )
                                    )
                                    Text(
                                        text = respuestaTres,
                                        color = MaterialTheme.colors.onPrimary,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.size(20.dp))
                        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
                            Boton(
                                destino = visibleTests, destinoCambia = {
                                    visibleTests = false
                                    preguntaAzarNumero = (0..5).random()
                                    visibleTestsSiguiente = true
                                }, texto = "Siguiente",
                                modifier = Modifier
                            )
                        }
                        Spacer(modifier = Modifier.size(20.dp))
                    }
                    AnimarVisibilidad(visible = visibleTestsSiguiente, densidad = densidad) {
                        Column {
                            Spacer(modifier = Modifier.size(30.dp))
                            TextoConcepto(texto = "¡PONTE A PRUEBA!")
                            Spacer(modifier = Modifier.size(20.dp))
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 30.dp, end = 30.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = pregunta,
                                        color = MaterialTheme.colors.onPrimary,
                                        fontSize = 24.sp,
                                        style = TextStyle(
                                            fontFamily = ComicNeue
                                        ),

                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                                Spacer(modifier = Modifier.size(10.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = respuestaElegida.value == respuestaUno,
                                        onClick = { respuestaElegida.value = respuestaUno },
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = Color.Green,
                                            unselectedColor = Color.Red,
                                            disabledColor = Color.LightGray
                                        )
                                    )
                                    Text(
                                        text = respuestaUno,
                                        color = MaterialTheme.colors.onPrimary,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = respuestaElegida.value == respuestaDos,
                                        onClick = { respuestaElegida.value = respuestaDos },
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = Color.Green,
                                            unselectedColor = Color.Red,
                                            disabledColor = Color.LightGray
                                        )
                                    )
                                    Text(
                                        text = respuestaDos,
                                        color = MaterialTheme.colors.onPrimary,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = respuestaElegida.value == respuestaTres,
                                        onClick = { respuestaElegida.value = respuestaTres },
                                        colors = RadioButtonDefaults.colors(
                                            selectedColor = Color.Green,
                                            unselectedColor = Color.Red,
                                            disabledColor = Color.LightGray
                                        )
                                    )
                                    Text(
                                        text = respuestaTres,
                                        color = MaterialTheme.colors.onPrimary,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.size(20.dp))
                        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
                            Boton(
                                destino = visibleTestsSiguiente, destinoCambia = {
                                    visibleTestsSiguiente = false
                                    preguntaAzarNumero = (0..5).random()
                                    visibleTests = true
                                }, texto = "Siguiente",
                                modifier = Modifier
                            )
                        }
                        Spacer(modifier = Modifier.size(20.dp))
                    }
                }
            }
        )
    }
}
