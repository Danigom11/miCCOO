package com.midominio.miccoo.nomina_completa

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
fun ResultadoNominaCompleta(viewModelNominaCompleta: ViewModelNominaCompleta) {
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
                text = viewModelNominaCompleta.seleccionadoCategoriaProfesional,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.size(size = 20.dp))
            if (viewModelNominaCompleta.seleccionadoSwitchAntiguedad) {
                Text(
                    text = "Antigüedad:",
                    color = MaterialTheme.colors.onPrimary,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = viewModelNominaCompleta.seleccionadoAntiguedad,
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
                    text = numeroAMoneda.format(viewModelNominaCompleta.salarioBase.toDouble()),
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
                    text = numeroAMoneda.format(viewModelNominaCompleta.plusConvenio.toDouble()),
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
                    text = numeroAMoneda.format(viewModelNominaCompleta.plusTransporte.toDouble()),
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
                    text = numeroAMoneda.format(viewModelNominaCompleta.pagasExtrasProrrateadasMasAntiguedad),
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            if (viewModelNominaCompleta.seleccionadoSwitchAntiguedad) {
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Antigüedad:",
                        modifier = Modifier.align(Alignment.CenterStart),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = numeroAMoneda.format(viewModelNominaCompleta.antiguedadConcepto),
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.CenterEnd),
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
            if (viewModelNominaCompleta.seleccionadoSwitchHorasExtras) {
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Horas extras: ${viewModelNominaCompleta.horasExtrasElegidas}",
                        modifier = Modifier.align(Alignment.CenterStart),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = numeroAMoneda.format(viewModelNominaCompleta.horasExtrasElegidasTotal),
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.CenterEnd),
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
            if (viewModelNominaCompleta.seleccionadoSwitchNocturnidad) {
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Nocturnidad:",
                        modifier = Modifier.align(Alignment.CenterStart),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = numeroAMoneda.format(viewModelNominaCompleta.nocturnidad),
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
                    text = numeroAMoneda.format(viewModelNominaCompleta.seguroAccidentesColectivo),
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
                    text = numeroAMoneda.format(viewModelNominaCompleta.totalIngresos),
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
                    text = "IRPF: ${viewModelNominaCompleta.irpfElegida} %",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = numeroAMoneda.format(viewModelNominaCompleta.totalDescuentoIrpf),
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
                    text = numeroAMoneda.format(viewModelNominaCompleta.totalDescuentoCotizacionContComunes),
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
                    text = numeroAMoneda.format(viewModelNominaCompleta.totalDescuentoCotizacionFormacion),
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
                    text = numeroAMoneda.format(viewModelNominaCompleta.totalDescuentos),
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
                text = numeroAMoneda.format(viewModelNominaCompleta.total),
                fontSize = 24.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier.align(Alignment.CenterEnd),
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}