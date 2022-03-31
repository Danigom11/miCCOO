package com.example.miccoo

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.miccoo._pagina_principal.PaginaPrincipal
import com.example.miccoo._pagina_principal.Screens
import com.example.miccoo.ipc.Ipc
import com.example.miccoo.ipc.ViewModelIpc
import com.example.miccoo.nomina_completa.NominaCompleta
import com.example.miccoo.nomina_completa.ViewModelNominaCompleta
import com.example.miccoo.nomina_datos_generales.Nomina
import com.example.miccoo.nomina_datos_generales.ViewModelNomina
import com.example.miccoo.nomina_datos_generales.conceptos_otros.conceptos_explicados.*
import com.example.miccoo.permisos_retribuidos.PermisosRetribuidos
import com.example.miccoo.sanciones.Sanciones
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun SetupNavGraph(
    navController: NavController,
    viewModelNomina: ViewModelNomina,
    viewModelNominaCompleta: ViewModelNominaCompleta,
    viewModelIpc: ViewModelIpc
) {

    AnimatedNavHost(
        navController = navController as NavHostController,
        startDestination = Screens.PANTALLAPRINCIPAL.ruta,
    ) {
        //Definir rutas de las pantallas
        //Pantalla inicial
        composable(
            route = Screens.PANTALLAPRINCIPAL.ruta,

            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -300 },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },

            ) {
            PaginaPrincipal(navController = navController)
        }
        //Pantalla permisos retribuidos
        composable(Screens.PERMISOSRETRIBUIDOS.ruta) {
            PermisosRetribuidos()
        }
        //Pantalla calculos
        composable(Screens.NOMINACOMPLETA.ruta) {
            NominaCompleta(viewModelNominaCompleta = viewModelNominaCompleta)
        }
        //Pantalla calculos
        composable(Screens.NOMINA.ruta) {
            Nomina(navController = navController, viewModelNomina = viewModelNomina)
        }
        //Pantalla ipc
        composable(Screens.IPC.ruta) {
            Ipc(viewModelIpc = viewModelIpc)
        }
        //Pantalla sanciones
        composable(Screens.SANCIONES.ruta) {
            Sanciones()
        }
        //Pantallas explicaciones conceptos
        //Pantalla hora ordinaria
        composable(Screens.HORAORDINARIA.ruta) {
            HoraOrdinaria(viewModelNomina = viewModelNomina)
        }
        //Pantalla hora extra
        composable(Screens.HORAEXTRA.ruta) {
            HoraExtra(viewModelNomina = viewModelNomina)
        }
        //Pantalla hora festiva
        composable(Screens.HORAFESTIVA.ruta) {
            HoraFestiva(viewModelNomina = viewModelNomina)
        }
        //Pantalla nocturnidad
        composable(Screens.NOCTURNIDAD.ruta) {
            Nocturnidad(viewModelNomina = viewModelNomina)
        }
        //Pantalla antigüedad
        composable(Screens.ANTIGUEDAD.ruta) {
            Antiguedad(viewModelNomina = viewModelNomina)
        }
        //Pantalla despido improcedente
        composable(Screens.DESPIDO.ruta) {
            IndemnizacionDespido(viewModelNomina = viewModelNomina)
        }
        //Pantalla huelga
        composable(Screens.HUELGA.ruta) {
            Huelga(viewModelNomina = viewModelNomina)
        }
        //Pantalla sanción
        composable(Screens.SANCION.ruta) {
            Sancion(viewModelNomina = viewModelNomina)
        }
    }
}