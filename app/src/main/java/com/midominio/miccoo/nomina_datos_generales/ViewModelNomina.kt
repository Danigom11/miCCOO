package com.midominio.miccoo.nomina_datos_generales

import android.icu.text.NumberFormat
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ViewModelNomina : ViewModel() {
    // Variables que controlan cada elemento y su estado que muta
    val salarioBaseTexto get() = numberFormat.format("1008.98".toDouble()).toString()
    private val salarioBaseFijo by mutableStateOf("1008.98")
    var salarioBase by mutableStateOf("1008.98")
    var plusConvenio by mutableStateOf("163.77")
    var plusTransporte by mutableStateOf("162.51")
    var retribucionConvenio by mutableStateOf("1335.26")
    var retribucionAnual by mutableStateOf("19050.09")
    var totalHorasAno by mutableStateOf("1800")

    // Variable que cambia el número a formato moneda
    private val numberFormat = NumberFormat.getCurrencyInstance()

    // Controla estado de expandir desplegable categoria profesional
    private val _expandir = MutableStateFlow(false)
    val expandir: StateFlow<Boolean> = _expandir
    fun cambiarExpandir(isEnabled: Boolean) {
        _expandir.value = isEnabled
    }

    // Controla desplegable antigüedad
    private val _expandirAntiguedad = MutableStateFlow(false)
    val expandirAntiguedad: StateFlow<Boolean> = _expandirAntiguedad
    fun cambiarExpandirAntiguedad(isEnabled: Boolean) {
        _expandirAntiguedad.value = isEnabled
    }

    // Controla estado de elemento seleccionado en menú desplegable
    private val _seleccionado = MutableLiveData("")
    val seleccionado: LiveData<String> = _seleccionado

    // Controla estado elemento seleccionado en antigüedad
    private val _seleccionadoAntiguedad = MutableLiveData("")
    val seleccionadoAntiguedad: LiveData<String> = _seleccionadoAntiguedad

    var antiguedadSuma by mutableStateOf("1")

    var antiguedadPorcentaje by mutableStateOf("0")

    fun seleccionadoCambiaAntiguedad(isEnabled: String) {
        _seleccionadoAntiguedad.value = isEnabled
        if (seleccionadoAntiguedad.value == "Sin antiguedad") {
            antiguedadSuma = "1"
        }
        if (seleccionadoAntiguedad.value == "Un bienio (+2 años)") {
            antiguedadSuma = "1.05"
            antiguedadPorcentaje = "5%"
        }
        if (seleccionadoAntiguedad.value == "Dos bienios (+4 años)") {
            antiguedadSuma = "1.10"
            antiguedadPorcentaje = "10%"
        }
        if (seleccionadoAntiguedad.value == "Dos bienios y un quinquenios (+9 años)") {
            antiguedadSuma = "1.20"
            antiguedadPorcentaje = "20%"
        }
        if (seleccionadoAntiguedad.value == "Dos bienios y dos quinquenios (+14 años)") {
            antiguedadSuma = "1.30"
            antiguedadPorcentaje = "30%"
        }
        if (seleccionadoAntiguedad.value == "Dos bienios y tres quinquenios (+19 años)") {
            antiguedadSuma = "1.40"
            antiguedadPorcentaje = "40%"
        }
        if (seleccionadoAntiguedad.value == "Dos bienios y cuatro quinquenios (+24 años)") {
            antiguedadSuma = "1.50"
            antiguedadPorcentaje = "50%"
        }
        if (seleccionadoAntiguedad.value == "Dos bienios y cinco quinquenios (+29 años)") {
            antiguedadSuma = "1.60"
            antiguedadPorcentaje = "60%"
        }
    }

    // Cambia los conceptos cuando se selecciona una categoría diferente
    fun seleccionadoCambia(isEnabled: String) {
        _seleccionado.value = isEnabled
    }

    // Total horas año
    val totalHorasAnoRedondeado
        get() = totalHorasAno

    // Salario mensual
    val salarioMensualRedondeado
        get() = numberFormat.format(retribucionConvenio.toDouble()).toString()

    // Salario anual
    val salarioAnualRedondeado get() = numberFormat.format(retribucionAnual.toDouble()).toString()

    // Pagas extras 3 pagas año salario base más antigüedad
    val pagasExtrasProrrateadas
        get() = numberFormat.format(salarioBase.toDouble() * 3 / 12).toString()

    // Pagas extras sin cambios
    val pagasExtrasProrrateadasFijasAntiguedadTotal
        get() = numberFormat.format((salarioBaseFijo.toDouble() * 3 / 12) * antiguedadSuma.toDouble())
            .toString()

    val pagasExtrasProrrateadasFijasAntiguedadDiferencia
        get() = numberFormat.format((salarioBaseFijo.toDouble() * 3 / 12) * (antiguedadSuma.toDouble() - 1))
            .toString()

    val pagasExtrasProrrateadasFijas
        get() = numberFormat.format(salarioBaseFijo.toDouble() * 3 / 12).toString()

    // Salario base
    val salarioBaseRedondeado get() = numberFormat.format(salarioBase.toDouble()).toString()

    // Plus convenio
    val plusConvenioRedondeado get() = numberFormat.format(plusConvenio.toDouble()).toString()

    // Plus transporte
    val plusTransporteRedondeado get() = numberFormat.format(plusTransporte.toDouble()).toString()

    // Hora ordinaria
    val horaOrdinariaRedondeada
        get() = numberFormat.format(retribucionAnual.toDouble() / totalHorasAno.toDouble())
            .toString()

    // Hora extra
    val horaExtraRedondeada
        get() = numberFormat.format((retribucionAnual.toDouble() / totalHorasAno.toDouble()) * 1.25)
            .toString()

    // Nocturnidad
    val nocturnidadRedondeada get() = numberFormat.format(salarioBase.toDouble() * 0.25).toString()


    // Antigüedades
    val antiguedadConceptoRedondeada
        get() = numberFormat.format(salarioBaseFijo.toDouble() * (antiguedadSuma.toDouble() - 1))
            .toString()
    val antiguedadTotalMes
        get() = numberFormat.format((salarioBaseFijo.toDouble() * 3 / 12) * (antiguedadSuma.toDouble() - 1) + (salarioBaseFijo.toDouble() * (antiguedadSuma.toDouble() - 1)))
            .toString()

    // Indemnización despido

    // Salario diario: salario bruto anual : dias laborales año (360)
    val salarioDiarioRedondeado
        get() = numberFormat.format(retribucionAnual.toDouble() / 360).toString()

    // Tipos despidos
    // Finalización de contrato
    val finalizacionContratoRedondeado
        get() = numberFormat.format((retribucionAnual.toDouble() / 360) * 12).toString()

    // Causas objetivas
    val causasObjetivasRedondeado
        get() = numberFormat.format((retribucionAnual.toDouble() / 360) * 20).toString()

    // Despido improcedente
    val despidoImprocedenteRedondeado
        get() = numberFormat.format((retribucionAnual.toDouble() / 360) * 33).toString()

    // Huelga
    // Salario diario = Salario anual entre 15 pagas y entre 30 días del mes
    val salarioDiaHuelgaRedondeado
        get() = numberFormat.format(retribucionAnual.toDouble() / 15 / 30).toString()

    // Sumar parte proporcional días descanso semanal
    val huelgaRedondeado
        get() = numberFormat.format((retribucionAnual.toDouble() / 15 / 30) * 1.4).toString()

    // Sanción
    // Hora ordinaria por 8 horas día
    val sancionRedondeado
        get() = numberFormat.format((retribucionAnual.toDouble() / totalHorasAno.toDouble()) * 8)
            .toString()
}
