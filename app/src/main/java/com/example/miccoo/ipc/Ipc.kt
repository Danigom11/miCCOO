package com.example.miccoo.ipc

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
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
import androidx.compose.ui.unit.dp
import com.example.miccoo.BarraSuperiorMiCCOO
import com.example.miccoo.nomina_completa.*
import com.example.miccoo.ui.theme.MiCCOOTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun Ipc(viewModelIpc: ViewModelIpc) {
    val visibleTitulo by rememberSaveable { mutableStateOf(true) }
    var visibleCategoriaProfesional by rememberSaveable { mutableStateOf(true) }
    var visibleAntiguedad by rememberSaveable { mutableStateOf(false) }
    var visibleResultado by rememberSaveable { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val densidad = LocalDensity.current

    MiCCOOTheme {
        Scaffold(
            backgroundColor = Color.Transparent,
            modifier = Modifier
                .padding(8.dp),
            topBar = {
                BarraSuperiorMiCCOO()
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .padding(start = 10.dp, end = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AnimarVisibilidad(visible = visibleTitulo, densidad = densidad) {
                        TextoTitulo(texto = "Calculemos los atrasos")
                        Spacer(modifier = Modifier.size(10.dp))
                    }

                    // Categoría profesional
                    AnimarVisibilidad(visible = visibleCategoriaProfesional, densidad = densidad) {
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
                                TextoConcepto(texto = "Elige una categoría profesional")
                                Spacer(modifier = Modifier.size(20.dp))
                                Desplegable(
                                    visible = true,
                                    expandible = viewModelIpc.expandirCategoriaProfesional,
                                    expandibleCambia = {
                                        viewModelIpc.cambiarExpandirCategoriaProfesional(
                                            it
                                        )
                                    },
                                    seleccionado = viewModelIpc.seleccionadoCategoriaProfesional,
                                    seleccionadoCambia = {
                                        viewModelIpc.seleccionadoCambiaCategoriaProfesional(
                                            it
                                        )
                                    },
                                    label = "Categoría profesional",
                                    opciones = opcionesCategoriaProfesional
                                )
                            }
                            AnimatedVisibility(visible = viewModelIpc.plusConvenio.isNotEmpty()) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Bottom
                                ) {
                                    Boton(
                                        destino = visibleCategoriaProfesional,
                                        destinoCambia = {
                                            visibleCategoriaProfesional =
                                                false; visibleAntiguedad = true
                                        },
                                        texto = "Siguiente",
                                        modifier = Modifier
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                    }

                    //Antigüedad
                    AnimarVisibilidad(visible = visibleAntiguedad, densidad = densidad) {
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
                                TextoConcepto(texto = "Antigüedad (+2 años)")
                                Switch(
                                    seleccionadoSwitch = viewModelIpc.seleccionadoSwitchAntiguedad,
                                    seleccionadoSwitchCambia = {
                                        viewModelIpc.seleccionadoSwitchCambiaAntiguedad(
                                            it
                                        )
                                    }
                                )
                                Desplegable(
                                    visible = viewModelIpc.seleccionadoSwitchAntiguedad,
                                    expandible = viewModelIpc.expandirAntiguedad,
                                    expandibleCambia = {
                                        viewModelIpc.cambiarExpandirAntiguedad(
                                            it
                                        )
                                    },
                                    seleccionado = viewModelIpc.seleccionadoAntiguedad,
                                    seleccionadoCambia = {
                                        viewModelIpc.seleccionadoCambiaAntiguedad(
                                            it
                                        )
                                    },
                                    label = "Antigüedad",
                                    opciones = opcionesAntiguedadNominaCompleta
                                )
                            }
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Boton(
                                    destino = visibleAntiguedad,
                                    destinoCambia = {
                                        visibleAntiguedad =
                                            false; visibleCategoriaProfesional = true
                                    },
                                    texto = "Anterior",
                                    modifier = Modifier
                                )
                                Spacer(modifier = Modifier.size(20.dp))
                                Boton(
                                    destino = visibleAntiguedad,
                                    destinoCambia = {
                                        visibleAntiguedad = false; visibleResultado = true
                                    },
                                    texto = "Siguiente",
                                    modifier = Modifier
                                )
                            }
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                    }
                    //Resultado
                    AnimarVisibilidad(visible = visibleResultado, densidad = densidad) {
                        Column {
                            TextoConcepto(texto = "Resultado")
                            ResultadoIpc(viewModelIpc = viewModelIpc)
                        }
                    }
                }
            }
        )
    }
}
