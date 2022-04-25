package com.midominio.miccoo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

val opcionesCategoriaProfesional = listOf(
    "Mozo ordinario, limpiador, repartidor",
    "Mozo especialista, ayudante",
    "Engradador lavador",
    "Conductor 2ª, Oficial taller",
    "Conductor 1ª, Oficial Taller",
    "Vigilante",
    "Jefe Almacén",
    "Conductor, Mecánico, Jefe Taller",
    "Auxiliar",
    "Oficial 2ª Administración",
    "Oficial 1ª Administración",
    "Jefe administración, capataz",
    "Inspector principal",
    "Encargado almacén, jefe de servicio"
)

val opcionesAntiguedad = listOf(
    "Sin antigüedad",
    "Un bienio (+2 años)",
    "Dos bienios (+4 años)",
    "Dos bienios y un quinquenios (+9 años)",
    "Dos bienios y dos quinquenios (+14 años)",
    "Dos bienios y tres quinquenios (+19 años)",
    "Dos bienios y cuatro quinquenios (+24 años)",
    "Dos bienios y cinco quinquenios (+29 años)"
)

class ViewModelNomina : ViewModel() {

    // CONCEPTOS NÓMINA
    val salarioBase by mutableStateOf("1069.30")
    val plusTransporte by mutableStateOf("172.22")
    var plusConvenio by mutableStateOf("173.56")
    var retribucionConvenio by mutableStateOf("1415.08")
    var retribucionAnual by mutableStateOf("20188.89")
    val totalHorasAno by mutableStateOf("1800")
    val seguroAccidentesColectivo = 0.73
    val cotizacionContComunes = 4.70
    val cotizacionFormacion = 1.65

    // Conceptos fijos más la antigüedad
    val pagasExtrasProrrateadasMasAntiguedad
        get() = ((salarioBase.toDouble() * 3 / 12) * antiguedadMultiplicador.toDouble())
    val retribucionConvenioConAntiguedad get() = retribucionConvenio.toDouble() * antiguedadMultiplicador.toDouble()
    val retribucionAnualConAntiguedad get() = retribucionAnual.toDouble() + (antiguedadTotalMes * 12)


    // CATEGORÍA PROFESIONAL
    // Estado de expandir desplegable categoria profesional
    var expandirCategoriaProfesional by mutableStateOf(false)
    fun cambiarExpandirCategoriaProfesional(isEnabled: Boolean) {
        expandirCategoriaProfesional = isEnabled
    }

    // Estado elemento seleccionado en menú desplegable categoría profesional
    var seleccionadoCategoriaProfesional by mutableStateOf("")

    // Modifica selección categorías profesionales y los conceptos que cambian
    fun seleccionadoCambiaCategoriaProfesional(isEnabled: String) {
        seleccionadoCategoriaProfesional = isEnabled
        if (seleccionadoCategoriaProfesional == "Mozo ordinario, limpiador, repartidor" || seleccionadoCategoriaProfesional.isEmpty()) {
            plusConvenio = "173.56"
            retribucionConvenio = "1415.08"
            retribucionAnual = "20188.89"
        }
        if (seleccionadoCategoriaProfesional == "Mozo especialista, ayudante") {
            plusConvenio = "188.38"
            retribucionConvenio = "1429.90"
            retribucionAnual = "20366.74"
        }
        if (seleccionadoCategoriaProfesional == "Engradador lavador") {
            plusConvenio = "195.18"
            retribucionConvenio = "1436.70"
            retribucionAnual = "20448.33"
        }
        if (seleccionadoCategoriaProfesional == "Conductor 2ª, Oficial taller") {
            plusConvenio = "207.39"
            retribucionConvenio = "1448.91"
            retribucionAnual = "20594.78"
        }
        if (seleccionadoCategoriaProfesional == "Conductor 1ª, Oficial Taller") {
            plusConvenio = "229.33"
            retribucionConvenio = "1470.85"
            retribucionAnual = "20858.10"
        }
        if (seleccionadoCategoriaProfesional == "Vigilante") {
            plusConvenio = "178.00"
            retribucionConvenio = "1419.53"
            retribucionAnual = "20242.21"
        }
        if (seleccionadoCategoriaProfesional == "Jefe Almacén") {
            plusConvenio = "226.08"
            retribucionConvenio = "1467.60"
            retribucionAnual = "20819.06"
        }
        if (seleccionadoCategoriaProfesional == "Conductor, Mecánico, Jefe Taller") {
            plusConvenio = "229.33"
            retribucionConvenio = "1470.85"
            retribucionAnual = "20858.10"
        }
        if (seleccionadoCategoriaProfesional == "Auxiliar") {
            plusConvenio = "175.39"
            retribucionConvenio = "1416.91"
            retribucionAnual = "20210.82"
        }
        if (seleccionadoCategoriaProfesional == "Oficial 2ª Administración") {
            plusConvenio = "221.62"
            retribucionConvenio = "1463.14"
            retribucionAnual = "20765.62"
        }
        if (seleccionadoCategoriaProfesional == "Oficial 1ª Administración") {
            plusConvenio = "231.22"
            retribucionConvenio = "1472.74"
            retribucionAnual = "20880.80"
        }
        if (seleccionadoCategoriaProfesional == "Jefe administración, capataz") {
            plusConvenio = "266.61"
            retribucionConvenio = "1508.13"
            retribucionAnual = "21305.50"
        }
        if (seleccionadoCategoriaProfesional == "Inspector principal") {
            plusConvenio = "347.50"
            retribucionConvenio = "1589.02"
            retribucionAnual = "22276.17"
        }
        if (seleccionadoCategoriaProfesional == "Encargado almacén, jefe de servicio") {
            plusConvenio = "432.96"
            retribucionConvenio = "1674.48"
            retribucionAnual = "23301.71"
        }
    }

    // ANTIGÜEDAD
    // Estado de expandir desplegable antigüedad
    var expandirAntiguedad by mutableStateOf(false)
    fun cambiarExpandirAntiguedad(isEnabled: Boolean) {
        expandirAntiguedad = isEnabled
    }

    // Controla estado switch antigüedad
    var seleccionadoSwitchAntiguedad by mutableStateOf(false)
    fun seleccionadoSwitchCambiaAntiguedad(isEnabled: Boolean) {
        seleccionadoSwitchAntiguedad = isEnabled
    }

    // Concepto antigüedad
    val antiguedadConcepto
        get() = (salarioBase.toDouble() * (antiguedadMultiplicador.toDouble() - 1))

    // Estado elemento seleccionado en antigüedad
    var seleccionadoAntiguedad by mutableStateOf("")

    // Variable para multiplicar la antigüedad elegida
    var antiguedadMultiplicador by mutableStateOf("1")

    // Variable para texto porcentaje antigüedad elegida
    var antiguedadPorcentaje by mutableStateOf("0")

    // Controla los cambios en antigüedad
    fun seleccionadoCambiaAntiguedad(isEnabled: String) {
        seleccionadoAntiguedad = isEnabled
        if (seleccionadoAntiguedad == "Sin antiguedad" || !seleccionadoSwitchAntiguedad) {
            antiguedadMultiplicador = "1"
            antiguedadPorcentaje = "0%"
        }
        if (seleccionadoAntiguedad == "Un bienio (+2 años)") {
            antiguedadMultiplicador = "1.05"
            antiguedadPorcentaje = "5%"
        }
        if (seleccionadoAntiguedad == "Dos bienios (+4 años)") {
            antiguedadMultiplicador = "1.10"
            antiguedadPorcentaje = "10%"
        }
        if (seleccionadoAntiguedad == "Dos bienios y un quinquenios (+9 años)") {
            antiguedadMultiplicador = "1.20"
            antiguedadPorcentaje = "20%"
        }
        if (seleccionadoAntiguedad == "Dos bienios y dos quinquenios (+14 años)") {
            antiguedadMultiplicador = "1.30"
            antiguedadPorcentaje = "30%"
        }
        if (seleccionadoAntiguedad == "Dos bienios y tres quinquenios (+19 años)") {
            antiguedadMultiplicador = "1.40"
            antiguedadPorcentaje = "40%"
        }
        if (seleccionadoAntiguedad == "Dos bienios y cuatro quinquenios (+24 años)") {
            antiguedadMultiplicador = "1.50"
            antiguedadPorcentaje = "50%"
        }
        if (seleccionadoAntiguedad == "Dos bienios y cinco quinquenios (+29 años)") {
            antiguedadMultiplicador = "1.60"
            antiguedadPorcentaje = "60%"
        }
    }

    // HORAS EXTRAS
    // Número de horas extras elegido
    var horasExtrasElegidas by mutableStateOf("")
    fun horasExtrasElegidasCambia(isEnabled: String) {
        horasExtrasElegidas = isEnabled
    }

    // Hora extra
    val horaExtra
        get() = ((retribucionAnualConAntiguedad / totalHorasAno.toDouble()) * 1.25)

    // Suma total horas extras elegidas
    val horasExtrasElegidasTotal
        get() =
            if (horasExtrasElegidas.isEmpty() || !seleccionadoSwitchHorasExtras) {
                "0".toDouble()
            } else {
                (horasExtrasElegidas.replace(",", ".").toDouble() * horaExtra)
            }

    // Estado switch horas extras
    var seleccionadoSwitchHorasExtras by mutableStateOf(false)
    fun seleccionadoSwitchCambiaHorasExtras(isEnabled: Boolean) {
        seleccionadoSwitchHorasExtras = isEnabled
    }

    // NOCTURNIDAD
    // Controla estado switch nocturnidad
    var seleccionadoSwitchNocturnidad by mutableStateOf(false)
    fun seleccionadoSwitchCambiaNocturnidad(isEnabled: Boolean) {
        seleccionadoSwitchNocturnidad = isEnabled
    }

    // Variable cálculo nocturnidad
    val nocturnidad
        get() = if (seleccionadoSwitchNocturnidad) {
            (salarioBase.toDouble() * 0.25)
        } else {
            0.toDouble()
        }

    val nocturnidadConcepto = salarioBase.toDouble() * 0.25


    // TOTAL INGRESOS
    val totalIngresos
        get() = (
                salarioBase.toDouble() +
                        plusConvenio.toDouble() +
                        plusTransporte.toDouble() +
                        pagasExtrasProrrateadasMasAntiguedad +
                        antiguedadConcepto +
                        horasExtrasElegidasTotal +
                        nocturnidad +
                        seguroAccidentesColectivo
                )

    // IRPF
    //Variable IRPF
    var irpfElegida by mutableStateOf("")
    fun irpfElegidaCambia(isEnabled: String) {
        irpfElegida = isEnabled
    }

    // Calcula total descuento IRPF
    val totalDescuentoIrpf
        get() = if (irpfElegida.isNotEmpty()) {
            (
                    (retribucionConvenio.toDouble() +
                            pagasExtrasProrrateadasMasAntiguedad +
                            antiguedadConcepto +
                            horasExtrasElegidasTotal) *
                            (irpfElegida.replace(",", ".").toDouble() * 0.01)
                    )
        } else {
            0.toDouble()
        }

    // COTIZACIÓN CONTINGENCIAS COMUNES
    val totalDescuentoCotizacionContComunes
        get() = (
                totalIngresos *
                        (cotizacionContComunes * 0.01)
                )

    // COTIZACIÓN FORMACIÓN
    val totalDescuentoCotizacionFormacion
        get() = (
                totalIngresos *
                        (cotizacionFormacion * 0.01)
                )

    // RESULTADO NÓMINA
    val total
        get() = (
                totalIngresos - totalDescuentos - seguroAccidentesColectivo
                )

    // TOTAL DESCUENTOS
    val totalDescuentos
        get() = (
                totalDescuentoIrpf +
                        totalDescuentoCotizacionFormacion +
                        totalDescuentoCotizacionContComunes
                )

    // ANTIGÜO VIEWMODEL VERIFICAR!!!!

    // Pagas extras sin cambios
    val pagasExtrasProrrateadasFijasAntiguedadTotal
        get() = (salarioBase.toDouble() * 3 / 12) * antiguedadMultiplicador.toDouble()

    val pagasExtrasProrrateadasFijasAntiguedadDiferencia
        get() = (salarioBase.toDouble() * 3 / 12) * (antiguedadMultiplicador.toDouble() - 1)

    val pagasExtrasProrrateadasFijas
        get() = salarioBase.toDouble() * 3 / 12

    // Hora ordinaria
    val horaOrdinariaRedondeada
        get() = retribucionAnualConAntiguedad / totalHorasAno.toDouble()

    // Hora extra
    val horaExtraRedondeada
        get() = (retribucionAnualConAntiguedad / totalHorasAno.toDouble()) * 1.25


    // Antigüedades
    val antiguedadConceptoRedondeada
        get() = salarioBase.toDouble() * (antiguedadMultiplicador.toDouble() - 1)
    val antiguedadTotalMes
        get() = (salarioBase.toDouble() * 3 / 12) * (antiguedadMultiplicador.toDouble() - 1) + (salarioBase.toDouble() * (antiguedadMultiplicador.toDouble() - 1))

    // Indemnización despido

    // Salario diario: salario bruto anual : dias laborales año (360)
    val salarioDiarioRedondeado
        get() = retribucionAnualConAntiguedad / 360

    // Tipos despidos
    // Finalización de contrato
    val finalizacionContratoRedondeado
        get() = (retribucionAnualConAntiguedad / 360) * 12

    // Causas objetivas
    val causasObjetivasRedondeado
        get() = (retribucionAnualConAntiguedad / 360) * 20

    // Despido improcedente
    val despidoImprocedenteRedondeado
        get() = (retribucionAnualConAntiguedad / 360) * 33

    // Huelga
    // Salario diario = Salario anual entre 15 pagas y entre 30 días del mes
    val salarioDiaHuelgaRedondeado
        get() = retribucionAnualConAntiguedad / 15 / 30

    // Sumar parte proporcional días descanso semanal
    val huelgaRedondeado
        get() = (retribucionAnualConAntiguedad / 15 / 30) * 1.4

    // Sanción
    // Hora ordinaria por 8 horas día
    val sancionRedondeado
        get() = (retribucionAnualConAntiguedad / totalHorasAno.toDouble()) * 8

}
