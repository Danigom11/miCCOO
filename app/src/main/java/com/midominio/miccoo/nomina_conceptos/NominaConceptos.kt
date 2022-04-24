package com.midominio.miccoo.nomina_conceptos

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.navigation.NavController
import com.midominio.miccoo.BarraSuperior
import com.midominio.miccoo.ViewModelNomina
import com.midominio.miccoo.nomina_calculadora.Boton
import com.midominio.miccoo.nomina_calculadora.Desplegable
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