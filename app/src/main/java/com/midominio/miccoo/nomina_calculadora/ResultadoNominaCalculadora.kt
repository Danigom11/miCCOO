package com.midominio.miccoo.nomina_calculadora

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
import com.midominio.miccoo.ViewModelNomina

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ResultadoNominaCompleta(viewModelNomina: ViewModelNomina) {
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
                    text = numeroAMoneda.format(viewModelNomina.salarioBase.toDouble()),
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
                    text = numeroAMoneda.format(viewModelNomina.plusConvenio.toDouble()),
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
                    text = numeroAMoneda.format(viewModelNomina.plusTransporte.toDouble()),
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
                    text = numeroAMoneda.format(viewModelNomina.pagasExtrasProrrateadasMasAntiguedad),
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            if (viewModelNomina.seleccionadoSwitchAntiguedad) {
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Antigüedad:",
                        modifier = Modifier.align(Alignment.CenterStart),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = numeroAMoneda.format(viewModelNomina.antiguedadConcepto),
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.CenterEnd),
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
            if (viewModelNomina.seleccionadoSwitchHorasExtras) {
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Horas extras: ${viewModelNomina.horasExtrasElegidas}",
                        modifier = Modifier.align(Alignment.CenterStart),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = numeroAMoneda.format(viewModelNomina.horasExtrasElegidasTotal),
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.CenterEnd),
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
            if (viewModelNomina.seleccionadoSwitchNocturnidad) {
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Nocturnidad:",
                        modifier = Modifier.align(Alignment.CenterStart),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = numeroAMoneda.format(viewModelNomina.nocturnidadDefinitiva.toDouble()),
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
                    text = numeroAMoneda.format(viewModelNomina.seguroAccidentesColectivo),
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
                    text = numeroAMoneda.format(viewModelNomina.totalIngresos),
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
                    text = "IRPF: ${viewModelNomina.irpfElegida} %",
                    modifier = Modifier.align(Alignment.CenterStart),
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = numeroAMoneda.format(viewModelNomina.totalDescuentoIrpf),
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
                    text = numeroAMoneda.format(viewModelNomina.totalDescuentoCotizacionContComunes),
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
                    text = numeroAMoneda.format(viewModelNomina.totalDescuentoCotizacionFormacion),
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
                    text = numeroAMoneda.format(viewModelNomina.totalDescuentos),
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
                text = numeroAMoneda.format(viewModelNomina.total),
                fontSize = 24.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier.align(Alignment.CenterEnd),
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}