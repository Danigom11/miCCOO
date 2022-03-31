package com.example.miccoo.ipc

import android.annotation.SuppressLint
import android.icu.text.NumberFormat
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ResultadoIpc(viewModelIpc: ViewModelIpc) {
    val numeroAMoneda = NumberFormat.getCurrencyInstance()
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Categoría profesional:",
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Start
            )
            Text(
                text = viewModelIpc.seleccionadoCategoriaProfesional,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.size(size = 20.dp))
            if (viewModelIpc.seleccionadoSwitchAntiguedad) {
                Text(
                    text = "Antigüedad:",
                    color = MaterialTheme.colors.onPrimary,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = viewModelIpc.seleccionadoAntiguedad,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colors.onPrimary,
                    textAlign = TextAlign.Start
                )
            }
            Spacer(modifier = Modifier.size(size = 20.dp))
        }

        Column(
            modifier = Modifier
                .border(1.dp, color = Color.Green)
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Salario base:",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = numeroAMoneda.format(viewModelIpc.salarioBase.toDouble()),
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Plus convenio:",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = numeroAMoneda.format(viewModelIpc.plusConvenio.toDouble()),
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Plus transporte:",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = numeroAMoneda.format(viewModelIpc.plusTransporte.toDouble()),
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Pagas extras prorrateadas:",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = numeroAMoneda.format(viewModelIpc.pagasExtrasProrrateadasMasAntiguedad),
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            if (viewModelIpc.seleccionadoSwitchAntiguedad) {
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Antigüedad:",
                        modifier = Modifier.align(Alignment.CenterStart),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = numeroAMoneda.format(viewModelIpc.antiguedadConcepto),
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.CenterEnd),
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
            if (viewModelIpc.seleccionadoSwitchHorasExtras) {
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Horas extras: ${viewModelIpc.horasExtrasElegidas}",
                        modifier = Modifier.align(Alignment.CenterStart),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = numeroAMoneda.format(viewModelIpc.horasExtrasElegidasTotal),
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.CenterEnd),
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
            if (viewModelIpc.seleccionadoSwitchNocturnidad) {
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Nocturnidad:",
                        modifier = Modifier.align(Alignment.CenterStart),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = numeroAMoneda.format(viewModelIpc.nocturnidad),
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.CenterEnd),
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Seguro de accidentes colectivo:",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = numeroAMoneda.format(viewModelIpc.seguroAccidentesColectivo),
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Total ingresos:",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = numeroAMoneda.format(viewModelIpc.totalIngresos),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .border(1.dp, color = Color.Red)
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "IRPF: ${viewModelIpc.irpfElegida} %",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = numeroAMoneda.format(viewModelIpc.totalDescuentoIrpf),
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Cotización cont. comunes: 4,70 %",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = numeroAMoneda.format(viewModelIpc.totalDescuentoCotizacionContComunes),
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Cotización formación: 1,65 %",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = numeroAMoneda.format(viewModelIpc.totalDescuentoCotizacionFormacion),
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Total descuentos:",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = numeroAMoneda.format(viewModelIpc.totalDescuentos),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            Modifier
                .fillMaxWidth()
                .padding(10.dp), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Total:",
                modifier = Modifier.align(Alignment.CenterStart),
                color = MaterialTheme.colors.onPrimary,
                fontSize = 24.sp
            )
            Text(
                text = numeroAMoneda.format(viewModelIpc.total),
                fontSize = 24.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier.align(Alignment.CenterEnd),
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}