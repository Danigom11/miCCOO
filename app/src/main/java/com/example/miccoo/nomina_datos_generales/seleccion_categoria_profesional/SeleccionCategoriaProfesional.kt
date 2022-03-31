package com.example.miccoo.nomina_datos_generales.seleccion_categoria_profesional

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
import com.example.miccoo.nomina_completa.opcionesCategoriaProfesional
import com.example.miccoo.nomina_datos_generales.ViewModelNomina
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun SeleccionCategoriaProfesional(viewModelNomina: ViewModelNomina) {
    val expandido by viewModelNomina.expandir.collectAsState()
    val seleccionado by viewModelNomina.seleccionado.observeAsState()
    val rotacion by animateFloatAsState(targetValue = if (expandido) 180F else 0F)

    Column(Modifier.padding(top = 20.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Selecciona la categoria profesional",
                    color = MaterialTheme.colors.onPrimary, fontStyle = FontStyle.Italic
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
                    viewModelNomina.cambiarExpandir(!expandido)
                }
            ) {
                Row {
                    TextField(
                        readOnly = true,
                        value = seleccionado.toString(),
                        onValueChange = { viewModelNomina.seleccionadoCambia(it) },
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
                                    viewModelNomina.cambiarExpandir(true)
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
                                "Categoría profesional",
                                color = MaterialTheme.colors.onPrimary
                            )
                        },
                    )
                }
                ExposedDropdownMenu(
                    expanded = expandido,
                    onDismissRequest = {
                        viewModelNomina.cambiarExpandir(false)
                    }
                ) {
                    opcionesCategoriaProfesional.forEach { selectionOption ->
                        DropdownMenuItem(
                            onClick = {
                                viewModelNomina.seleccionadoCambia(selectionOption)
                                viewModelNomina.cambiarExpandir(false)
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