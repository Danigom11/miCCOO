package com.example.miccoo.sanciones

import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit


sealed class TabItem(var title: String, var screen: ComposableFun) {
    object Leve : TabItem("LEVE", { PrimeraPantalla() })
    object Grave : TabItem("GRAVE", { SegundaPantalla() })
    object MuyGrave : TabItem("MUY GRAVE", { TerceraPantalla() })
}

