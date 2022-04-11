package com.midominio.miccoo.nomina_completa

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
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
import androidx.compose.ui.unit.sp
import com.midominio.miccoo.BarraSuperiorMiCCOO
import com.midominio.miccoo.ui.theme.MiCCOOTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun NominaCompleta(viewModelNominaCompleta: ViewModelNominaCompleta) {
    var visibleTitulo by rememberSaveable { mutableStateOf(true) }
    var visibleCategoriaProfesional by rememberSaveable { mutableStateOf(true) }
    var visibleAntiguedad by rememberSaveable { mutableStateOf(false) }
    var visibleHorasExtras by rememberSaveable { mutableStateOf(false) }
    var visibleNocturnidad by rememberSaveable { mutableStateOf(false) }
    var visibleIrpf by rememberSaveable { mutableStateOf(false) }
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
                        TextoTitulo(texto = "Calculemos una nómina")
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
                                    expandible = viewModelNominaCompleta.expandirCategoriaProfesional,
                                    expandibleCambia = {
                                        viewModelNominaCompleta.cambiarExpandirCategoriaProfesional(
                                            it
                                        )
                                    },
                                    seleccionado = viewModelNominaCompleta.seleccionadoCategoriaProfesional,
                                    seleccionadoCambia = {
                                        viewModelNominaCompleta.seleccionadoCambiaCategoriaProfesional(
                                            it
                                        )
                                    },
                                    label = "Categoría profesional",
                                    opciones = opcionesCategoriaProfesional
                                )
                            }
                            AnimatedVisibility(visible = viewModelNominaCompleta.plusConvenio.isNotEmpty()) {
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
                                    seleccionadoSwitch = viewModelNominaCompleta.seleccionadoSwitchAntiguedad,
                                    seleccionadoSwitchCambia = {
                                        viewModelNominaCompleta.seleccionadoSwitchCambiaAntiguedad(
                                            it
                                        )
                                    }
                                )
                                Desplegable(
                                    visible = viewModelNominaCompleta.seleccionadoSwitchAntiguedad,
                                    expandible = viewModelNominaCompleta.expandirAntiguedad,
                                    expandibleCambia = {
                                        viewModelNominaCompleta.cambiarExpandirAntiguedad(
                                            it
                                        )
                                    },
                                    seleccionado = viewModelNominaCompleta.seleccionadoAntiguedad,
                                    seleccionadoCambia = {
                                        viewModelNominaCompleta.seleccionadoCambiaAntiguedad(
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
                                        visibleAntiguedad = false; visibleHorasExtras = true
                                    },
                                    texto = "Siguiente",
                                    modifier = Modifier
                                )
                            }
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                    }


                    //Horas extras
                    AnimarVisibilidad(visible = visibleHorasExtras, densidad = densidad) {
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
                                TextoConcepto(texto = "¿Horas extras?")
                                Switch(
                                    seleccionadoSwitch = viewModelNominaCompleta.seleccionadoSwitchHorasExtras,
                                    seleccionadoSwitchCambia = {
                                        viewModelNominaCompleta.seleccionadoSwitchCambiaHorasExtras(
                                            it
                                        )
                                    })
                                CampoDeTexto(
                                    visible = viewModelNominaCompleta.seleccionadoSwitchHorasExtras,
                                    conceptoElegido = viewModelNominaCompleta.horasExtrasElegidas,
                                    conceptoElegidoCambia = {
                                        viewModelNominaCompleta.horasExtrasElegidasCambia(
                                            it
                                        )
                                    },
                                    textoLabel = "Número de horas extras"
                                )
                            }
                            Row {
                                Boton(
                                    destino = visibleHorasExtras,
                                    destinoCambia = {
                                        visibleHorasExtras = false; visibleAntiguedad = true
                                    },
                                    texto = "Anterior",
                                    modifier = Modifier
                                )
                                Spacer(modifier = Modifier.size(20.dp))
                                Boton(
                                    destino = visibleHorasExtras,
                                    destinoCambia = {
                                        visibleHorasExtras = false
                                        visibleNocturnidad = true
                                    },
                                    texto = "Siguiente",
                                    modifier = Modifier
                                )
                            }
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                    }


                    //Nocturnidad
                    AnimarVisibilidad(visible = visibleNocturnidad, densidad = densidad) {
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
                                TextoConcepto(texto = "¿Nocturnidad? (de 22:00 a 06:00)")
                                Switch(
                                    seleccionadoSwitch = viewModelNominaCompleta.seleccionadoSwitchNocturnidad,
                                    seleccionadoSwitchCambia = {
                                        viewModelNominaCompleta.seleccionadoSwitchCambiaNocturnidad(
                                            it
                                        )
                                    }
                                )
                                Spacer(modifier = Modifier.size(20.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),
                                ) {
                                    Text(
                                        text = "* Cálculo para el mes completo",
                                        modifier = Modifier.align(Alignment.Center),
                                        color = MaterialTheme.colors.onPrimary,
                                        fontStyle = FontStyle.Italic,
                                        fontSize = 18.sp,
                                    )
                                }
                            }
                            Row {
                                Boton(
                                    destino = visibleNocturnidad,
                                    destinoCambia = {
                                        visibleNocturnidad = false; visibleHorasExtras =
                                        true
                                    },
                                    texto = "Anterior",
                                    modifier = Modifier
                                )
                                Spacer(modifier = Modifier.size(20.dp))
                                Boton(
                                    destino = visibleNocturnidad,
                                    destinoCambia = {
                                        visibleNocturnidad = false; visibleIrpf = true
                                    },
                                    texto = "Siguiente",
                                    modifier = Modifier
                                )
                            }
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                    }

                    //IRPF
                    AnimarVisibilidad(visible = visibleIrpf, densidad = densidad) {
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
                                TextoConcepto(texto = "IRPF")
                                CampoDeTexto(
                                    visible = true,
                                    conceptoElegido = viewModelNominaCompleta.irpfElegida,
                                    conceptoElegidoCambia = {
                                        viewModelNominaCompleta.irpfElegidaCambia(
                                            it
                                        )
                                    },
                                    textoLabel = "IRPF"
                                )
                            }
                            Row {
                                Boton(
                                    destino = visibleIrpf,
                                    destinoCambia = {
                                        visibleIrpf = false; visibleNocturnidad = true
                                    },
                                    texto = "Anterior",
                                    modifier = Modifier
                                )
                                Spacer(modifier = Modifier.size(20.dp))
                                Boton(
                                    destino = visibleIrpf,
                                    destinoCambia = {
                                        visibleIrpf = false; visibleTitulo =
                                        false; visibleResultado = true
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
                        Column {
                            TextoConcepto(texto = "Resultado")
                            ResultadoNominaCompleta(viewModelNominaCompleta = viewModelNominaCompleta)
                        }
                    }
                }
            }
        )
    }
}