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
import com.midominio.miccoo.subidaSalario.ViewModelSubidaSalario
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
    private val viewModelIpc by viewModels<ViewModelSubidaSalario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiCCOOTheme {
                navController = rememberAnimatedNavController()

                SetupNavGraph(
                    navController = navController,
                    viewModelNomina,
                    viewModelIpc
                )
            }
        }
    }
}