package com.midominio.miccoo.nomina_conceptos.conceptos_otros.conceptos_explicados


import android.icu.text.NumberFormat
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.midominio.miccoo.BarraSuperior
import com.midominio.miccoo.ViewModelNomina
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun HoraFestiva(viewModelNomina: ViewModelNomina) {
    val numeroAMoneda = NumberFormat.getCurrencyInstance()
    Scaffold(
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .padding(8.dp),
        topBar = {
            BarraSuperior()
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        text = "Hora festiva",
                        textAlign = TextAlign.Center,
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.size(3.dp))
                    Text(
                        text = "¿Cómo se calcula?",
                        textAlign = TextAlign.Center,
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.size(3.dp))
                    Text(
                        text = "Actualmente no está regulada por convenio.\n Si no hay un acuerdo en tu centro de trabajo se paga como una hora extra",
                        textAlign = TextAlign.Center,
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    Row {
                        Card(
                            elevation = 4.dp,
                            border = BorderStroke(1.dp, Color.Red),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .padding(6.dp)
                                .size(140.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(4.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Hora\nordinaria",
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.size(3.dp))
                                Text(
                                    text = numeroAMoneda.format(viewModelNomina.horaOrdinariaRedondeada),
                                    fontSize = 20.sp
                                )
                            }
                        }
                        Text(
                            text = "X",
                            fontSize = 30.sp,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(20.dp)
                        )
                        Card(
                            elevation = 4.dp,
                            border = BorderStroke(1.dp, Color.Blue),
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .padding(6.dp)
                                .size(140.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(4.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Multiplicador",
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Center,
                                    overflow = TextOverflow.Clip,
                                    modifier = Modifier.padding(3.dp)
                                )
                                Spacer(modifier = Modifier.size(3.dp))
                                Text(
                                    text = "1,25",
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.size(16.dp))

                    Card(
                        elevation = 4.dp,
                        border = BorderStroke(1.dp, Color.Green),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .padding(6.dp)
                            .size(140.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(4.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Resultado",
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.size(3.dp))
                            Text(text = "=", textAlign = TextAlign.Center)
                            Spacer(modifier = Modifier.size(3.dp))
                            Text(
                                text = numeroAMoneda.format(viewModelNomina.horaExtraRedondeada),
                                fontSize = 20.sp
                            )

                        }
                    }
                }
            }
        }
    )
}
