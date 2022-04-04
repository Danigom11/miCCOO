package com.example.miccoo.nomina_completa

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.ExperimentalCoroutinesApi

// Desplegable
// Switch
// Campo de texto
// Botón
// Texto título
// Texto concepto

@ExperimentalMaterialApi
@Composable
fun Desplegable(
    visible: Boolean,
    expandible: Boolean,
    expandibleCambia: (Boolean) -> Unit,
    seleccionado: String,
    seleccionadoCambia: (String) -> Unit,
    label: String,
    opciones: List<String>
) {
    val rotacion by animateFloatAsState(targetValue = if (expandible) 180F else 0F)
    AnimatedVisibility(visible = visible) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            ExposedDropdownMenuBox(
                expanded = expandible,
                onExpandedChange = {
                    expandibleCambia(it)
                }
            ) {
                Row {
                    TextField(
                        readOnly = true,
                        value = seleccionado,
                        onValueChange = {
                            seleccionadoCambia(it)
                        },
                        modifier = Modifier.border(
                            BorderStroke(
                                width = 4.dp,
                                brush = Brush.horizontalGradient(listOf(Color.Red, Color.Green))
                            ),
                            shape = RoundedCornerShape(50)
                        ),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        trailingIcon = {
                            IconButton(
                                modifier = Modifier
                                    .rotate(rotacion),
                                onClick = {
                                    expandibleCambia(true)
                                }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = null,
                                    tint = MaterialTheme.colors.onPrimary
                                )
                            }
                        },
                        label = {
                            Text(
                                label,
                                color = MaterialTheme.colors.onPrimary
                            )
                        },
                    )
                }
                ExposedDropdownMenu(
                    expanded = expandible,
                    onDismissRequest = {
                        expandibleCambia(false)
                    }
                ) {
                    opciones.forEach { selectionOption ->
                        DropdownMenuItem(
                            onClick = {
                                seleccionadoCambia(
                                    selectionOption
                                )
                                expandibleCambia(false)
                            }
                        ) {
                            Text(text = selectionOption, color = MaterialTheme.colors.onPrimary)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Switch(
    seleccionadoSwitch: Boolean,
    seleccionadoSwitchCambia: (Boolean) -> Unit
) {
    Column {
        Box(
            Modifier.fillMaxWidth()
        ) {
            Text(
                text = "NO",
                color = MaterialTheme.colors.onPrimary,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 110.dp)
            )
            Switch(
                checked = seleccionadoSwitch,
                onCheckedChange = { seleccionadoSwitchCambia(it) },
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Center)
            )
            Text(
                text = "SI",
                color = MaterialTheme.colors.onPrimary,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 120.dp)
            )
        }
        Spacer(modifier = Modifier.size(20.dp))
    }
}

@Composable
fun CampoDeTexto(
    visible: Boolean,
    conceptoElegido: String,
    conceptoElegidoCambia: (String) -> Unit,
    textoLabel: String
) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(visible = visible) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                TextField(
                    value = conceptoElegido,
                    onValueChange = { conceptoElegidoCambia(it) },
                    modifier = Modifier.border(
                        BorderStroke(
                            width = 4.dp,
                            brush = Brush.horizontalGradient(listOf(Color.Red, Color.Green))
                        ),
                        shape = RoundedCornerShape(50)
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    label = {
                        Text(
                            text = textoLabel,
                            color = MaterialTheme.colors.onPrimary
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
            }
        }
    }
}

@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun Boton(
    destino: Boolean,
    destinoCambia: (Boolean) -> Unit,
    texto: String,
    modifier: Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Box(contentAlignment = Alignment.BottomCenter) {
        OutlinedButton(
            onClick = {
                destinoCambia(!destino)
                keyboardController?.hide()
            },
            modifier = modifier,
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(width = 1.dp, color = Color.Red)
        ) {
            Text(
                text = texto, color = MaterialTheme.colors.onPrimary, fontSize = 20.sp
            )
        }
    }
}

@Composable
fun TextoTitulo(texto: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
    ) {
        Text(
            text = texto,
            fontSize = MaterialTheme.typography.h6.fontSize,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun TextoConcepto(texto: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = texto,
                color = MaterialTheme.colors.onPrimary,
                fontStyle = FontStyle.Italic,
                fontSize = 22.sp,
            )
            Divider(
                color = Color.LightGray,
                modifier = Modifier.padding(
                    start = 90.dp,
                    end = 90.dp,
                    top = 6.dp,
                    bottom = 6.dp
                )
            )
        }
    }
}