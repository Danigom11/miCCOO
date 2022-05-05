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
    "2020 (Definitivas)",
    "2021 (+2%)",
    "2021 (Definitivas +6,5%)",
    "2022 (+1,5%)"
)

class ViewModelNomina : ViewModel() {

    // CONCEPTOS NÓMINA
    var salarioBase by mutableStateOf("0")
    var plusTransporte by mutableStateOf("0")
    var plusConvenio by mutableStateOf("0")
    var retribucionConvenio by mutableStateOf("0")
    var retribucionAnual by mutableStateOf("0")
    val horasAnualesMaximas by mutableStateOf("1800")
    val seguroAccidentesColectivo = 0.73
    val cotizacionContComunes = 4.70
    val cotizacionFormacion = 1.65

    // Conceptos fijos más la antigüedad
    val pagasExtrasProrrateadasMasAntiguedad
        get() = ((salarioBase.toDouble() * 3 / 12) * antiguedadMultiplicador.toDouble())
    val retribucionConvenioConAntiguedad get() = retribucionConvenio.toDouble() * antiguedadMultiplicador.toDouble()
    val retribucionAnualConAntiguedad get() = retribucionAnual.toDouble() + (antiguedadTotalMes * 12)


    // HORAS AÑO
    // Numero horas año elegido modificable
    var horasAnualesElegidas by mutableStateOf("1800")
    fun horasAnualesElegidasCambia(isEnabled: String) {
        horasAnualesElegidas = isEnabled
    }

    // Multiplicador a todos los conceptos
    val multiplicadorHorasAnuales
        get() = horasAnualesElegidas.toDouble() / horasAnualesMaximas.toDouble()

    // Estado switch contrato jornada completa
    var seleccionadoSwitchJornadaCompleta by mutableStateOf(false)
    fun seleccionadoSwitchCambiaJornadaCompleta(isEnabled: Boolean) {
        seleccionadoSwitchJornadaCompleta = isEnabled
    }

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
        if (seleccionadoTablasSalariales == "2020 (Definitivas)") {
            tablasSalariales = "2020 (Definitivas)"
        }
        if (seleccionadoTablasSalariales == "2021 (+2%)") {
            tablasSalariales = "2021 (+2%)"
        }
        if (seleccionadoTablasSalariales == "2021 (Definitivas +6,5%)") {
            tablasSalariales = "2021 (Definitivas +6,5%)"
        }
        if (seleccionadoTablasSalariales == "2022 (+1,5%)") {
            tablasSalariales = "2022 (+1,5%)"
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

        // Tablas salariales "2020 (Definitivas)"
        if (tablasSalariales == "2020 (Definitivas)") {
            if (seleccionadoCategoriaProfesional == "Mozo ordinario, limpiador, repartidor") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (153.12 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1248.47 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (17811.83 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Mozo especialista, ayudante") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (166.20 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1261.54 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (17968.70 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Engradador lavador") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (172.20 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1267.54 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (18040.74 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Conductor 2ª, Oficial taller") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (182.97 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1278.31 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (18169.93 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Conductor 1ª, Oficial Taller") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (202.32 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1297.67 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (18402.23 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Vigilante") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (157.04 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1252.39 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (17858.87 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Jefe Almacén") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (199.45 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1294.80 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (18367.82 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Conductor, Mecánico, Jefe Taller") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (202.32 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1297.67 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (18402.23 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Auxiliar") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (154.74 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1250.09 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (17831.18 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Oficial 2ª Administración") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (195.53 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1290.87 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (18320.67 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Oficial 1ª Administración") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (204.00 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1299.34 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (18422.28 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Jefe administración, capataz") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (235.22 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1330.56 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (18796.94 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Inspector principal") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (306.59 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1401.93 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19653.39 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Encargado almacén, jefe de servicio") {
                salarioBase = (943.40 * multiplicadorHorasAnuales).toString()
                plusTransporte = (151.95 * multiplicadorHorasAnuales).toString()
                plusConvenio = (381.98 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1477.33 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20558.18 * multiplicadorHorasAnuales).toString()
            }
        }

        // Tablas salariales 2021 (+2%)
        if (tablasSalariales == "2021 (+2%)") {
            if (seleccionadoCategoriaProfesional == "Mozo ordinario, limpiador, repartidor") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (163.77 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1335.26 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19050.09 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Mozo especialista, ayudante") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (177.75 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1349.24 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19217.86 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Engradador lavador") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (184.17 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1355.66 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19294.91 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Conductor 2ª, Oficial taller") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (195.69 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1367.18 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19433.08 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Conductor 1ª, Oficial Taller") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (216.39 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1387.88 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19681.53 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Vigilante") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (167.96 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1339.45 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19100.40 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Jefe Almacén") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (213.32 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1384.81 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19644.73 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Conductor, Mecánico, Jefe Taller") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (216.39 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1387.88 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19681.53 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Auxiliar") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (165.50 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1336.99 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19070.78 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Oficial 2ª Administración") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (209.12 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1380.61 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19594.30 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Oficial 1ª Administración") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (218.18 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1389.67 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19702.97 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Jefe administración, capataz") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (251.57 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1423.06 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20103.68 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Inspector principal") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (327.90 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1499.39 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (21019.67 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Encargado almacén, jefe de servicio") {
                salarioBase = (1008.98 * multiplicadorHorasAnuales).toString()
                plusTransporte = (162.51 * multiplicadorHorasAnuales).toString()
                plusConvenio = (408.54 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1580.03 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (21987.36 * multiplicadorHorasAnuales).toString()
            }
        }

        // Tablas salariales 2021 (Definitivas +6,5%)
        if (tablasSalariales == "2021 (Definitivas +6,5%)") {
            if (seleccionadoCategoriaProfesional == "Mozo ordinario, limpiador, repartidor") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (171.00 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1394.17 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19890.54 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Mozo especialista, ayudante") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (185.60 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1408.77 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20065.75 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Engradador lavador") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (192.30 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1415.47 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20146.14 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Conductor 2ª, Oficial taller") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (204.32 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1427.49 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20290.42 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Conductor 1ª, Oficial Taller") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (225.94 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1449.11 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20549.86 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Vigilante") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (175.37 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1398.55 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19943.06 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Jefe Almacén") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (222.73 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1445.91 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20511.39 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Conductor, Mecánico, Jefe Taller") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (225.94 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1449.11 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20549.86 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Auxiliar") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (172.80 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1395.97 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (19912.13 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Oficial 2ª Administración") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (218.35 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1441.52 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20458.74 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Oficial 1ª Administración") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (227.80 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1450.98 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20572.22 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Jefe administración, capataz") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (262.67 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1485.85 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20990.64 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Inspector principal") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (342.37 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1565.54 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (21946.97 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Encargado almacén, jefe de servicio") {
                salarioBase = (1053.5 * multiplicadorHorasAnuales).toString()
                plusTransporte = (169.68 * multiplicadorHorasAnuales).toString()
                plusConvenio = (426.56 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1649.74 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (22957.35 * multiplicadorHorasAnuales).toString()
            }
        }

        // Tablas salariales 2022 (+1,5%)
        if (tablasSalariales == "2022 (+1,5%)") {
            if (seleccionadoCategoriaProfesional == "Mozo ordinario, limpiador, repartidor" || seleccionadoCategoriaProfesional.isEmpty()) {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (173.56 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1415.08 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20188.89 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Mozo especialista, ayudante") {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (188.38 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1429.90 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20366.74 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Engradador lavador") {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (195.18 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1436.70 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20448.33 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Conductor 2ª, Oficial taller") {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (207.39 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1448.91 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20594.78 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Conductor 1ª, Oficial Taller") {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (229.33 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1470.85 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20858.10 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Vigilante") {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (178.00 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1419.53 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20242.21 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Jefe Almacén") {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (226.08 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1467.60 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20819.06 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Conductor, Mecánico, Jefe Taller") {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (229.33 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1470.85 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20858.10 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Auxiliar") {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (175.39 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1416.91 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20210.82 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Oficial 2ª Administración") {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (221.62 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1463.14 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20765.62 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Oficial 1ª Administración") {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (231.22 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1472.74 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (20880.80 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Jefe administración, capataz") {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (266.61 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1508.13 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (21305.50 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Inspector principal") {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (347.50 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1589.02 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (22276.17 * multiplicadorHorasAnuales).toString()
            }
            if (seleccionadoCategoriaProfesional == "Encargado almacén, jefe de servicio") {
                salarioBase = (1069.30 * multiplicadorHorasAnuales).toString()
                plusTransporte = (172.22 * multiplicadorHorasAnuales).toString()
                plusConvenio = (432.96 * multiplicadorHorasAnuales).toString()
                retribucionConvenio = (1674.48 * multiplicadorHorasAnuales).toString()
                retribucionAnual = (23301.71 * multiplicadorHorasAnuales).toString()
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
        get() = ((retribucionAnualConAntiguedad / horasAnualesMaximas.toDouble()) * 1.25)

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
        get() = retribucionAnualConAntiguedad / horasAnualesMaximas.toDouble()

    // Hora extra
    val horaExtraRedondeada
        get() = (retribucionAnualConAntiguedad / horasAnualesMaximas.toDouble()) * 1.25


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
        get() = (retribucionAnualConAntiguedad / horasAnualesMaximas.toDouble()) * 8

    // Atrasos y subida

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
