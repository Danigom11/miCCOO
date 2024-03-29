package com.midominio.miccoo.nomina_conceptos.conceptos_otros.conceptos_explicados


import android.icu.text.NumberFormat
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.midominio.miccoo.BarraSuperior
import com.midominio.miccoo.ViewModelNomina
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun Sancion(viewModelNomina: ViewModelNomina) {
    val numeroAMoneda = NumberFormat.getCurrencyInstance()
    Scaffold(
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .padding(8.dp),
        topBar = {
            BarraSuperior()
        },
        content = {
            Column {
                TarjetaModeloConceptosOtrosExplicado(
                    concepto = "Sanción",
                    conceptoPrimero = "Hora\nordinaria",
                    resultadoPrimero = numeroAMoneda.format(viewModelNomina.horaOrdinariaRedondeada),
                    operador = "X",
                    conceptoSegundo = "Horas\ndía",
                    resultadoSegundo = "8",
                    resultado = numeroAMoneda.format(viewModelNomina.sancionRedondeado)
                )
            }
        }
    )
}