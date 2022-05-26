package com.midominio.miccoo.tests

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


// Crear clase que controla lista con preguntas y respuestas falsas y verdaderas y resultado final con comentarios animadores y explicación
// Crear variable para respuestas falsas
// Crear variable para respuestas verdaderas.
// Variable para explicación
// Variable con comentarios cuando fallas que sean aleatorios.
// Variable con comentarios cuando aciertas que sea aleatorio.
// Variable para controlar una pista. Efecto destrucción de una de las respuestas falsas aleatoriamente.
// Variable para acumular resultados guardados.
// Crear interfaz visual.
// Pantalla bienvenida con explicación que solo se muestra una vez.
// Pantalla principal donde se muestran los resultados anteriores, rachas, premios por conseguir objetivos...
// Pantalla controla el comienzo del test.
// Crear variable para controlar el número de pregunta en el que te encuentras.
// Pantalla resultado final.
// Variables para visualizar los resultados.
// Variable para comentario final. Con >< poner un comentario distinto según el resultado obtenido del uno al diez.
// Volver.

class ViewModelTests : ViewModel() {
    val listaTests = listOf(
        pregunta1,
        pregunta2,
        pregunta3,
        pregunta4,
        pregunta5,
        pregunta6
    )

    val opcionElegida = mutableStateOf(listaTests.first())

    val randomPregunta = listaTests.random()


}