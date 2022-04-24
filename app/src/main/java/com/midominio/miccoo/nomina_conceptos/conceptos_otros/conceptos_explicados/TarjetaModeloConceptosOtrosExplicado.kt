package com.midominio.miccoo.nomina_conceptos.conceptos_otros.conceptos_explicados

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun TarjetaModeloConceptosOtrosExplicado(
    concepto: String,
    conceptoPrimero: String,
    resultadoPrimero: String,
    operador: String,
    conceptoSegundo: String,
    resultadoSegundo: String,
    resultado: String,

    ) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = concepto,
                textAlign = TextAlign.Center,
                fontSize = MaterialTheme.typography.h5.fontSize,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(3.dp))
            Text(
                text = "¿Cómo se calcula?",
                textAlign = TextAlign.Center,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(20.dp))
            Row {
                Card(
                    elevation = 4.dp,
                    border = BorderStroke(1.dp, Color.Red),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(6.dp)
                        .size(140.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(4.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = conceptoPrimero,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.size(3.dp))
                        Text(
                            text = resultadoPrimero,
                            fontSize = 20.sp
                        )

                    }
                }
                Text(
                    text = operador,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .align(CenterVertically)
                        .padding(20.dp)
                )
                Card(
                    elevation = 4.dp,
                    border = BorderStroke(1.dp, Color.Blue),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(6.dp)
                        .size(140.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(4.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = conceptoSegundo,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Clip,
                            modifier = Modifier.padding(3.dp)
                        )
                        Spacer(modifier = Modifier.size(3.dp))
                        Text(
                            text = resultadoSegundo,
                            fontSize = 20.sp
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.size(16.dp))

            Card(
                elevation = 4.dp,
                border = BorderStroke(1.dp, Color.Green),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(6.dp)
                    .size(140.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(4.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Resultado", fontSize = 20.sp, textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.size(3.dp))
                    Text(text = "=", textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.size(3.dp))
                    Text(
                        text = resultado,
                        fontSize = 20.sp
                    )

                }
            }
            Spacer(modifier = Modifier.size(10.dp))
        }
    }
}