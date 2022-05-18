package com.midominio.miccoo.atrasosYSubida

import android.annotation.SuppressLint
import android.icu.text.NumberFormat
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.midominio.miccoo.ViewModelNomina

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ResultadoIpc(viewModelNomina: ViewModelNomina) {
    val numeroAMoneda = NumberFormat.getCurrencyInstance()
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = "Categoría profesional:",
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.Start
        )
        Text(
            text = viewModelNomina.seleccionadoCategoriaProfesional,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.size(size = 20.dp))
        if (viewModelNomina.seleccionadoSwitchAntiguedad) {
            Text(
                text = "Antigüedad:",
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Start
            )
            Text(
                text = viewModelNomina.seleccionadoAntiguedad,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Start
            )
        }
        Spacer(modifier = Modifier.size(size = 20.dp))
        Text(
            text = "Porcentaje de subida:",
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.Start
        )
        Text(
            text = "${viewModelNomina.porcentajeSubida} %",
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.size(size = 20.dp))
        Text(
            text = "Meses de atrasos:",
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.Start
        )
        Text(
            text = viewModelNomina.mesesElegidos,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.size(size = 20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TarjetaModeloAtrasosYSubida(
                colorBorde = Color.Red,
                concepto = "Atrasos",
                resultado = numeroAMoneda.format(viewModelNomina.atrasos),
            )
            Spacer(modifier = Modifier.size(size = 20.dp))
            TarjetaModeloAtrasosYSubida(
                colorBorde = Color.Green,
                concepto = "Subida al mes",
                resultado = numeroAMoneda.format(viewModelNomina.subidaMes),
            )
        }
        Text(
            text = "- Falta: horas extras, nocturnidad, bajas...",
            color = MaterialTheme.colors.onPrimary,
        )
        Text(
            text = "- Resultado en bruto",
            color = MaterialTheme.colors.onPrimary
        )
    }
}


@Composable
fun TarjetaModeloAtrasosYSubida(
    colorBorde: Color,
    concepto: String,
    resultado: String
) {
    Column {
        Card(
            elevation = 4.dp,
            border = BorderStroke(1.dp, colorBorde),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(3.dp)
                .size(120.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(4.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = concepto,
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