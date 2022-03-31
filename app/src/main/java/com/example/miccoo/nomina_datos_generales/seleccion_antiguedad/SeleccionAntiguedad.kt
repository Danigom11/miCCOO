package com.example.miccoo.nomina_datos_generales.seleccion_antiguedad

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.miccoo.nomina_datos_generales.ViewModelNomina
import kotlinx.coroutines.ExperimentalCoroutinesApi

val opcionesAntiguedad = listOf(
    "Sin antiguedad",
    "Un bienio (+2 años)",
    "Dos bienios (+4 años)",
    "Dos bienios y un quinquenios (+9 años)",
    "Dos bienios y dos quinquenios (+14 años)",
    "Dos bienios y tres quinquenios (+19 años)",
    "Dos bienios y cuatro quinquenios (+24 años)",
    "Dos bienios y cinco quinquenios (+29 años)"
)

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun SeleccionAntiguedad(viewModelNomina: ViewModelNomina) {
    val expandido by viewModelNomina.expandirAntiguedad.collectAsState()
    val seleccionado by viewModelNomina.seleccionadoAntiguedad.observeAsState()
    val rotacion by animateFloatAsState(targetValue = if (expandido) 180F else 0F)
    Column(
        Modifier.padding(top = 20.dp, bottom = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Selecciona la antigüedad",
                    color = MaterialTheme.colors.onPrimary,
                    fontStyle = FontStyle.Italic
                )
            }
        }
        Divider(
            color = Color.LightGray,
            modifier = Modifier.padding(
                start = 90.dp,
                end = 90.dp,
                top = 6.dp,
                bottom = 6.dp
            )
        )
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            ExposedDropdownMenuBox(
                expanded = expandido,
                onExpandedChange = {
                    viewModelNomina.cambiarExpandirAntiguedad(!expandido)
                },
            ) {
                Row {
                    TextField(
                        readOnly = true,
                        value = seleccionado.toString(),
                        onValueChange = { viewModelNomina.seleccionadoCambiaAntiguedad(it) },
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
                                    viewModelNomina.cambiarExpandirAntiguedad(true)
                                }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "Flecha expandir",
                                    tint = MaterialTheme.colors.onPrimary
                                )
                            }
                        },
                        label = {
                            Text(
                                "Antigüedad",
                                color = MaterialTheme.colors.onPrimary
                            )
                        },
                    )
                }
                ExposedDropdownMenu(
                    expanded = expandido,
                    onDismissRequest = {
                        viewModelNomina.cambiarExpandirAntiguedad(false)
                    }
                ) {
                    opcionesAntiguedad.forEach { selectionOption ->
                        DropdownMenuItem(
                            onClick = {
                                viewModelNomina.seleccionadoCambiaAntiguedad(selectionOption)
                                viewModelNomina.cambiarExpandirAntiguedad(false)
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