package com.midominio.miccoo.sanciones

import android.content.res.Configuration
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun PrimeraPantalla() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 32.dp)
            .verticalScroll(state = ScrollState(1))
    ) {
        Text(
            text = "Por faltas leves: Prescribe a los 10 días. Amonestación verbal o por escrito; suspensión de empleo y sueldo de hasta dos días.\n",
            color = MaterialTheme.colors.onPrimary,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )
        Divider(color = Color.Gray)
        Text(
            buildAnnotatedString {
                append("\n   1) Tres faltas de ")
                withStyle(SpanStyle(Color.Red)) {
                    append("puntualidad")
                }
                append(" en el trabajo, sin la debida justificación, cometidas en el período de un mes.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   2) No ")
                withStyle(SpanStyle(Color.Red)) {
                    append("notificar")
                }
                append(" por cualquier medio con carácter previo a la ")
                withStyle(SpanStyle(Color.Red)) {
                    append("ausencia,")
                }
                append(" pudiendo hacerlo, la imposibilidad de acudir al trabajo y su causa.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   3) El ")
                withStyle(SpanStyle(Color.Red)) {
                    append("abandono")
                }
                append(" del trabajo dentro de la jornada sin causa justificada, aunque sea por breve tiempo.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   4) Descuidos o negligencias en la conservación del ")
                withStyle(SpanStyle(Color.Red)) {
                    append("material.\n")
                }
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   5) La falta de ")
                withStyle(SpanStyle(Color.Red)) {
                    append("respeto y consideración")
                }
                append(" de carácter leve al personal de la empresa y al público, incluyendo entre las mismas las faltas de aseo y limpieza personal.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   6) La no utilización del ")
                withStyle(SpanStyle(Color.Red)) {
                    append("vestuario y equipo")
                }
                append(" que haya sido facilitado por la empresa con instrucciones de utilización.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   7) ")
                withStyle(SpanStyle(Color.Red)) {
                    append("Faltar")
                }
                append(" al trabajo un día sin causa justificada en el período de un mes.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PrimeraPantallaPreview() {
    PrimeraPantalla()
}

@Composable
fun SegundaPantalla() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 32.dp)
            .verticalScroll(state = ScrollState(1))
    ) {
        Text(
            text = "Por faltas graves: Prescribe a los 20 días. Suspensión de empleo y sueldo de 3 a 15 días; postergación para el ascenso hasta 3 años.\n",
            color = MaterialTheme.colors.onPrimary,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )
        Divider(color = Color.Gray)
        Text(
            buildAnnotatedString {
                append("\n   1) Más de tres faltas no justificadas de ")
                withStyle(SpanStyle(Color.Red)) {
                    append("puntualidad")
                }
                append(" en la asistencia al trabajo, cometidas durante el período de un mes.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   2) ")
                withStyle(SpanStyle(Color.Red)) {
                    append("Faltar")
                }
                append(" dos días al trabajo, durante un mes, sin causa justificada.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   3) Entregarse a ")
                withStyle(SpanStyle(Color.Red)) {
                    append("juegos,")
                }
                append(" cualesquiera que sean, dentro de la jornada de trabajo, si perturbasen el servicio.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   4) La ")
                withStyle(SpanStyle(Color.Red)) {
                    append("desobediencia")
                }
                append(" a las órdenes e instrucciones del empresario en cualquier materia de trabajo, incluido el control de asistencia, no dar cumplimiento a los trámites administrativos que sean presupuestos o consecuencia de la actividad que ha de realizar el trabajador.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   5) La alegación de ")
                withStyle(SpanStyle(Color.Red)) {
                    append("causas falsas")
                }
                append(" para las licencias.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   6) La reiterada ")
                withStyle(SpanStyle(Color.Red)) {
                    append("negligencia o desidia")
                }
                append(" en el trabajo que afecte a la buena marcha del mismo.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   7) Las ")
                withStyle(SpanStyle(Color.Red)) {
                    append("imprudencias o negligencias")
                }
                append(" en acto de servicio. En particular, se califica de imprudencia en acto de servicio el no uso de las prendas y equipos de seguridad de carácter obligatorio.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   8) Realizar sin permiso ")
                withStyle(SpanStyle(Color.Red)) {
                    append("trabajos particulares")
                }
                append(" durante la jornada, así como el empleo para usos propios del material de la empresa.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   9) Las faltas graves de ")
                withStyle(SpanStyle(Color.Red)) {
                    append("respeto y consideración")
                }
                append(" a quienes trabajan en la empresa, a los usuarios y al público, que constituyan infracción de los derechos constitucionalmente reconocidos a los mismos.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   10) El ")
                withStyle(SpanStyle(Color.Red)) {
                    append("abuso de autoridad")
                }
                append(" con ocasión del trabajo, considerándose tal la comisión de un hecho arbitrario siempre que concurran infracción manifiesta y deliberada de un precepto legal y perjuicio notorio para un inferior.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   11) No notificar por cualquier medio con carácter previo a la ausencia, pudiendo hacerlo, la imposibilidad de acudir al trabajo y su causa, siempre que la ")
                withStyle(SpanStyle(Color.Red)) {
                    append("falta de notificación previa")
                }
                append(" sea motivo de retraso en la salida de los vehículos o produzca cualquier trastorno en el normal desarrollo de la actividad.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   12) El ")
                withStyle(SpanStyle(Color.Red)) {
                    append("abandono")
                }
                append(" del trabajo dentro de la jornada sin causa justificada, aunque sea por breve tiempo, siempre que sea motivo de retraso en la salida de los vehículos o produzca cualquier trastorno en el normal desarrollo de la actividad.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   13) ")
                withStyle(SpanStyle(Color.Red)) {
                    append("Faltar al trabajo")
                }
                append(" un día sin causa justificada en el período de un mes, siempre que sea motivo de retraso en la salida de los vehículos o produzca cualquier trastorno en el normal desarrollo de la actividad.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   14) ")
                withStyle(SpanStyle(Color.Red)) {
                    append("Descuidos o negligencias")
                }
                append(" en la conservación del material de los que se deriven perjuicios para la empresa.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   15) La continuada y habitual falta de ")
                withStyle(SpanStyle(Color.Red)) {
                    append("aseo y limpieza")
                }
                append(", de tal índole que produzca quejas justificadas de sus compañeros de trabajo.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   16) La reiteración o ")
                withStyle(SpanStyle(Color.Red)) {
                    append("reincidencia")
                }
                append(" en falta leve (excluida la de puntualidad), aunque sean de distinta naturaleza, dentro de un trimestre y habiendo mediado sanción que no sea la de amonestación verbal; y cualquier otra de naturaleza análoga a las precedentes.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SegundaPantallaPreview() {
    SegundaPantalla()
}

@Composable
fun TerceraPantalla() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 32.dp)
            .verticalScroll(state = ScrollState(1))
        // .background(colorResource(id = R.color.primaryColor))
    ) {
        Text(
            text = "Por faltas muy graves: Prescribe a los 60 días. Suspensión de empleo y sueldo de 16 a 45 días; inhabilitación definitiva para el ascenso; despido.\n",
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center, color = MaterialTheme.colors.onPrimary
        )
        Divider(color = Color.Gray)
        Text(
            buildAnnotatedString {
                append("\n   1) Más de 10 faltas no justificadas de ")
                withStyle(SpanStyle(Color.Red)) {
                    append("puntualidad ")
                }
                append("cometidas en un período de seis meses o 20 durante un año.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   2) Las ")
                withStyle(SpanStyle(Color.Red)) {
                    append("faltas injustificadas")
                }
                append(" al trabajo durante 3 días consecutivos o 5 alternos en un período de seis meses, o 10 alternos durante un año.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   3) La ")
                withStyle(SpanStyle(Color.Red)) {
                    append("indisciplina o desobediencia")
                }
                append(" en el trabajo. Se calificará en todo caso como falta muy grave cuando implique quebranto de la disciplina o de ella se derive perjuicio para la empresa o compañeros de trabajo.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   4) Las ")
                withStyle(SpanStyle(Color.Red)) {
                    append("ofensas")
                }
                append(" verbales o físicas al empresario o a las personas que trabajan en la empresa o a los familiares que convivan con ellos.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   5) La trasgresión de la buena fe contractual, así como el abuso de confianza en el desempeño del trabajo, considerándose como tales el ")
                withStyle(SpanStyle(Color.Red)) {
                    append("fraude")
                }
                append(" o la deslealtad en las gestiones encomendadas; el ")
                withStyle(SpanStyle(Color.Red)) {
                    append("hurto o robo,")
                }
                append(" tanto a sus compañeros de trabajo como a la empresa o a cualquier persona, realizado dentro de las dependencias o vehículos de la misma, o en cualquier lugar si es en acto de servicio; violar el ")
                withStyle(SpanStyle(Color.Red)) {
                    append("secreto")
                }
                append(" de la correspondencia o revelar a extraños datos que se conozcan por razón del trabajo.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   6) La disminución continuada y voluntaria en el ")
                withStyle(SpanStyle(Color.Red)) {
                    append("rendimiento")
                }
                append(" del trabajo normal o pactado.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   7) La ")
                withStyle(SpanStyle(Color.Red)) {
                    append("embriaguez")
                }
                append(" habitual o ")
                withStyle(SpanStyle(Color.Red)) {
                    append("toxicomanía")
                }
                append(" si repercuten negativamente en el trabajo.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   8) El ")
                withStyle(SpanStyle(Color.Red)) {
                    append("abandono")
                }
                append(" del trabajo, aunque sea por breve tiempo, si fuera causa de accidente.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   9) La ")
                withStyle(SpanStyle(Color.Red)) {
                    append("imprudencia o negligencia")
                }
                append(" en acto de servicio si implicase riesgo de accidente o peligro de avería para la maquinaria, vehículo o instalaciones.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   10) El ")
                withStyle(SpanStyle(Color.Red)) {
                    append("acoso sexual")
                }
                append(" o el acoso por razón de sexo, desarrollados en el ámbito laboral y que atenten gravemente contra la dignidad del trabajador o trabajadora objeto de la misma.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   11) El ")
                withStyle(SpanStyle(Color.Red)) {
                    append("acoso laboral")
                }
                append(" (mobbing) que atente gravemente y de forma continuada contra la dignidad del trabajador afectado.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
        Text(
            buildAnnotatedString {
                append("   12) La ")
                withStyle(SpanStyle(Color.Red)) {
                    append("reincidencia")
                }
                append(" en faltas graves, aunque sean de distinta naturaleza, siempre que se cometan dentro de un trimestre y hayan sido sancionadas, y cualquier otra de naturaleza análoga a las precedentes.\n")
            }, color = MaterialTheme.colors.onPrimary
        )
    }
}


@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TerceraPantallaPreview() {
    TerceraPantalla()
}
