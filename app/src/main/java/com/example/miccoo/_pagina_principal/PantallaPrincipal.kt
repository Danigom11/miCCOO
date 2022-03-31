package com.example.miccoo._pagina_principal

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.miccoo.BarraSuperiorMiCCOO
import com.example.miccoo.ui.theme.MiCCOOTheme

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun PaginaPrincipal(navController: NavController) {
    MiCCOOTheme {
        Scaffold(
            backgroundColor = Color.Transparent,
            modifier = Modifier
                .padding(8.dp),
            topBar = {
                BarraSuperiorMiCCOO()
            },
            content = {
                TarjetasPaginaPrincipal(
                    navController = navController,
                    listaContenido = listaContenidoTarjetasPantallaPrincipal
                )
            },
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun TarjetasPaginaPrincipal(
    navController: NavController,
    listaContenido: List<DataClassContenidoTarjetasPaginaPrincipal>
) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(listaContenido) { dataClassContenidoTarjetasPrincipal ->
            TarjetaModeloPantallaPrincipal(
                navController = navController,
                dataClassContenidoTarjetasPrincipal
            )
        }
    }
}

@SuppressLint("UnusedTransitionTargetStateParameter")
@ExperimentalMaterialApi
@Composable
fun TarjetaModeloPantallaPrincipal(
    navController: NavController,
    dataClassContenidoPrincipal: DataClassContenidoTarjetasPaginaPrincipal
) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            )
            .clickable {
                navController.navigate(dataClassContenidoPrincipal.navegar) {
                    popUpTo(Screens.PANTALLAPRINCIPAL.ruta)
                }
            },
        shape = RoundedCornerShape(10.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.padding(all = 8.dp),
            ) {
                Image(
                    painter = painterResource(id = dataClassContenidoPrincipal.imagen),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(
                            shape = RoundedCornerShape(20.dp)
                        )
                        .border(
                            1.5.dp,
                            MaterialTheme.colors.secondaryVariant,
                            RoundedCornerShape(20.dp)
                        )
                )
                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier
                        .weight(6f)
                        .height(90.dp)
                ) {
                    Text(
                        dataClassContenidoPrincipal.permisoRetribuido,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(1.0f)
                            .padding(top = 16.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(
                            dataClassContenidoPrincipal.explicacion,
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier
                                .weight(1.0f)
                                .padding(top = 2.dp),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
