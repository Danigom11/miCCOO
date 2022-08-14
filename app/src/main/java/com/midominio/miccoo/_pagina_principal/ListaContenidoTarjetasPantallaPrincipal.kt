package com.midominio.miccoo._pagina_principal

import com.midominio.miccoo.R


val listaContenidoTarjetasPantallaPrincipal: List<DataClassContenidoTarjetasPaginaPrincipal> =
    listOf(
        DataClassContenidoTarjetasPaginaPrincipal(
            Screens.NOMINACOMPLETA.ruta,
            R.drawable.nomina_completa,
            "Nómina",
            "Comprueba si tú nómina está bien"
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
            "Atrasos y subida",
            "Comprueba cuanto te corresponde"
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
        ),
        DataClassContenidoTarjetasPaginaPrincipal(
            Screens.DOCUMENTOS.ruta,
            R.drawable.documentos,
            "Documentos",
            "Todo lo que puedas necesitar"
        )

        /*DataClassContenidoTarjetasPaginaPrincipal(
            Screens.TESTS.ruta,
            R.drawable.tests,
            "Tests",
            "¡Ponte a prueba!"
        )*/
    )