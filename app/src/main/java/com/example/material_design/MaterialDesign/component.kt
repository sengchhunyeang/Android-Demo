package com.example.material_design.MaterialDesign

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun TextExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = "This is useful for designing beautiful UI designs",
            color = Color.Blue,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
        )
    }
}

// Component Material
@Composable
fun AllButton() {

    Row(modifier = Modifier.padding(50.dp)) {
        Button(onClick = {}) {
            Text(text = "Button")
        }
        FilledTonalButton(onClick = {}) {
            Text(text = "FilledTonalButton")
        }

    }
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
//        ElevatedButton(onClick = { /*TODO*/ }) {
//            Text(text = "ElevateButton")
//        }
//        OutlinedButton(onClick = { /*TODO*/ }) {
//            Text(text = "OutlineButton")
//        }
//        TextButton(onClick = { /*TODO*/ }) {
//            Text(text = "TextButton")
//        }

        val option = listOf("Java", "Kotlin", "Spring")
        var selectOption = remember { mutableStateOf(option[2]) }
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Choose language ")
            option.forEach { option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(vertical = 8.dp)

                ) {
                    RadioButton(
                        selected = selectOption.value == option,
                        onClick = { selectOption.value = option },

                        )
                    Text(text = option, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }
    }


}

@Composable
fun ComponentTesting() {
    ConstraintLayout(
        modifier = Modifier
            .background(Color.Red)
            .size(500.dp)

    ) {
        val (text1, text2) = createRefs()
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Enter your name") },
            modifier = Modifier
                .constrainAs(text1) {

                }
        )
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Enter your name") },
            modifier = Modifier
                .constrainAs(text2) {
                    top.linkTo(text1.bottom)
                }
        )


    }
}
