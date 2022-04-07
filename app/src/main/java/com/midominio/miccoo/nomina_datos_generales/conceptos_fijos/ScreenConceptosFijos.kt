package com.midominio.miccoo.nomina_datos_generales.conceptos_fijos

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.midominio.miccoo.nomina_datos_generales.ViewModelNomina

@Composable
fun ScreenConceptosFijos(viewModelNomina: ViewModelNomina) {
    val listaContenidoConceptosFijos: List<DataClassNominaConceptosFijos> =
        listOf(
            // Salario mensual
            DataClassNominaConceptosFijos(
                Color.Red,
                "Salario\nmensual",
                viewModelNomina.salarioMensualRedondeado
            ),
            // Salario anual
            DataClassNominaConceptosFijos(
                Color.Green,
                "Salario\nanual",
                viewModelNomina.salarioAnualRedondeado
            ),
            // Pagas extras prorrateadas
            DataClassNominaConceptosFijos(
                Color.Blue,
                "Pagas\nprorrateadas",
                viewModelNomina.pagasExtrasProrrateadas
            ),
            // Salario base
            DataClassNominaConceptosFijos(
                Color.Yellow,
                "Salario\nbase",
                viewModelNomina.salarioBaseTexto
            ),
            // Plus convenio
            DataClassNominaConceptosFijos(
                Color.Cyan,
                "Plus\nconvenio",
                viewModelNomina.plusConvenioRedondeado
            ),
            // Plus transporte
            DataClassNominaConceptosFijos(
                Color.Magenta,
                "Plus\ntransporte",
                viewModelNomina.plusTransporteRedondeado
            )
        )
    LazyRow {
        items(listaContenidoConceptosFijos) { dataClassNominaFijos ->
            TarjetaModeloConceptosFijosNomina(
                colorBorde = dataClassNominaFijos.colorBorde,
                conceptoFijo = dataClassNominaFijos.conceptoFijo,
                resultado = dataClassNominaFijos.resultado
            )
        }
    }
}