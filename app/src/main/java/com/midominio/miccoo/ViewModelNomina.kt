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

val opcionesTablasSalariales = listOf(
    "2021",
    "2021 (Definitivas)",
    "2022"
)

class ViewModelNomina : ViewModel() {

    // CONCEPTOS NÓMINA
    var salarioBase by mutableStateOf("1")
    var plusTransporte by mutableStateOf("1")
    var plusConvenio by mutableStateOf("1")
    var retribucionConvenio by mutableStateOf("1")
    var retribucionAnual by mutableStateOf("1")
    val totalHorasAno by mutableStateOf("1800")
    val seguroAccidentesColectivo = 0.73
    val cotizacionContComunes = 4.70
    val cotizacionFormacion = 1.65

    // Conceptos fijos más la antigüedad
    val pagasExtrasProrrateadasMasAntiguedad
        get() = ((salarioBase.toDouble() * 3 / 12) * antiguedadMultiplicador.toDouble())
    val retribucionConvenioConAntiguedad get() = retribucionConvenio.toDouble() * antiguedadMultiplicador.toDouble()
    val retribucionAnualConAntiguedad get() = retribucionAnual.toDouble() + (antiguedadTotalMes * 12)

    // TABLAS SALARIALES
    // Estado de expandir desplegable tablas salariales
    var expandirTablasSalariales by mutableStateOf(false)
    fun cambiarExpandirTablasSalariales(isEnabled: Boolean) {
        expandirTablasSalariales = isEnabled
    }

    // Estado elemento seleccionado en menú desplegable tablas salariales
    var seleccionadoTablasSalariales by mutableStateOf("")
    var tablasSalariales by mutableStateOf("")

    fun seleccionadoCambiaTablasSalariales(isEnabled: String) {
        seleccionadoTablasSalariales = isEnabled
        if (seleccionadoTablasSalariales == "2021") {
            tablasSalariales = "2021"
        }
        if (seleccionadoTablasSalariales == "2021 (Definitivas)") {
            tablasSalariales = "2021 (Definitivas)"
        }
        if (seleccionadoTablasSalariales == "2022") {
            tablasSalariales = "2022"
        }
    }

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

        // Tablas salariales 2021
        if (tablasSalariales == "2021") {
            if (seleccionadoCategoriaProfesional == "Mozo ordinario, limpiador, repartidor") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "163.77"
                retribucionConvenio = "1335.26"
                retribucionAnual = "19050.09"
            }
            if (seleccionadoCategoriaProfesional == "Mozo especialista, ayudante") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "177.75"
                retribucionConvenio = "1349.24"
                retribucionAnual = "19217.86"
            }
            if (seleccionadoCategoriaProfesional == "Engradador lavador") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "184.17"
                retribucionConvenio = "1355.66"
                retribucionAnual = "19294.91"
            }
            if (seleccionadoCategoriaProfesional == "Conductor 2ª, Oficial taller") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "195.69"
                retribucionConvenio = "1367.18"
                retribucionAnual = "19433.08"
            }
            if (seleccionadoCategoriaProfesional == "Conductor 1ª, Oficial Taller") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "216.39"
                retribucionConvenio = "1387.88"
                retribucionAnual = "19681.53"
            }
            if (seleccionadoCategoriaProfesional == "Vigilante") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "167.96"
                retribucionConvenio = "1339.45"
                retribucionAnual = "19100.40"
            }
            if (seleccionadoCategoriaProfesional == "Jefe Almacén") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "213.32"
                retribucionConvenio = "1384.81"
                retribucionAnual = "19644.73"
            }
            if (seleccionadoCategoriaProfesional == "Conductor, Mecánico, Jefe Taller") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "216.39"
                retribucionConvenio = "1387.88"
                retribucionAnual = "19681.53"
            }
            if (seleccionadoCategoriaProfesional == "Auxiliar") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "165.50"
                retribucionConvenio = "1336.99"
                retribucionAnual = "19070.78"
            }
            if (seleccionadoCategoriaProfesional == "Oficial 2ª Administración") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "209.12"
                retribucionConvenio = "1380.61"
                retribucionAnual = "19594.30"
            }
            if (seleccionadoCategoriaProfesional == "Oficial 1ª Administración") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "218.18"
                retribucionConvenio = "1389.67"
                retribucionAnual = "19702.97"
            }
            if (seleccionadoCategoriaProfesional == "Jefe administración, capataz") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "251.57"
                retribucionConvenio = "1423.06"
                retribucionAnual = "20103.68"
            }
            if (seleccionadoCategoriaProfesional == "Inspector principal") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "327.90"
                retribucionConvenio = "1499.39"
                retribucionAnual = "21019.67"
            }
            if (seleccionadoCategoriaProfesional == "Encargado almacén, jefe de servicio") {
                salarioBase = "1008.98"
                plusTransporte = "162.51"
                plusConvenio = "408.54"
                retribucionConvenio = "1580.03"
                retribucionAnual = "21987.36"
            }
        }

        // Tablas salariales 2021 (Definitivas)
        if (tablasSalariales == "2021 (Definitivas)") {
            if (seleccionadoCategoriaProfesional == "Mozo ordinario, limpiador, repartidor") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "171.00"
                retribucionConvenio = "1394.17"
                retribucionAnual = "19890.54"
            }
            if (seleccionadoCategoriaProfesional == "Mozo especialista, ayudante") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "185.60"
                retribucionConvenio = "1408.77"
                retribucionAnual = "20065.75"
            }
            if (seleccionadoCategoriaProfesional == "Engradador lavador") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "192.30"
                retribucionConvenio = "1415.47"
                retribucionAnual = "20146.14"
            }
            if (seleccionadoCategoriaProfesional == "Conductor 2ª, Oficial taller") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "204.32"
                retribucionConvenio = "1427.49"
                retribucionAnual = "20290.42"
            }
            if (seleccionadoCategoriaProfesional == "Conductor 1ª, Oficial Taller") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "225.94"
                retribucionConvenio = "1449.11"
                retribucionAnual = "20549.86"
            }
            if (seleccionadoCategoriaProfesional == "Vigilante") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "175.37"
                retribucionConvenio = "1398.55"
                retribucionAnual = "19943.06"
            }
            if (seleccionadoCategoriaProfesional == "Jefe Almacén") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "222.73"
                retribucionConvenio = "1445.91"
                retribucionAnual = "20511.39"
            }
            if (seleccionadoCategoriaProfesional == "Conductor, Mecánico, Jefe Taller") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "225.94"
                retribucionConvenio = "1449.11"
                retribucionAnual = "20549.86"
            }
            if (seleccionadoCategoriaProfesional == "Auxiliar") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "172.80"
                retribucionConvenio = "1395.97"
                retribucionAnual = "19912.13"
            }
            if (seleccionadoCategoriaProfesional == "Oficial 2ª Administración") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "218.35"
                retribucionConvenio = "1441.52"
                retribucionAnual = "20458.74"
            }
            if (seleccionadoCategoriaProfesional == "Oficial 1ª Administración") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "227.80"
                retribucionConvenio = "1450.98"
                retribucionAnual = "20572.22"
            }
            if (seleccionadoCategoriaProfesional == "Jefe administración, capataz") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "262.67"
                retribucionConvenio = "1485.85"
                retribucionAnual = "20990.64"
            }
            if (seleccionadoCategoriaProfesional == "Inspector principal") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "342.37"
                retribucionConvenio = "1565.54"
                retribucionAnual = "21946.97"
            }
            if (seleccionadoCategoriaProfesional == "Encargado almacén, jefe de servicio") {
                salarioBase = "1053.5"
                plusTransporte = "169.68"
                plusConvenio = "426.56"
                retribucionConvenio = "1649.74"
                retribucionAnual = "22957.35"
            }
        }

        // Tablas salariales 2022
        if (tablasSalariales == "2022") {
            if (seleccionadoCategoriaProfesional == "Mozo ordinario, limpiador, repartidor" || seleccionadoCategoriaProfesional.isEmpty()) {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "173.56"
                retribucionConvenio = "1415.08"
                retribucionAnual = "20188.89"
            }
            if (seleccionadoCategoriaProfesional == "Mozo especialista, ayudante") {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "188.38"
                retribucionConvenio = "1429.90"
                retribucionAnual = "20366.74"
            }
            if (seleccionadoCategoriaProfesional == "Engradador lavador") {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "195.18"
                retribucionConvenio = "1436.70"
                retribucionAnual = "20448.33"
            }
            if (seleccionadoCategoriaProfesional == "Conductor 2ª, Oficial taller") {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "207.39"
                retribucionConvenio = "1448.91"
                retribucionAnual = "20594.78"
            }
            if (seleccionadoCategoriaProfesional == "Conductor 1ª, Oficial Taller") {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "229.33"
                retribucionConvenio = "1470.85"
                retribucionAnual = "20858.10"
            }
            if (seleccionadoCategoriaProfesional == "Vigilante") {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "178.00"
                retribucionConvenio = "1419.53"
                retribucionAnual = "20242.21"
            }
            if (seleccionadoCategoriaProfesional == "Jefe Almacén") {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "226.08"
                retribucionConvenio = "1467.60"
                retribucionAnual = "20819.06"
            }
            if (seleccionadoCategoriaProfesional == "Conductor, Mecánico, Jefe Taller") {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "229.33"
                retribucionConvenio = "1470.85"
                retribucionAnual = "20858.10"
            }
            if (seleccionadoCategoriaProfesional == "Auxiliar") {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "175.39"
                retribucionConvenio = "1416.91"
                retribucionAnual = "20210.82"
            }
            if (seleccionadoCategoriaProfesional == "Oficial 2ª Administración") {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "221.62"
                retribucionConvenio = "1463.14"
                retribucionAnual = "20765.62"
            }
            if (seleccionadoCategoriaProfesional == "Oficial 1ª Administración") {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "231.22"
                retribucionConvenio = "1472.74"
                retribucionAnual = "20880.80"
            }
            if (seleccionadoCategoriaProfesional == "Jefe administración, capataz") {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "266.61"
                retribucionConvenio = "1508.13"
                retribucionAnual = "21305.50"
            }
            if (seleccionadoCategoriaProfesional == "Inspector principal") {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "347.50"
                retribucionConvenio = "1589.02"
                retribucionAnual = "22276.17"
            }
            if (seleccionadoCategoriaProfesional == "Encargado almacén, jefe de servicio") {
                salarioBase = "1069.30"
                plusTransporte = "172.22"
                plusConvenio = "432.96"
                retribucionConvenio = "1674.48"
                retribucionAnual = "23301.71"
            }
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

    val nocturnidadConcepto get() = salarioBase.toDouble() * 0.25


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
