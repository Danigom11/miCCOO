package com.midominio.miccoo._pagina_principal

sealed class Screens(val ruta: String) {
    object PANTALLAINICIO : Screens("PantallaInicio")
    object PANTALLAPRINCIPAL : Screens("PantallaPrincipal")
    object PERMISOSRETRIBUIDOS : Screens("PermisosRetribuidos")
    object NOMINACOMPLETA : Screens("NominaCompleta")
    object NOMINA : Screens("Calculos")
    object IPC : Screens("Ipc")
    object SANCIONES : Screens("Sanciones")
    object HORAORDINARIA : Screens("1HoraOrdinaria")
    object HORAEXTRA : Screens("2HoraExtra")
    object HORAFESTIVA : Screens("3HoraFestiva")
    object NOCTURNIDAD : Screens("4Nocturnidad")
    object ANTIGUEDAD : Screens("5Antiguedad")
    object DESPIDO : Screens("6Despido")
    object HUELGA : Screens("7Huelga")
    object SANCION : Screens("8Sancion")
    object DOCUMENTOS : Screens("Documentos")
    //object TESTS : Screens("Tests")
}
