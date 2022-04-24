package com.midominio.miccoo.nomina_conceptos.conceptos_otros

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
    val listaContenidoConceptosOtros: List<ClassDatosTarjetaConceptoOtros> =
        listOf(
            // Hora ordinaria
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Red,
                concepto = "Hora\nordinaria",
                valor = viewModelNomina.horaOrdinariaRedondeada.toString(),
                click = Screens.HORAORDINARIA.ruta
            ),
            // Hora extra
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Blue,
                concepto = "Hora\nextra",
                valor = viewModelNomina.horaExtraRedondeada.toString(),
                click = Screens.HORAEXTRA.ruta
            ),
            // Hora festiva
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Yellow,
                concepto = "Hora\nfestiva",
                valor = viewModelNomina.horaExtraRedondeada.toString(),
                click = Screens.HORAFESTIVA.ruta
            )
        )
    val listaContenidoConceptosOtrosDos: List<ClassDatosTarjetaConceptoOtros> =
        listOf(
            // Nocturnidad
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Green,
                concepto = "Nocturnidad",
                valor = viewModelNomina.nocturnidad.toString(),
                click = Screens.NOCTURNIDAD.ruta
            ),
            // Antigüedad
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Magenta,
                concepto = "Antigüedad",
                valor = viewModelNomina.antiguedadConceptoRedondeada.toString(),
                click = Screens.ANTIGUEDAD.ruta
            ),
            // Despido
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Red,
                concepto = "Despido",
                valor = viewModelNomina.despidoImprocedenteRedondeado.toString(),
                click = Screens.DESPIDO.ruta
            )
        )
    val listaContenidoConceptosOtrosTres: List<ClassDatosTarjetaConceptoOtros> =
        listOf(
            // Huelga
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Blue,
                concepto = "Huelga",
                valor = viewModelNomina.huelgaRedondeado.toString(),
                click = Screens.HUELGA.ruta
            ),
            // Sanción
            ClassDatosTarjetaConceptoOtros(
                colorBorde = Color.Gray,
                concepto = "Sanción",
                valor = viewModelNomina.sancionRedondeado.toString(),
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