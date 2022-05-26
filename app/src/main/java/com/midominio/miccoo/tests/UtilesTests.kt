package com.midominio.miccoo.tests

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.midominio.miccoo.nomina_calculadora.RadioBotonEtiquetado

@Composable
fun RadioBotonEtiquetadoTests(
    modifier: Modifier = Modifier,
    etiqueta: String,
    selecionado: Boolean,
    onClick: (() -> Unit)?,
    enabled: Boolean = true
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selecionado,
            onClick = onClick,
            enabled = enabled,
            colors = RadioButtonDefaults.colors(selectedColor = Color.Red)
        )

        Text(
            text = etiqueta,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.body1.merge(),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun RadioGrupoBotonesTests(
    modifier: Modifier,
    items: List<String>,
    seleccion: String,
    onItemClick: ((String) -> Unit)
) {
    Column(modifier = modifier) {
        items.forEach { item ->
            RadioBotonEtiquetado(
                modifier = Modifier.fillMaxWidth(),
                etiqueta = item,
                selecionado = item == seleccion,
                onClick = {
                    onItemClick(item)
                }
            )
        }
    }
}