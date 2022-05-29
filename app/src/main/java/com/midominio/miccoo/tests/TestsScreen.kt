package com.midominio.miccoo.tests

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.midominio.miccoo.nomina_calculadora.TextoConcepto
import com.midominio.miccoo.ui.theme.ComicNeue

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun Tests(viewModelTests: ViewModelTests) {
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
        Column {
            Spacer(modifier = Modifier.size(30.dp))
            TextoConcepto(texto = "¡PONTE A PRUEBA!")
            Spacer(modifier = Modifier.size(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
            ) {
                //todo poner aquí el grupo de botones
                val respuestaElegida = remember { mutableStateOf("") }
                val pregunta = listaTests[0].pregunta
                val respuestaUno = listaTests[0].respuestaCorrecta
                val respuestaDos = listaTests[0].respuestaIncorrectaUno
                val respuestaTres = listaTests[0].respuestaIncorrectaDos

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

        Row {
            Button(onClick = {
            }) {

            }
        }
        Spacer(modifier = Modifier.size(20.dp))

    }
}
