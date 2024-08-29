package com.example.material_design.Grid.LazyVerticalGrid

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.material_design.R


@Composable
fun Flag() {
    val flags =
        listOf(
            R.drawable.cambodia,
            R.drawable.loas,
            R.drawable.vietnames,
            R.drawable.brune,
            R.drawable.indonesia,
            R.drawable.malaysia,
            R.drawable.myanmar,
        )
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Flag Of Asian ", modifier = Modifier.padding(15.dp),
            fontSize = 30.sp, color = Color.Blue
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(15.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
            , modifier = Modifier.height(400.dp)
        ) {
            items(flags) { flag ->
                Box(modifier = Modifier.padding(15.dp).fillMaxWidth().aspectRatio(1f)) {
                    Image(
                        painter = painterResource(id = flag),
                        contentDescription = "flag",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun MyGrid() {
    var clickedButtonName by remember { mutableStateOf<String?>(null) }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "LazyVerticalGrid", modifier = Modifier.padding(15.dp),
            fontSize = 30.sp, color = Color.Blue
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(15.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),//
            verticalArrangement = Arrangement.spacedBy(8.dp)//Top-bottom
        ) {
            items(10) { index ->
                val buttonName = "$index"
                Button(
                    onClick = { clickedButtonName = buttonName },
                    colors = ButtonDefaults.buttonColors(
                        containerColor =
                        if (index == 5) Color.Blue
                        else ButtonDefaults.buttonColors().containerColor
                    )
                ) {
                    Text(text = buttonName, fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(), // Make sure Row fills the width
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = clickedButtonName.let { "$it" },
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }
    }

}
