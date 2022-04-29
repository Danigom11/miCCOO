package com.midominio.miccoo.atrasosYSubida

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.midominio.miccoo.*
import com.midominio.miccoo.nomina_calculadora.*
import com.midominio.miccoo.ui.theme.MiCCOOTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun AtrasosYSubida(viewModelNomina: ViewModelNomina) {
    val visibleTitulo by rememberSaveable { mutableStateOf(true) }
    var visibleTablasSalariales by rememberSaveable { mutableStateOf(true) }
    var visibleCategoriaProfesional by rememberSaveable { mutableStateOf(false) }
    var visibleAntiguedad by rememberSaveable { mutableStateOf(false) }
    var visiblePorcentajeSubida by rememberSaveable { mutableStateOf(false) }
    var visibleMeses by rememberSaveable { mutableStateOf(false) }
    var visibleResultado by rememberSaveable { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val densidad = LocalDensity.current

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
                    AnimarVisibilidad(visible = visibleTitulo, densidad = densidad) {
                        TextoTitulo(texto = "Calculemos los atrasos")
                        Spacer(modifier = Modifier.size(10.dp))
                    }
                    // Tablas salariales
                    AnimarVisibilidad(visible = visibleTablasSalariales, densidad = densidad) {
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
                                TextoConcepto(texto = "Selecciona una tabla salarial")
                                Spacer(modifier = Modifier.size(20.dp))
                                Desplegable(
                                    visible = true,
                                    expandible = viewModelNomina.expandirTablasSalariales,
                                    expandibleCambia = {
                                        viewModelNomina.cambiarExpandirTablasSalariales(
                                            it
                                        )
                                    },
                                    seleccionado = viewModelNomina.seleccionadoTablasSalariales,
                                    seleccionadoCambia = {
                                        viewModelNomina.seleccionadoCambiaTablasSalariales(
                                            it
                                        )
                                    },
                                    label = "Tablas salariales",
                                    opciones = opcionesTablasSalariales
                                )
                            }
                            AnimatedVisibility(visible = viewModelNomina.seleccionadoTablasSalariales.isNotEmpty()) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Bottom
                                ) {
                                    Boton(
                                        destino = visibleTablasSalariales,
                                        destinoCambia = {
                                            visibleTablasSalariales =
                                                false; visibleCategoriaProfesional = true
                                        },
                                        texto = "Siguiente",
                                        modifier = Modifier
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.size(20.dp))
                        }
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
                            }
                            AnimatedVisibility(visible = viewModelNomina.seleccionadoCategoriaProfesional.isNotEmpty()) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Bottom
                                ) {
                                    Row(
                                        Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Boton(
                                            destino = visibleAntiguedad,
                                            destinoCambia = {
                                                visibleCategoriaProfesional =
                                                    false; visibleTablasSalariales = true
                                            },
                                            texto = "Anterior",
                                            modifier = Modifier
                                        )
                                        Spacer(modifier = Modifier.size(20.dp))
                                        Boton(
                                            destino = visibleCategoriaProfesional,
                                            destinoCambia = {
                                                viewModelNomina.seleccionadoCambiaTablasSalariales(
                                                    viewModelNomina.tablasSalariales
                                                )
                                                viewModelNomina.seleccionadoCambiaCategoriaProfesional(
                                                    viewModelNomina.seleccionadoCategoriaProfesional
                                                )
                                                visibleCategoriaProfesional = false
                                                visibleAntiguedad = true

                                            },
                                            texto = "Siguiente",
                                            modifier = Modifier
                                        )
                                    }

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
                                    seleccionadoSwitch = viewModelNomina.seleccionadoSwitchAntiguedad,
                                    seleccionadoSwitchCambia = {
                                        viewModelNomina.seleccionadoSwitchCambiaAntiguedad(
                                            it
                                        )
                                    }
                                )
                                Desplegable(
                                    visible = viewModelNomina.seleccionadoSwitchAntiguedad,
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
                                        visibleAntiguedad = false; visiblePorcentajeSubida = true
                                    },
                                    texto = "Siguiente",
                                    modifier = Modifier
                                )
                            }
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                    }

                    // Porcentaje subida
                    AnimarVisibilidad(visible = visiblePorcentajeSubida, densidad = densidad) {
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
                                TextoConcepto(texto = "Porcentaje de subida")
                                Spacer(modifier = Modifier.size(20.dp))
                                CampoDeTextoIrpf(
                                    visible = true,
                                    conceptoElegido = viewModelNomina.porcentajeSubida,
                                    conceptoElegidoCambia = {
                                        viewModelNomina.porcentajeSubidaCambia(
                                            it
                                        )
                                    },
                                    textoLabel = "Porcentaje"
                                )
                            }
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Boton(
                                    destino = visibleAntiguedad,
                                    destinoCambia = {
                                        visiblePorcentajeSubida =
                                            false; visibleAntiguedad = true
                                    },
                                    texto = "Anterior",
                                    modifier = Modifier
                                )
                                Spacer(modifier = Modifier.size(20.dp))
                                Boton(
                                    destino = visibleAntiguedad,
                                    destinoCambia = {
                                        visiblePorcentajeSubida = false; visibleMeses = true
                                    },
                                    texto = "Siguiente",
                                    modifier = Modifier
                                )
                            }
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                    }

                    // Meses elegidos
                    AnimarVisibilidad(visible = visibleMeses, densidad = densidad) {
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
                                TextoConcepto(texto = "¿Cuántos meses de atrasos?")
                                Spacer(modifier = Modifier.size(20.dp))
                                CampoDeTextoIrpf(
                                    visible = true,
                                    conceptoElegido = viewModelNomina.mesesElegidos,
                                    conceptoElegidoCambia = {
                                        viewModelNomina.mesesElegidosCambia(
                                            it
                                        )
                                    },
                                    textoLabel = "Meses"
                                )

                            }
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Boton(
                                    destino = visibleAntiguedad,
                                    destinoCambia = {
                                        visibleMeses =
                                            false; visiblePorcentajeSubida = true
                                    },
                                    texto = "Anterior",
                                    modifier = Modifier
                                )
                                Spacer(modifier = Modifier.size(20.dp))
                                Boton(
                                    destino = visibleAntiguedad,
                                    destinoCambia = {
                                        visibleMeses = false; visibleResultado = true
                                    },
                                    texto = "Calcular",
                                    modifier = Modifier
                                )
                            }
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                    }


                    //Resultado
                    AnimarVisibilidad(visible = visibleResultado, densidad = densidad) {
                        Column(
                            modifier = Modifier
                                .height(520.dp)
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
                                Spacer(modifier = Modifier.size(20.dp))
                                TextoConcepto(texto = "Resultado")
                                ResultadoIpc(viewModelNomina = viewModelNomina)
                            }
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun CampoDeTextoIrpf(
    visible: Boolean,
    conceptoElegido: String,
    conceptoElegidoCambia: (String) -> Unit,
    textoLabel: String
) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(visible = visible) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                TextField(
                    value = conceptoElegido,
                    onValueChange = { conceptoElegidoCambia(it) },
                    modifier = Modifier.border(
                        BorderStroke(
                            width = 4.dp,
                            brush = Brush.horizontalGradient(listOf(Color.Red, Color.Green))
                        ),
                        shape = RoundedCornerShape(50)
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    label = {
                        Text(
                            text = textoLabel,
                            color = MaterialTheme.colors.onPrimary
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
            }
        }
    }
}

