package com.midominio.miccoo.nomina_datos_generales.conceptos_otros.conceptos_explicados

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
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
import com.midominio.miccoo.BarraSuperiorMiCCOO
import com.midominio.miccoo.nomina_datos_generales.ViewModelNomina
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun Huelga(viewModelNomina: ViewModelNomina) {
    val scrollState = rememberScrollState()
    Scaffold(
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .padding(8.dp),
        topBar = {
            BarraSuperiorMiCCOO()
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
            ) {
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = "Huelga",
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
                Spacer(modifier = Modifier.size(3.dp))
                Text(
                    text = "1. Calcular salario diario",
                    textAlign = TextAlign.Center,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.size(4.dp))
                Row {
                    Card(
                        elevation = 4.dp,
                        border = BorderStroke(1.dp, Color.Red),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .padding(6.dp)
                            .size(100.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(4.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Salario\nanual",
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.size(3.dp))
                            Text(
                                text = viewModelNomina.salarioAnualRedondeado,
                                fontSize = 16.sp
                            )
                        }
                    }
                    Text(
                        text = ":",
                        fontSize = 30.sp,
                        modifier = Modifier
                            .align(CenterVertically)
                    )
                    Card(
                        elevation = 4.dp,
                        border = BorderStroke(1.dp, Color.Blue),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .padding(6.dp)
                            .size(100.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(4.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Total\npagas año",
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp,
                                overflow = TextOverflow.Clip,
                                modifier = Modifier.padding(3.dp)
                            )
                            Spacer(modifier = Modifier.size(1.dp))
                            Text(
                                text = "15",
                                fontSize = 20.sp
                            )
                        }
                    }
                    Text(
                        text = ":",
                        fontSize = 30.sp,
                        modifier = Modifier
                            .align(CenterVertically)
                    )
                    Card(
                        elevation = 4.dp,
                        border = BorderStroke(1.dp, Color.Yellow),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .padding(6.dp)
                            .size(100.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(4.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Días\nmes", textAlign = TextAlign.Center)
                            Spacer(modifier = Modifier.size(3.dp))
                            Text(
                                text = "30",
                                fontSize = 20.sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.size(4.dp))
                Card(
                    elevation = 4.dp,
                    border = BorderStroke(1.dp, Color.Green),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(6.dp)
                        .size(120.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(4.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Salario diario", textAlign = TextAlign.Center)
                        Text(text = "=", textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.size(3.dp))
                        Text(
                            text = viewModelNomina.salarioDiaHuelgaRedondeado,
                            fontSize = 20.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.size(3.dp))
                Text(
                    text = "2. Sumar la parte proporcional del descanso semanal",
                    textAlign = TextAlign.Center,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(
                    text = "(Por ejemplo, si descansas 2 días a la semana, cada día que trabajas generas 0,4 días de descanso)",
                    textAlign = TextAlign.Center,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.size(4.dp))
                Row {
                    Card(
                        elevation = 4.dp,
                        border = BorderStroke(1.dp, Color.Red),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .padding(6.dp)
                            .size(100.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(4.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Salario\ndiario",
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.size(3.dp))
                            Text(
                                text = viewModelNomina.salarioDiaHuelgaRedondeado,
                                fontSize = 16.sp
                            )
                        }
                    }
                    Text(
                        text = "X",
                        fontSize = 30.sp,
                        modifier = Modifier
                            .align(CenterVertically)
                    )
                    Card(
                        elevation = 4.dp,
                        border = BorderStroke(1.dp, Color.Blue),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .padding(6.dp)
                            .size(100.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(4.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Descanso generado",
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp,
                                overflow = TextOverflow.Clip,
                                modifier = Modifier.padding(3.dp)
                            )
                            Spacer(modifier = Modifier.size(1.dp))
                            Text(
                                text = "1,4",
                                fontSize = 20.sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.size(4.dp))
                Card(
                    elevation = 4.dp,
                    border = BorderStroke(1.dp, Color.Green),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(6.dp)
                        .size(120.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(4.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Huelga", textAlign = TextAlign.Center)
                        Text(text = "=", textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.size(3.dp))
                        Text(
                            text = viewModelNomina.huelgaRedondeado,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    )
}