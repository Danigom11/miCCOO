package com.midominio.miccoo.nomina_conceptos.conceptos_otros

import android.icu.text.NumberFormat
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.midominio.miccoo.ViewModelNomina
import com.midominio.miccoo._pagina_principal.Screens

@Composable
fun ScreenConceptosOtros(
    viewModelNomina: ViewModelNomina,
    navController: NavController
) {
    val numeroAMoneda = NumberFormat.getCurrencyInstance()
    val listaContenidoConceptosOtros: List<ClassDatosTarjetaConceptoOtros> =
        listOf(
            // Hora ordinaria
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Red,
                concepto = "Hora\nordinaria",
                valor = numeroAMoneda.format(viewModelNomina.horaOrdinariaRedondeada),
                click = Screens.HORAORDINARIA.ruta
            ),
            // Hora extra
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Blue,
                concepto = "Hora\nextra",
                valor = numeroAMoneda.format(viewModelNomina.horaExtraRedondeada),
                click = Screens.HORAEXTRA.ruta
            ),
            // Hora festiva
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Yellow,
                concepto = "Hora\nfestiva",
                valor = numeroAMoneda.format(viewModelNomina.horaExtraRedondeada),
                click = Screens.HORAFESTIVA.ruta
            )
        )
    val listaContenidoConceptosOtrosDos: List<ClassDatosTarjetaConceptoOtros> =
        listOf(
            // Nocturnidad
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Green,
                concepto = "Nocturnidad",
                valor = numeroAMoneda.format(viewModelNomina.nocturnidad),
                click = Screens.NOCTURNIDAD.ruta
            ),
            // Antigüedad
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Magenta,
                concepto = "Antigüedad",
                valor = numeroAMoneda.format(viewModelNomina.antiguedadConceptoRedondeada),
                click = Screens.ANTIGUEDAD.ruta
            ),
            // Despido
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Red,
                concepto = "Despido",
                valor = numeroAMoneda.format(viewModelNomina.despidoImprocedenteRedondeado),
                click = Screens.DESPIDO.ruta
            )
        )
    val listaContenidoConceptosOtrosTres: List<ClassDatosTarjetaConceptoOtros> =
        listOf(
            // Huelga
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Blue,
                concepto = "Huelga",
                valor = numeroAMoneda.format(viewModelNomina.huelgaRedondeado),
                click = Screens.HUELGA.ruta
            ),
            // Sanción
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Gray,
                concepto = "Sanción",
                valor = numeroAMoneda.format(viewModelNomina.sancionRedondeado),
                click = Screens.SANCION.ruta
            )
        )

    LazyRow {
        items(listaContenidoConceptosOtros) { classDatosTarjetaConceptosOtros ->
            TarjetaModeloConceptosOtros(
                navController = navController,
                colorBorde = classDatosTarjetaConceptosOtros.colorBorde,
                conceptoOtro = classDatosTarjetaConceptosOtros.concepto,
                resultado = classDatosTarjetaConceptosOtros.valor,
                click = classDatosTarjetaConceptosOtros.click
            )
        }
    }
    LazyRow {
        items(listaContenidoConceptosOtrosDos) { classDatosTarjetaConceptosOtros ->
            TarjetaModeloConceptosOtros(
                navController = navController,
                colorBorde = classDatosTarjetaConceptosOtros.colorBorde,
                conceptoOtro = classDatosTarjetaConceptosOtros.concepto,
                resultado = classDatosTarjetaConceptosOtros.valor,
                click = classDatosTarjetaConceptosOtros.click
            )
        }
    }
    LazyRow {
        items(listaContenidoConceptosOtrosTres) { classDatosTarjetaConceptosOtros ->
            TarjetaModeloConceptosOtros(
                navController = navController,
                colorBorde = classDatosTarjetaConceptosOtros.colorBorde,
                conceptoOtro = classDatosTarjetaConceptosOtros.concepto,
                resultado = classDatosTarjetaConceptosOtros.valor,
                click = classDatosTarjetaConceptosOtros.click
            )
        }
    }

}