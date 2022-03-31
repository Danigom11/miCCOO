package com.example.miccoo.nomina_datos_generales.conceptos_fijos

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TarjetaModeloConceptosFijosNomina(
    colorBorde: Color,
    conceptoFijo: String,
    resultado: String
) {
    Column {
        Card(
            elevation = 4.dp,
            border = BorderStroke(3.dp, colorBorde),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(6.dp)
                .size(100.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(4.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = conceptoFijo,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(3.dp))
                Text(
                    text = resultado,
                    fontSize = 16.sp
                )
            }
        }
    }
}