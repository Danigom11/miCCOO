package com.midominio.miccoo.nomina_conceptos.conceptos_fijos

import android.icu.text.NumberFormat
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.midominio.miccoo.ViewModelNomina

@Composable
fun ScreenConceptosFijos(viewModelNomina: ViewModelNomina) {
    val numeroAMoneda = NumberFormat.getCurrencyInstance()
    val listaContenidoConceptosFijos: List<DataClassNominaConceptosFijos> =
        listOf(
            // Salario mensual
            DataClassNominaConceptosFijos(
                Color.Red,
                "Salario\nmensual",
                numeroAMoneda.format(viewModelNomina.retribucionConvenio.toDouble())
            ),
            // Salario anual
            DataClassNominaConceptosFijos(
                Color.Green,
                "Salario\nanual",
                numeroAMoneda.format(viewModelNomina.retribucionAnual.toDouble())
            ),
            // Pagas extras prorrateadas
            DataClassNominaConceptosFijos(
                Color.Blue,
                "Pagas\nprorrateadas",
                numeroAMoneda.format(viewModelNomina.pagasExtrasProrrateadasFijas)
            ),
            // Salario base
            DataClassNominaConceptosFijos(
                Color.Yellow,
                "Salario\nbase",
                numeroAMoneda.format(viewModelNomina.salarioBase.toDouble())
            ),
            // Plus convenio
            DataClassNominaConceptosFijos(
                Color.Cyan,
                "Plus\nconvenio",
                numeroAMoneda.format(viewModelNomina.plusConvenio.toDouble())
            ),
            // Plus transporte
            DataClassNominaConceptosFijos(
                Color.Magenta,
                "Plus\ntransporte",
                numeroAMoneda.format(viewModelNomina.plusTransporte.toDouble())
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