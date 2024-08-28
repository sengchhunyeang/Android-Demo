package com.example.material_design.ContraintLayout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintAs() {

    ConstraintLayout(
        modifier = Modifier
            .padding(50.dp)
            .fillMaxSize()
    ) {
        val (buttonA, buttonB, fill) = createRefs()
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(buttonA) {
                }
        ) {
            Text(text = "Button")

        }
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(buttonB) {
                    end.linkTo(parent.start)
                }
        ) {
            Text(text = "Button")
        }

    }
}