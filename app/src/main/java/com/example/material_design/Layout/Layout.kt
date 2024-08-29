package com.example.material_design.Layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.movableContentOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.material_design.R

@Composable
fun Avatar() {
    Box(
        modifier = Modifier
            .padding(60.dp)
            .border(border = BorderStroke(1.dp, color = Color.Red))
            .fillMaxWidth()
            .background(color = Color.White)
            .size(200.dp), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.korean), contentDescription = "",
            modifier = Modifier.size(600.dp)
        )
//        Icon(
//            Icons.Filled.CheckCircle,
//            contentDescription = "",
//            modifier = Modifier.padding(top = 50.dp, start = 50.dp).size(30.dp)
//        )
    }
}