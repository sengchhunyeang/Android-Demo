package com.example.material_design.Grid

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


@Composable
fun GridLayOut() {
    val data = listOf("☕️", "🙂", "🥛", "🎉", "📐", "🎯", "🧩", "😄", "🥑")
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), contentPadding = PaddingValues(8.dp)
    ) {
        items(data) { item ->
            Card(
                modifier = Modifier.padding(4.dp), colors = CardDefaults.cardColors(
                    containerColor = Color(
                        red = Random.nextInt(0, 255),
                        green = Random.nextInt(0, 255),
                        blue = Random.nextInt(0, 255)
                    )
                )
            ) {
                Text(
                    text = item,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(24.dp)
                )

            }
        }
    }
}