package com.midominio.miccoo.nomina_conceptos

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.midominio.miccoo.BarraSuperior
import com.midominio.miccoo.ViewModelNomina
import com.midominio.miccoo.nomina_calculadora.*
import com.midominio.miccoo.nomina_conceptos.conceptos_fijos.ScreenConceptosFijos
import com.midominio.miccoo.nomina_conceptos.conceptos_otros.ScreenConceptosOtros
import com.midominio.miccoo.opcionesAntiguedad
import com.midominio.miccoo.opcionesCategoriaProfesional
import com.midominio.miccoo.ui.theme.MiCCOOTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun Nomina(viewModelNomina: ViewModelNomina, navController: NavController) {
    var visible by rememberSaveable { mutableStateOf(false) }
    val densidad = LocalDensity.current
    var visiblePreguntas by rememberSaveable { mutableStateOf(true) }
    val density = LocalDensity.current
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
                        .padding(start = 10.dp, end = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextoTitulo(texto = "Conceptos de una nómina")
                    Spacer(modifier = Modifier.size(10.dp))


                    // Categoría profesional
                    AnimarVisibilidad(visible = visiblePreguntas, densidad = densidad) {
                        Column(
                            modifier = Modifier
                                .height(300.dp)
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
                            Column(modifier = Modifier.weight(1f)) {
                                TextoConcepto(texto = "Solo dos preguntas")
                                Spacer(modifier = Modifier.size(20.dp))
                                Desplegable(
                                    visible = true,
                                    expandible = viewModelNomina.expandirCategoriaProfesional,
                                    expandibleCambia = {
                                        viewModelNomina.cambiarExpandirCategoriaProfesional(
                                            it
                                        )
                                    },
                                    seleccionado = viewModelNomina.seleccionadoCategoriaProfesional,
                                    seleccionadoCambia = {
                                        viewModelNomina.seleccionadoCambiaCategoriaProfesional(
                                            it
                                        )
                                    },
                                    label = "Categoría profesional",
                                    opciones = opcionesCategoriaProfesional
                                )
                                Spacer(modifier = Modifier.size(20.dp))
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
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Spacer(modifier = Modifier.size(10.dp))
                        Boton(
                            destino = !visible,
                            destinoCambia = {
                                visible = !visible; visiblePreguntas = !visiblePreguntas
                            },
                            texto = "Calcular",
                            modifier = Modifier
                        )
                    }
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
                        LazyColumn {
                            item {
                                TextoDivisorConceptos(
                                    texto = "Conceptos fijos",
                                    textoDos = "(Antigüedad incluida)"
                                )
                                ScreenConceptosFijos(viewModelNomina = viewModelNomina)
                                TextoDivisorConceptos(
                                    texto = "Otros conceptos",
                                    textoDos = "(Haz click para descubrir más)"
                                )
                                ScreenConceptosOtros(
                                    navController = navController,
                                    viewModelNomina = viewModelNomina
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun TextoDivisorConceptos(texto: String, textoDos: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = texto, color = MaterialTheme.colors.onPrimary)
            Text(
                text = textoDos,
                color = MaterialTheme.colors.onPrimary,
                fontStyle = FontStyle.Italic
            )
        }
    }
    Divider(
        color = Color.LightGray,
        modifier = Modifier.padding(
            start = 90.dp,
            end = 90.dp,
            top = 6.dp,
            bottom = 6.dp
        )
    )
}