package com.example.material_design.Grid.LazyVerticalGrid

import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun LazyVerticalGrid() {
    val items = List(2) { "Items #$it" }
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(16.dp)) {
        items(items) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.primary),
                color = Color.White
            )
        }

    }
    ColoredGrid()
}

@Composable
fun ColoredGrid() {
    val items = List(150) { "#$it" }
    val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Magenta, Color.Cyan)
    LazyVerticalGrid(columns = GridCells.Fixed(5), modifier = Modifier.padding(16.dp)) {
        items(items) { items ->
            val color = colors[items.hashCode() % colors.size]
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .background(color)
                    .fillMaxSize()
            ) {
                Text(text = items
               , style = TextStyle(color=Color.White, fontSize = 18.sp)
                    , modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}