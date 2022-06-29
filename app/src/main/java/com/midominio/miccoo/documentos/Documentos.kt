package com.midominio.miccoo.documentos

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
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
import androidx.compose.ui.unit.dp
import com.midominio.miccoo.BarraSuperior
import com.midominio.miccoo.nomina_calculadora.AnimarVisibilidad
import com.midominio.miccoo.nomina_calculadora.Boton
import com.midominio.miccoo.nomina_calculadora.TextoTitulo
import com.midominio.miccoo.ui.theme.MiCCOOTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun Documentos() {
    val densidad = LocalDensity.current
    var visibleListaDocumentos by rememberSaveable { mutableStateOf(true) }
    var visibleSolicitudCambioJornada by rememberSaveable { mutableStateOf(false) }

    MiCCOOTheme {
        Scaffold(
            backgroundColor = Color.Transparent,
            modifier = Modifier
                .padding(8.dp),
            topBar = {
                BarraSuperior()
            },
            content = {
                AnimarVisibilidad(visible = visibleListaDocumentos, densidad = densidad) {
                    Column {
                        TextoTitulo(texto = "Documentos")
                        Column(Modifier.padding(start = 10.dp)) {
                            Spacer(modifier = Modifier.size(20.dp))
                            BotonDocumentos(
                                visibleListaDocumentos = visibleListaDocumentos,
                                visibleCambia = {
                                    visibleListaDocumentos = false
                                    visibleSolicitudCambioJornada = true
                                },
                                texto = "Solicitud de cambio de jornada"
                            )
                        }
                    }
                }
                AnimarVisibilidad(visible = visibleSolicitudCambioJornada, densidad = densidad) {
                    Column {
                        SelectionContainer(Modifier.padding(8.dp)) {
                            Text(
                                text = "\n\nA LA ATENCIÓN DE RRHH \n\n\n" +
                                        "En ____________ a _____________ de ____________ de 20___ \n\n" +
                                        "Don/Doña___________________________________________________, DNI______________, por medio de la presente solicito formalmente el cambio de horario laboral debido a razones personales. \n\n" +
                                        "La jornada que solicito es de \n" +
                                        "_____________________________________________________________.\n\n" +
                                        "Rogándole acuse recibo del presente documento, reciba un cordial saludo. \n\n" +
                                        "LA EMPRESA \t\t\t\t\t\tEL/LA TRABAJADOR/A\n",
                                color = MaterialTheme.colors.onPrimary
                            )
                        }
                        Column(
                            Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Spacer(modifier = Modifier.size(40.dp))
                            Boton(
                                destino = visibleSolicitudCambioJornada,
                                destinoCambia = {
                                    visibleSolicitudCambioJornada = false
                                    visibleListaDocumentos = true
                                },
                                texto = "Volver",
                                modifier = Modifier
                            )
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun BotonDocumentos(
    visibleListaDocumentos: Boolean,
    visibleCambia: (Boolean) -> Unit,
    texto: String,
) {
    OutlinedButton(
        border = BorderStroke(1.dp, Color.Red),
        onClick = {
            visibleCambia(!visibleListaDocumentos)
        },
    ) {
        Text(texto)
    }

}