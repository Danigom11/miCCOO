package com.midominio.miccoo.nomina_conceptos.conceptos_otros.conceptos_explicados

import android.icu.text.NumberFormat
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
import com.midominio.miccoo.BarraSuperior
import com.midominio.miccoo.ViewModelNomina
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun IndemnizacionDespido(viewModelNomina: ViewModelNomina) {
    val numeroAMoneda = NumberFormat.getCurrencyInstance()
    val scrollState = rememberScrollState()
    Scaffold(
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .padding(8.dp),
        topBar = {
            BarraSuperior()
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
            ) {
                Text(
                    text = "Indemnización por despido",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.size(3.dp))
                Text(
                    text = "¿Cómo se calcula?",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "1. Calcula el salario diario",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary,
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
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colors.onPrimary
                            )
                            Spacer(modifier = Modifier.size(3.dp))
                            Text(
                                text = numeroAMoneda.format(viewModelNomina.retribucionAnualConAntiguedad),
                                fontSize = 16.sp
                            )
                        }
                    }
                    Text(
                        text = ":",
                        fontSize = 30.sp,
                        color = MaterialTheme.colors.onPrimary,
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
                                text = "Días\nlaborales\naño",
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colors.onPrimary,
                                overflow = TextOverflow.Clip,
                                modifier = Modifier.padding(3.dp)
                            )
                            Spacer(modifier = Modifier.size(1.dp))
                            Text(
                                text = "360",
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 20.sp
                            )
                        }
                    }
                    Text(
                        text = "=",
                        color = MaterialTheme.colors.onPrimary,
                        fontSize = 30.sp,
                        modifier = Modifier
                            .align(CenterVertically)
                    )
                    Card(
                        elevation = 4.dp,
                        border = BorderStroke(1.dp, Color.Green),
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
                                color = MaterialTheme.colors.onPrimary,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.size(3.dp))
                            Text(
                                text = numeroAMoneda.format(viewModelNomina.salarioDiarioRedondeado),
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 20.sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "2. Multiplica por la indemnización correspondiente",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Finalización de contrato",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary,
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
                                text = "Salario\ndiario",
                                color = MaterialTheme.colors.onPrimary,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.size(3.dp))
                            Text(
                                text = numeroAMoneda.format(viewModelNomina.salarioDiarioRedondeado),
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 16.sp
                            )
                        }
                    }
                    Text(
                        text = "x",
                        color = MaterialTheme.colors.onPrimary,
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
                                text = "Días\nindemnización",
                                color = MaterialTheme.colors.onPrimary,
                                maxLines = 2,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(3.dp)
                            )
                            Spacer(modifier = Modifier.size(1.dp))
                            Text(
                                text = "12",
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 20.sp
                            )
                        }
                    }
                    Text(
                        text = "=",
                        color = MaterialTheme.colors.onPrimary,
                        fontSize = 30.sp,
                        modifier = Modifier
                            .align(CenterVertically)
                    )
                    Card(
                        elevation = 4.dp,
                        border = BorderStroke(1.dp, Color.Green),
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
                                text = "Total por\nun año",
                                color = MaterialTheme.colors.onPrimary,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.size(3.dp))
                            Text(
                                text = numeroAMoneda.format(viewModelNomina.finalizacionContratoRedondeado),
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Causas objetivas",
                    color = MaterialTheme.colors.onPrimary,
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
                                text = "Salario\ndiario",
                                color = MaterialTheme.colors.onPrimary,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.size(3.dp))
                            Text(
                                text = numeroAMoneda.format(viewModelNomina.salarioDiarioRedondeado),
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 16.sp
                            )
                        }
                    }
                    Text(
                        text = "x",
                        color = MaterialTheme.colors.onPrimary,
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
                                text = "Días\nindemnización",
                                color = MaterialTheme.colors.onPrimary,
                                maxLines = 2,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(3.dp)
                            )
                            Spacer(modifier = Modifier.size(1.dp))
                            Text(
                                text = "20",
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 20.sp
                            )
                        }
                    }
                    Text(
                        text = "=",
                        color = MaterialTheme.colors.onPrimary,
                        fontSize = 30.sp,
                        modifier = Modifier
                            .align(CenterVertically)
                    )
                    Card(
                        elevation = 4.dp,
                        border = BorderStroke(1.dp, Color.Green),
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
                                text = "Total por\nun año",
                                color = MaterialTheme.colors.onPrimary,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.size(3.dp))
                            Text(
                                text = numeroAMoneda.format(viewModelNomina.causasObjetivasRedondeado),
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Despido improcedente",
                    color = MaterialTheme.colors.onPrimary,
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
                                text = "Salario\ndiario",
                                color = MaterialTheme.colors.onPrimary,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.size(3.dp))
                            Text(
                                text = numeroAMoneda.format(viewModelNomina.salarioDiarioRedondeado),
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 16.sp
                            )
                        }
                    }
                    Text(
                        text = "x",
                        color = MaterialTheme.colors.onPrimary,
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
                                text = "Días\nindemnización",
                                color = MaterialTheme.colors.onPrimary,
                                maxLines = 2,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(3.dp)
                            )
                            Spacer(modifier = Modifier.size(1.dp))
                            Text(
                                text = "33",
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 20.sp
                            )
                        }
                    }
                    Text(
                        text = "=",
                        color = MaterialTheme.colors.onPrimary,
                        fontSize = 30.sp,
                        modifier = Modifier
                            .align(CenterVertically)
                    )
                    Card(
                        elevation = 4.dp,
                        border = BorderStroke(1.dp, Color.Green),
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
                                text = "Total por\nun año",
                                color = MaterialTheme.colors.onPrimary,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.size(3.dp))
                            Text(
                                text = numeroAMoneda.format(viewModelNomina.despidoImprocedenteRedondeado),
                                color = MaterialTheme.colors.onPrimary,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    )
}


