package com.midominio.miccoo.subidaSalario

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViewModelSubidaSalario : ViewModel() {

    // CONCEPTOS NÓMINA
    private var salarioBase by mutableStateOf("1008.98")
    private var plusTransporte by mutableStateOf("162.51")
    var plusConvenio by mutableStateOf("")
    private var retribucionConvenio by mutableStateOf("")
    private var retribucionAnual by mutableStateOf("")

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
            plusConvenio = "163.77"
            retribucionConvenio = "1335.26"
            retribucionAnual = "19050.09"
        }
        if (seleccionadoCategoriaProfesional == "Mozo especialista, ayudante") {
            plusConvenio = "177.75"
            retribucionConvenio = "1349.24"
            retribucionAnual = "19217.86"
        }
        if (seleccionadoCategoriaProfesional == "Engradador lavador") {
            plusConvenio = "184.17"
            retribucionConvenio = "1355.66"
            retribucionAnual = "19294.91"
        }
        if (seleccionadoCategoriaProfesional == "Conductor 2ª, Oficial taller") {
            plusConvenio = "195.69"
            retribucionConvenio = "1367.18"
            retribucionAnual = "19433.08"
        }
        if (seleccionadoCategoriaProfesional == "Conductor 1ª, Oficial Taller") {
            plusConvenio = "216.39"
            retribucionConvenio = "1387.88"
            retribucionAnual = "19681.53"
        }
        if (seleccionadoCategoriaProfesional == "Vigilante") {
            plusConvenio = "167.96"
            retribucionConvenio = "1339.45"
            retribucionAnual = "19100.40"
        }
        if (seleccionadoCategoriaProfesional == "Jefe Almacén") {
            plusConvenio = "213.32"
            retribucionConvenio = "1384.81"
            retribucionAnual = "19644.73"
        }
        if (seleccionadoCategoriaProfesional == "Conductor, Mecánico, Jefe Taller") {
            plusConvenio = "216.39"
            retribucionConvenio = "1387.88"
            retribucionAnual = "19681.53"
        }
        if (seleccionadoCategoriaProfesional == "Auxiliar") {
            plusConvenio = "165.50"
            retribucionConvenio = "1336.99"
            retribucionAnual = "19070.78"
        }
        if (seleccionadoCategoriaProfesional == "Oficial 2ª Administración") {
            plusConvenio = "209.12"
            retribucionConvenio = "1380.61"
            retribucionAnual = "19594.30"
        }
        if (seleccionadoCategoriaProfesional == "Oficial 1ª Administración") {
            plusConvenio = "218.18"
            retribucionConvenio = "1389.67"
            retribucionAnual = "19702.97"
        }
        if (seleccionadoCategoriaProfesional == "Jefe administración, capataz") {
            plusConvenio = "251.57"
            retribucionConvenio = "1423.06"
            retribucionAnual = "20103.68"
        }
        if (seleccionadoCategoriaProfesional == "Inspector principal") {
            plusConvenio = "327.90"
            retribucionConvenio = "1499.39"
            retribucionAnual = "21019.67"
        }
        if (seleccionadoCategoriaProfesional == "Encargado almacén, jefe de servicio") {
            plusConvenio = "408.54"
            retribucionConvenio = "1580.03"
            retribucionAnual = "21987.36"
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

    // Estado elemento seleccionado en antigüedad
    var seleccionadoAntiguedad by mutableStateOf("")

    // Variable para multiplicar la antigüedad elegida
    private var antiguedadMultiplicador by mutableStateOf("1")

    // Variable para texto porcentaje antigüedad elegida
    private var antiguedadPorcentaje by mutableStateOf("0")

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

    // Porcentaje de subida
    var porcentajeSubida by mutableStateOf("")
    fun porcentajeSubidaCambia(isEnabled: String) {
        porcentajeSubida = isEnabled
    }

    // Meses elegidos
    var mesesElegidos by mutableStateOf("")
    fun mesesElegidosCambia(isEnabled: String) {
        mesesElegidos = isEnabled
    }

    // Cálculo atrasos
    val atrasos
        get() =
            if (mesesElegidos == "") {
                mesesElegidos = "0"
                subidaMes * mesesElegidos.replace(",", ".").toDouble()
            } else {
                subidaMes * mesesElegidos.replace(",", ".").toDouble()
            }

    //Cálculo subida mes
    val subidaMes
        get() =
            if (porcentajeSubida == "") {
                porcentajeSubida = "0"
                (((((salarioBase.toDouble() * 15) * (porcentajeSubida.replace(",", ".")
                    .toDouble() / 100 + 1)) * antiguedadMultiplicador.toDouble()) +
                        (((plusConvenio.toDouble() + plusTransporte.toDouble()) * 12) * (porcentajeSubida.replace(
                            ",",
                            "."
                        ).toDouble() / 100 + 1))) / 12) -
                        (((salarioBase.toDouble() * 15) * antiguedadMultiplicador.toDouble() +
                                ((plusConvenio.toDouble() + plusTransporte.toDouble()) * 12)) / 12)
            } else {
                (((((salarioBase.toDouble() * 15) * (porcentajeSubida.replace(",", ".")
                    .toDouble() / 100 + 1)) * antiguedadMultiplicador.toDouble()) +
                        (((plusConvenio.toDouble() + plusTransporte.toDouble()) * 12) * (porcentajeSubida.replace(
                            ",",
                            "."
                        ).toDouble() / 100 + 1))) / 12) -
                        (((salarioBase.toDouble() * 15) * antiguedadMultiplicador.toDouble() +
                                ((plusConvenio.toDouble() + plusTransporte.toDouble()) * 12)) / 12)
            }
}