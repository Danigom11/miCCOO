package com.midominio.miccoo._pagina_principal

import com.midominio.miccoo.R


val listaContenidoTarjetasPantallaPrincipal: List<DataClassContenidoTarjetasPaginaPrincipal> =
    listOf(
        DataClassContenidoTarjetasPaginaPrincipal(
            Screens.NOMINACOMPLETA.ruta,
            R.drawable.nomina_completa,
            "Calcula tu nómina",
            "Comprueba si tú nómina es correcta"
        ),
        DataClassContenidoTarjetasPaginaPrincipal(
            Screens.NOMINA.ruta,
            R.drawable.nomina_buscar,
            "Conceptos nómina",
            "Horas extras, antigüedad..."
        ),
        DataClassContenidoTarjetasPaginaPrincipal(
            Screens.IPC.ruta,
            R.drawable.ipc,
            "Subida salario",
            "Atrasos y subida mensual"
        ),
        DataClassContenidoTarjetasPaginaPrincipal(
            Screens.PERMISOSRETRIBUIDOS.ruta,
            R.drawable.permisos_retribuidos,
            "Permisos Retribuidos",
            "Conoce tus derechos"
        ),
        DataClassContenidoTarjetasPaginaPrincipal(
            Screens.SANCIONES.ruta,
            R.drawable.sanciones,
            "Sanciones",
            "Leves, graves o muy graves"
        )
    )