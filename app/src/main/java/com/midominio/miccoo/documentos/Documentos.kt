package com.midominio.miccoo.documentos

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.midominio.miccoo.BarraSuperior
import com.midominio.miccoo.ui.theme.MiCCOOTheme

@ExperimentalAnimationApi
@Composable
fun Documentos() {
    MiCCOOTheme {
        Scaffold(
            backgroundColor = Color.Transparent,
            modifier = Modifier
                .padding(8.dp),
            topBar = {
                BarraSuperior()
            },
            content = {
                SelectionContainer {
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
            }
        )
    }
}