package com.midominio.miccoo

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.midominio.miccoo.ui.theme.MiCCOOTheme


@ExperimentalAnimationApi
@Composable
fun BarraSuperior() {
    var openDialog by remember { mutableStateOf(false) }
    MiCCOOTheme {
        TopAppBar(
            contentPadding = PaddingValues(8.dp),
            backgroundColor = Color.Transparent,
            elevation = 0.dp
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    contentScale = ContentScale.FillHeight,
                    painter = painterResource(R.drawable.punomiccoo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier
                        .weight(6f)
                ) {
                    Text(
                        text = "miCCOO",
                        modifier = Modifier
                            .padding(start = 10.dp),
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colors.onPrimary

                    )
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(
                            text = "Tu asistente sindical.",
                            modifier = Modifier
                                .padding(start = 10.dp),
                            fontSize = MaterialTheme.typography.button.fontSize,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                }
                OutlinedButton(
                    border = BorderStroke(1.dp, Color.Red),
                    onClick = {
                        openDialog = true
                    },
                    modifier = Modifier


                ) {
                    Text(text = "+INFO", color = MaterialTheme.colors.onPrimary)
                }
                if (openDialog) {
                    AlertDialog(
                        onDismissRequest = { openDialog = false },
                        title = { Text(text = "+Info", color = MaterialTheme.colors.onPrimary) },
                        text = {

                            Text(
                                text = "IMPORTANTE:\n\n" +
                                        " - Información válida solo para convenio de Guadalajara.\n\n" +
                                        " - Es posible que existan acuerdos en tu centro de trabajo que modifiquen algo.\n\n" +
                                        " - Si tienes alguna pregunta acude a tú comité de empresa o a tú sindicato.",
                                fontSize = 20.sp,
                                color = MaterialTheme.colors.onPrimary
                            )

                        },


                        confirmButton = {
                        },

                        dismissButton = {
                            OutlinedButton(
                                border = BorderStroke(1.dp, MaterialTheme.colors.onPrimary),
                                onClick = {
                                    openDialog = false
                                },

                                ) {
                                Text(text = "Volver", color = MaterialTheme.colors.onPrimary)
                            }
                        }
                    )
                }
            }
        }
    }
}