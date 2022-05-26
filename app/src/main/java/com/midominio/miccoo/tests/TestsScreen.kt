package com.midominio.miccoo.tests

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.midominio.miccoo.nomina_calculadora.TextoConcepto

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun Tests(viewModelTests: ViewModelTests) {
    Column(
        modifier = Modifier
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
            TextoConcepto(texto = "PONTE A PRUEBA!")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp)
            ) {
                //todo poner aquí el grupo de botones
                Text(text = "Experimento")

            }

            Row {
                Button(onClick = {
                }) {

                }
            }
            Spacer(modifier = Modifier.size(20.dp))

        }

    }
}