package com.example.miccoo.nomina_datos_generales

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.miccoo.BarraSuperiorMiCCOO
import com.example.miccoo.nomina_datos_generales.conceptos_fijos.ScreenConceptosFijos
import com.example.miccoo.nomina_datos_generales.conceptos_otros.ScreenConceptosOtros
import com.example.miccoo.nomina_datos_generales.seleccion_antiguedad.SeleccionAntiguedad
import com.example.miccoo.nomina_datos_generales.seleccion_categoria_profesional.SeleccionCategoriaProfesional
import com.example.miccoo.ui.theme.MiCCOOTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun Nomina(viewModelNomina: ViewModelNomina, navController: NavController) {
    var visible by rememberSaveable { mutableStateOf(false) }
    val density = LocalDensity.current
    MiCCOOTheme {
        Scaffold(
            backgroundColor = Color.Transparent,
            modifier = Modifier
                .padding(8.dp),
            topBar = {
                BarraSuperiorMiCCOO()
            },
            content = {
                Column {
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
                            SeleccionCategoriaProfesional(viewModelNomina = viewModelNomina)
                            SeleccionAntiguedad(viewModelNomina = viewModelNomina)
                        }
                    }
                    BotonCalcular(
                        viewModelNomina = viewModelNomina,
                        visible = !visible,
                        visibleCambia = { visible = !visible }
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
                        /*enter = scaleIn(animationSpec = tween(durationMillis = 3000)),
                        exit = scaleOut(animationSpec = tween(durationMillis = 3000))*/

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

@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun BotonCalcular(
    viewModelNomina: ViewModelNomina,
    visible: Boolean,
    visibleCambia: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp), contentAlignment = Alignment.BottomCenter
    ) {
        OutlinedButton(
            onClick = {
                visibleCambia(!visible)

                if (viewModelNomina.seleccionado.value == "Mozo ordinario, limpiador, repartidor" || viewModelNomina.seleccionado.value.isNullOrEmpty()) {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "163.77"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
                if (viewModelNomina.seleccionado.value == "Mozo especialista, ayudante") {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "177.75"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
                if (viewModelNomina.seleccionado.value == "Engradador lavador") {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "184.17"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
                if (viewModelNomina.seleccionado.value == "Conductor 2ª, Oficial taller") {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "195.69"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
                if (viewModelNomina.seleccionado.value == "Conductor 1ª, Oficial Taller") {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "216.39"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
                if (viewModelNomina.seleccionado.value == "Vigilante") {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "167.96"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
                if (viewModelNomina.seleccionado.value == "Jefe Almacén") {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "213.32"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
                if (viewModelNomina.seleccionado.value == "Conductor, Mecánico, Jefe Taller") {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "216.39"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
                if (viewModelNomina.seleccionado.value == "Auxiliar") {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "165.50"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
                if (viewModelNomina.seleccionado.value == "Oficial 2ª Administración") {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "209.12"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
                if (viewModelNomina.seleccionado.value == "Oficial 1ª Administración") {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "218.18"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
                if (viewModelNomina.seleccionado.value == "Jefe administración, capataz") {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "251.57"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
                if (viewModelNomina.seleccionado.value == "Inspector principal") {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "327.90"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
                if (viewModelNomina.seleccionado.value == "Encargado almacén, jefe de servicio") {
                    viewModelNomina.salarioBase =
                        ("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()).toString()
                    viewModelNomina.plusConvenio = "408.54"
                    viewModelNomina.plusTransporte = "162.51"
                    viewModelNomina.retribucionConvenio =
                        (("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) + viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()).toString()
                    viewModelNomina.retribucionAnual =
                        ((("1008.98".toDouble() * viewModelNomina.antiguedadSuma.toDouble()) * 15) + (viewModelNomina.plusConvenio.toDouble() + viewModelNomina.plusTransporte.toDouble()) * 12).toString()
                    viewModelNomina.totalHorasAno = "1800"
                }
            },
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(width = 1.dp, color = Color.Red)
        ) {
            Text(
                text = if (visible) {
                    "Calcular"
                } else {
                    "Cambiar"
                }, color = MaterialTheme.colors.onPrimary, fontSize = 20.sp
            )
        }
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