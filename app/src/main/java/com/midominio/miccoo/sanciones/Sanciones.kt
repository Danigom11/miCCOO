package com.midominio.miccoo.sanciones

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.midominio.miccoo.BarraSuperiorMiCCOO
import com.midominio.miccoo.ui.theme.MiCCOOTheme
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun Sanciones() {
    val tabs = listOf(
        TabItem.Leve,
        TabItem.Grave,
        TabItem.MuyGrave
    )
    val pagerState = rememberPagerState()
    MiCCOOTheme {
        Scaffold(
            backgroundColor = Color.Transparent,
            modifier = Modifier
                .padding(8.dp),
            topBar = {
                BarraSuperiorMiCCOO()
            },
            content = {
                Column {
                    Tabs(tabs = tabs, pagerState = pagerState)
                    TabsContent(tabs = tabs, pagerState = pagerState)
                }
            },
        )
    }
}

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }) {
        tabs.forEachIndexed { index, tab ->
            Tab(

                text = { Text(tab.title, color = MaterialTheme.colors.onPrimary) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen()
    }
}

@ExperimentalAnimationApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SancionesPreview() {
    Sanciones()
}

