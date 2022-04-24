package com.midominio.miccoo.nomina_conceptos.conceptos_otros

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import com.midominio.miccoo._pagina_principal.Screens

@Composable
fun TarjetaModeloConceptosOtros(
    navController: NavController,
    colorBorde: Color,
    conceptoOtro: String,
    resultado: String,
    click: String
) {
    Column {
        Card(
            elevation = 4.dp,
            border = BorderStroke(1.dp, colorBorde),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(3.dp)
                .size(120.dp)
                .clickable {
                    navController.navigate(click) {
                        popUpTo(Screens.NOMINA.ruta)
                    }
                }
        ) {
            Column(
                modifier = Modifier
                    .padding(4.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = conceptoOtro,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(3.dp))
                Text(
                    text = resultado,
                    fontSize = 20.sp
                )
            }
        }
    }
}