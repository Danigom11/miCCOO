package com.midominio.miccoo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.midominio.miccoo.nomina_completa.ViewModelNominaCompleta
import com.midominio.miccoo.nomina_datos_generales.ViewModelNomina
import com.midominio.miccoo.subidaSalario.ViewModelIpc
import com.midominio.miccoo.ui.theme.MiCCOOTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val viewModelNomina by viewModels<ViewModelNomina>()
    private val viewModelNominaCompleta by viewModels<ViewModelNominaCompleta>()
    private val viewModelIpc by viewModels<ViewModelIpc>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiCCOOTheme {
                navController = rememberAnimatedNavController()

                SetupNavGraph(
                    navController = navController,
                    viewModelNomina,
                    viewModelNominaCompleta,
                    viewModelIpc
                )
            }
        }
    }
}