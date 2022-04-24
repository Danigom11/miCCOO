package com.midominio.miccoo.nomina_conceptos.conceptos_otros.conceptos_explicados

import android.icu.text.NumberFormat
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.midominio.miccoo.BarraSuperior
import com.midominio.miccoo.R
import com.midominio.miccoo.ViewModelNomina
import com.midominio.miccoo.nomina_calculadora.Boton
import com.midominio.miccoo.nomina_calculadora.Desplegable
import com.midominio.miccoo.opcionesAntiguedad
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun Antiguedad(viewModelNomina: ViewModelNomina) {
    val numeroAMoneda = NumberFormat.getCurrencyInstance()
    val scrollState = rememberScrollState()
    var visible by rememberSaveable { mutableStateOf(true) }
    val density = LocalDensity.current

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
            ) {
                AnimatedVisibility(
                    visible = !visible,
                    enter = slideInVertically {
                        with(density) { -40.dp.roundToPx() }
                    } + expandVertically(
                        expandFrom = Alignment.Top
                    ) + fadeIn(
                        initialAlpha = 0.3f
                    ),
                    exit = slideOutVertically() + shrinkVertically() + fadeOut()
                ) {
                    Column {
                        Desplegable(
                            visible = true,
                            expandible = viewModelNomina.expandirAntiguedad,
                            expandibleCambia = {
                                viewModelNomina.cambiarExpandirAntiguedad(
                                    it
                                )
                            },
                            seleccionado = viewModelNomina.seleccionadoAntiguedad,
                            seleccionadoCambia = {
                                viewModelNomina.seleccionadoCambiaAntiguedad(
                                    it
                                )
                            },
                            label = "Antigüedad",
                            opciones = opcionesAntiguedad
                        )
                    }
                }
                Boton(
                    destino = !visible,
                    destinoCambia = { visible = !visible },
                    texto = "Calcular",
                    modifier = Modifier
                )
                AnimatedVisibility(
                    visible = visible,
                    enter = slideInVertically {
                        with(density) { -40.dp.roundToPx() }
                    } + expandVertically(
                        expandFrom = Alignment.Top
                    ) + fadeIn(
                        initialAlpha = 0.3f
                    ),
                    exit = slideOutVertically() + shrinkVertically() + fadeOut()
                ) {
                    Spacer(modifier = Modifier.size(6.dp))
                    if (viewModelNomina.seleccionadoAntiguedad == "Sin antiguedad" || viewModelNomina.seleccionadoAntiguedad.isEmpty()) {
                        Column {
                            Spacer(modifier = Modifier.size(30.dp))
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp)
                                    .animateEnterExit(
                                        enter = scaleIn(animationSpec = tween(durationMillis = 1000)),
                                        exit = scaleOut(animationSpec = tween(durationMillis = 1000))
                                    ),
                                contentAlignment = Alignment.BottomCenter
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.sin_antiguedad),
                                    contentScale = ContentScale.FillBounds,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(width = 200.dp, height = 150.dp)
                                        .clip(shape = RoundedCornerShape(20.dp))
                                        .border(
                                            1.5.dp,
                                            MaterialTheme.colors.secondaryVariant,
                                            RoundedCornerShape(20.dp)
                                        )
                                )
                            }

                            Spacer(modifier = Modifier.size(30.dp))
                            Text(
                                text = "Con menos de dos años no tienes\nderecho a cobrar antigüedad",
                                color = MaterialTheme.colors.onPrimary,
                                textAlign = TextAlign.Center,
                                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                                fontStyle = FontStyle.Italic,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.size(18.dp))
                        }
                    } else {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.size(18.dp))
                            Text(
                                text = viewModelNomina.seleccionadoAntiguedad,
                                color = MaterialTheme.colors.onPrimary,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.size(14.dp))
                            Row(modifier = Modifier.horizontalScroll(state = scrollState)) {
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
                                            text = "Salario base",
                                            color = MaterialTheme.colors.onPrimary,
                                            textAlign = TextAlign.Center
                                        )
                                        Spacer(modifier = Modifier.size(3.dp))
                                        Text(
                                            text = numeroAMoneda.format(viewModelNomina.salarioBase.toDouble()),
                                            color = MaterialTheme.colors.onPrimary,
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                                Text(
                                    text = "+",
                                    color = MaterialTheme.colors.onPrimary,
                                    fontSize = 30.sp,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
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
                                            text = "Porcentaje",
                                            color = MaterialTheme.colors.onPrimary,
                                            textAlign = TextAlign.Center,
                                            overflow = TextOverflow.Clip,
                                            modifier = Modifier.padding(3.dp)
                                        )
                                        Spacer(modifier = Modifier.size(3.dp))
                                        Text(
                                            text = viewModelNomina.antiguedadPorcentaje,
                                            color = MaterialTheme.colors.onPrimary,
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                                Text(
                                    text = "=",
                                    color = MaterialTheme.colors.onPrimary,
                                    fontSize = 30.sp,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
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
                                            text = "Concepto antigüedad",
                                            textAlign = TextAlign.Center,
                                            color = MaterialTheme.colors.onPrimary
                                        )
                                        Spacer(modifier = Modifier.size(3.dp))
                                        Text(
                                            text = numeroAMoneda.format(viewModelNomina.antiguedadConceptoRedondeada),
                                            color = MaterialTheme.colors.onPrimary,
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                            }
                            Row(modifier = Modifier.horizontalScroll(state = scrollState)) {
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
                                            text = "Pagas prorrateadas",
                                            color = MaterialTheme.colors.onPrimary,
                                            textAlign = TextAlign.Center
                                        )
                                        Spacer(modifier = Modifier.size(3.dp))
                                        Text(
                                            text = numeroAMoneda.format(viewModelNomina.pagasExtrasProrrateadasFijas),
                                            color = MaterialTheme.colors.onPrimary,
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                                Text(
                                    text = "+",
                                    color = MaterialTheme.colors.onPrimary,
                                    fontSize = 30.sp,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
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
                                            text = "Porcentaje",
                                            color = MaterialTheme.colors.onPrimary,
                                            textAlign = TextAlign.Center,
                                            overflow = TextOverflow.Clip,
                                            modifier = Modifier.padding(3.dp)
                                        )
                                        Spacer(modifier = Modifier.size(3.dp))
                                        Text(
                                            text = viewModelNomina.antiguedadPorcentaje,
                                            color = MaterialTheme.colors.onPrimary,
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                                Text(
                                    text = "=",
                                    color = MaterialTheme.colors.onPrimary,
                                    fontSize = 30.sp,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
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
                                            text = "Resultado",
                                            textAlign = TextAlign.Center,
                                            color = MaterialTheme.colors.onPrimary
                                        )
                                        Spacer(modifier = Modifier.size(3.dp))
                                        Text(
                                            text = "+ ${viewModelNomina.pagasExtrasProrrateadasFijasAntiguedadDiferencia}",
                                            color = MaterialTheme.colors.onPrimary,
                                            fontSize = 16.sp
                                        )
                                        Text(
                                            text = "= ${numeroAMoneda.format(viewModelNomina.pagasExtrasProrrateadasFijasAntiguedadTotal)}",
                                            color = MaterialTheme.colors.onPrimary,
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                            }
                            Row(modifier = Modifier.horizontalScroll(state = scrollState)) {
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
                                            text = "Concepto antigüedad",
                                            color = MaterialTheme.colors.onPrimary,
                                            textAlign = TextAlign.Center
                                        )
                                        Spacer(modifier = Modifier.size(3.dp))
                                        Text(
                                            text = numeroAMoneda.format(viewModelNomina.antiguedadConceptoRedondeada),
                                            color = MaterialTheme.colors.onPrimary,
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                                Text(
                                    text = "+",
                                    color = MaterialTheme.colors.onPrimary,
                                    fontSize = 30.sp,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
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
                                            text = "Aumento pagas extras",
                                            color = MaterialTheme.colors.onPrimary,
                                            textAlign = TextAlign.Center,
                                            overflow = TextOverflow.Clip,
                                            modifier = Modifier.padding(3.dp)
                                        )
                                        Spacer(modifier = Modifier.size(3.dp))
                                        Text(
                                            text = numeroAMoneda.format(viewModelNomina.pagasExtrasProrrateadasFijasAntiguedadDiferencia),
                                            color = MaterialTheme.colors.onPrimary,
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                                Text(
                                    text = "=",
                                    color = MaterialTheme.colors.onPrimary,
                                    fontSize = 30.sp,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
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
                                            text = "Total antigüedad mes",
                                            textAlign = TextAlign.Center,
                                            color = MaterialTheme.colors.onPrimary
                                        )
                                        Spacer(modifier = Modifier.size(3.dp))
                                        Text(
                                            text = numeroAMoneda.format(viewModelNomina.antiguedadTotalMes),
                                            color = MaterialTheme.colors.onPrimary,
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}