package com.midominio.miccoo.nomina_datos_generales.conceptos_otros.conceptos_explicados


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
import com.midominio.miccoo.BarraSuperiorMiCCOO
import com.midominio.miccoo.nomina_datos_generales.ViewModelNomina
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun Nocturnidad(viewModelNomina: ViewModelNomina) {
    Scaffold(
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .padding(8.dp),
        topBar = {
            BarraSuperiorMiCCOO()
        },
        content = {
            Column {
                TarjetaModeloConceptosOtrosExplicado(
                    concepto = "Nocturnidad",
                    conceptoPrimero = "Salario\nbase",
                    resultadoPrimero = viewModelNomina.salarioBaseRedondeado,
                    operador = "+",
                    conceptoSegundo = "Porcentaje",
                    resultadoSegundo = "25%",
                    resultado = viewModelNomina.nocturnidadRedondeada
                )
            }
        }
    )
}