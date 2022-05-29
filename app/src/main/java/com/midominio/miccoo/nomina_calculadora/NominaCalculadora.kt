package com.midominio.miccoo.nomina_calculadora

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
import com.midominio.miccoo.*
import com.midominio.miccoo.ui.theme.MiCCOOTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun NominaCompleta(viewModelNomina: ViewModelNomina) {
    var visibleTitulo by rememberSaveable { mutableStateOf(true) }
    var visibleHorasAnuales by rememberSaveable { mutableStateOf(true) }
    var visibleTextoError by rememberSaveable { mutableStateOf(false) }
    var visibleTablasSalariales by rememberSaveable { mutableStateOf(false) }
    var visibleCategoriaProfesional by rememberSaveable { mutableStateOf(false) }
    var visibleAntiguedad by rememberSaveable { mutableStateOf(false) }
    var visibleHorasExtras by rememberSaveable { mutableStateOf(false) }
    var visibleNocturnidad by rememberSaveable { mutableStateOf(false) }
    var visibleNocturnidadHorasDia by rememberSaveable { mutableStateOf(false) }
    var visibleNocturnidadHorasMes by rememberSaveable { mutableStateOf(false) }
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
                        TextoTitulo(texto = "Calculemos una nómina")
                        Spacer(modifier = Modifier.size(10.dp))
                    }

                    // Horas anuales
                    AnimarVisibilidad(visible = visibleHorasAnuales, densidad = densidad) {
                        Column(
                            modifier = Modifier
                                .height(alturaCuadros)
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
                                TextoConcepto(texto = "¿Trabajas a jornada completa?")
                                TextoConceptoSecundario(texto = "(40 horas por semana, 1800 horas año)")
                                Spacer(modifier = Modifier.size(20.dp))
                                Switch(
                                    seleccionadoSwitch = !viewModelNomina.seleccionadoSwitchJornadaCompleta,
                                    seleccionadoSwitchCambia = {
                                        viewModelNomina.seleccionadoSwitchCambiaJornadaCompleta(
                                            !it
                                        )
                                        if (!viewModelNomina.seleccionadoSwitchJornadaCompleta) {
                                            viewModelNomina.horasAnualesElegidas = "1800"
                                        }
                                    })
                                CampoDeTexto(
                                    visible = viewModelNomina.seleccionadoSwitchJornadaCompleta,
                                    conceptoElegido = viewModelNomina.horasAnualesElegidas,
                                    conceptoElegidoCambia = {
                                        viewModelNomina.horasAnualesElegidasCambia(
                                            it
                                        )
                                    },
                                    textoLabel = "Número total de horas al año"
                                )
                            }
                            Row {
                                Boton(
                                    destino = visibleHorasAnuales,
                                    destinoCambia = {
                                        if (viewModelNomina.horasAnualesElegidas <= "1800") {
                                            visibleTextoError = false
                                            visibleHorasAnuales = false
                                            visibleTablasSalariales = true
                                        } else {
                                            visibleTextoError = true
                                        }
                                    },
                                    texto = "Siguiente",
                                    modifier = Modifier
                                )
                            }
                            AnimatedVisibility(visible = visibleTextoError) {
                                TextoConceptoSecundario(texto = "El máximo posible de horas al año para un contrato a jornada completa es de 1800")
                            }
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                    }

                    // Tablas salariales
                    AnimarVisibilidad(visible = visibleTablasSalariales, densidad = densidad) {
                        Column(
                            modifier = Modifier
                                .height(alturaCuadros)
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
                                    Row(
                                        Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Boton(
                                            destino = visibleHorasAnuales,
                                            destinoCambia = {
                                                visibleTablasSalariales =
                                                    false; visibleHorasAnuales = true
                                            },
                                            texto = "Anterior",
                                            modifier = Modifier
                                        )
                                        Spacer(modifier = Modifier.size(20.dp))
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
                            }
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                    }

                    // Categoría profesional
                    AnimarVisibilidad(visible = visibleCategoriaProfesional, densidad = densidad) {
                        Column(
                            modifier = Modifier
                                .height(alturaCuadros)
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
                                                viewModelNomina.horasAnualesElegidasCambia(
                                                    viewModelNomina.horasAnualesElegidas
                                                )
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
                                .height(alturaCuadros)
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
                                AnimatedVisibility(visible = viewModelNomina.seleccionadoSwitchAntiguedad) {
                                    Column {
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
                                }
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
                                .height(alturaCuadros)
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
                                    seleccionadoSwitch = viewModelNomina.seleccionadoSwitchHorasExtras,
                                    seleccionadoSwitchCambia = {
                                        viewModelNomina.seleccionadoSwitchCambiaHorasExtras(
                                            it
                                        )
                                    })
                                CampoDeTexto(
                                    visible = viewModelNomina.seleccionadoSwitchHorasExtras,
                                    conceptoElegido = viewModelNomina.horasExtrasElegidas,
                                    conceptoElegidoCambia = {
                                        viewModelNomina.horasExtrasElegidasCambia(
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
                                .height(alturaCuadros)
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
                                    seleccionadoSwitch = viewModelNomina.seleccionadoSwitchNocturnidad,
                                    seleccionadoSwitchCambia = {
                                        viewModelNomina.seleccionadoSwitchCambiaNocturnidad(
                                            it
                                        )
                                    }
                                )
                                AnimarVisibilidad(
                                    visible = viewModelNomina.seleccionadoSwitchNocturnidad,
                                    densidad = densidad
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 40.dp)
                                    ) {
                                        RadioGrupoBotones(
                                            modifier = Modifier
                                                .padding(16.dp)
                                                .fillMaxWidth(),
                                            items = opcionesNocturnidad,
                                            seleccion = viewModelNomina.nocturnidadElegidaEtiqueta.value
                                        ) { clickedItem ->
                                            viewModelNomina.nocturnidadElegidaEtiqueta.value =
                                                clickedItem
                                            if (viewModelNomina.nocturnidadElegidaEtiqueta.value == opcionesNocturnidad[0]) {
                                                visibleNocturnidadHorasMes = false
                                                visibleNocturnidadHorasDia = false
                                            }
                                            if (viewModelNomina.nocturnidadElegidaEtiqueta.value == opcionesNocturnidad[1]) {
                                                visibleNocturnidadHorasMes = false
                                                visibleNocturnidadHorasDia = true
                                            }
                                            if (viewModelNomina.nocturnidadElegidaEtiqueta.value == opcionesNocturnidad[2]) {
                                                visibleNocturnidadHorasDia = false
                                                visibleNocturnidadHorasMes = true
                                            }

                                        }
                                    }
                                    // Nocturnidad mes incompleto
                                    AnimarVisibilidad(
                                        visible = visibleNocturnidadHorasDia,
                                        densidad = densidad
                                    ) {
                                        CampoDeTexto(
                                            visible = visibleNocturnidadHorasDia,
                                            conceptoElegido = viewModelNomina.horasNocturnidadSemanalesElegidas,
                                            conceptoElegidoCambia = {
                                                viewModelNomina.horasNocturnidadSemanalesElegidasCambia(
                                                    it
                                                )
                                            },
                                            textoLabel = "Horas todos los días con nocturnidad"
                                        )
                                    }
                                    // Nocturnidad horas sueltas
                                    AnimarVisibilidad(
                                        visible = visibleNocturnidadHorasMes,
                                        densidad = densidad
                                    ) {
                                        CampoDeTexto(
                                            visible = visibleNocturnidadHorasMes,
                                            conceptoElegido = viewModelNomina.horasNocturnidadMesElegidas,
                                            conceptoElegidoCambia = {
                                                viewModelNomina.horasNocturnidadMesElegidasCambia(
                                                    it
                                                )
                                            },
                                            textoLabel = "Horas en un mes con nocturnidad"
                                        )
                                    }

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
                                        if (viewModelNomina.nocturnidadElegidaEtiqueta.value == opcionesNocturnidad[0]) {
                                            viewModelNomina.nocturnidadDefinitiva =
                                                viewModelNomina.nocturnidadMesCompleto.toString()
                                        }
                                        if (viewModelNomina.nocturnidadElegidaEtiqueta.value == opcionesNocturnidad[1]) {
                                            viewModelNomina.nocturnidadDefinitiva =
                                                viewModelNomina.nocturnidadMesIncompletoHorasTodosDias.toString()
                                        }
                                        if (viewModelNomina.nocturnidadElegidaEtiqueta.value == opcionesNocturnidad[2]) {
                                            viewModelNomina.nocturnidadDefinitiva =
                                                viewModelNomina.nocturnidadPorHora.toString()
                                        }
                                        if (!viewModelNomina.seleccionadoSwitchNocturnidad) {
                                            viewModelNomina.nocturnidadDefinitiva = 0.toString()
                                        }

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
                                .height(alturaCuadros)
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
                                    conceptoElegido = viewModelNomina.irpfElegida,
                                    conceptoElegidoCambia = {
                                        viewModelNomina.irpfElegidaCambia(
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
                            ResultadoNominaCompleta(viewModelNomina = viewModelNomina)
                        }
                    }
                }
            }
        )
    }
}
