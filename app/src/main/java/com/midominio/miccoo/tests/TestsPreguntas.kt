package com.midominio.miccoo.tests

data class TestsPreguntas(
    val pregunta: String,
    val respuestaCorrecta: String,
    val respuestaIncorrectaUno: String,
    val respuestaIncorrectaDos: String
)

val pregunta1 = TestsPreguntas(
    "¿Con cuánta antelación mínima tengo que pedir un día de asuntos propios?",
    "96 horas.",
    "72 horas.",
    "No hay mínimo, cuando quiera."
)

val pregunta2 = TestsPreguntas(
    "¿Cuántos días de asuntos propios retribuidos tengo?",
    "3",
    "2",
    "Todos los que necesite."
)

val pregunta3 = TestsPreguntas(
    "¿Cuántos días de asuntos propios retribuidos tengo?",
    "3",
    "2",
    "Todos los que necesite."
)

val pregunta4 = TestsPreguntas(
    "¿Puede la empresa denegarme un día de asuntos propios?",
    "Si.",
    "No.",
    "No lo sé."
)

val pregunta5 = TestsPreguntas(
    "¿Voy generando días de asuntos propios con el tiempo o tengo todos desde el primer día?",
    "Todos desde el primer día.",
    "Los genero poco a poco.",
    "Al cabo de 4 meses tengo derecho al primero. Antes no."
)

val pregunta6 = TestsPreguntas(
    "¿Qué pasa si termina el año y no he disfrutado de mis días de asuntos propios?",
    "Los pierdes.",
    "Se acumulan para el año siguiente.",
    "No puede ser, es obligatorio utilizarlos antes de que acabe el año."
)


