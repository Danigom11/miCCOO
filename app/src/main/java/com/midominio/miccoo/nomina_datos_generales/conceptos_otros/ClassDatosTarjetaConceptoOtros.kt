package com.midominio.miccoo.nomina_datos_generales.conceptos_otros

import android.os.Parcelable
import androidx.compose.ui.graphics.Color
import kotlinx.parcelize.Parcelize

@Parcelize
data class ClassDatosTarjetaConceptoOtros(
    var colorBorde: Color,
    var concepto: String,
    var valor: String,
    var click: String
) : Parcelable