package com.example.material_design.MaterialDesign

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
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
            modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Choose language ")
            option.forEach { option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)

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
        TextField(value = "",
            onValueChange = {},
            placeholder = { Text(text = "Enter your name") },
            modifier = Modifier.constrainAs(text1) {

            })
        TextField(value = "",
            onValueChange = {},
            placeholder = { Text(text = "Enter your name") },
            modifier = Modifier.constrainAs(text2) {
                top.linkTo(text1.bottom)
            })


        // Check box

    }

}

@Composable
fun TestCheck() {
    val notification = remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Enable Notification")
        Checkbox(checked = notification.value, onCheckedChange = { notification.value = it })
        Text(text = if (notification.value) "Notifications Enabled" else "Notifications Disabled")
    }
}

@Composable
fun DropDown() {
    var expanded = remember {
        mutableStateOf(false)
    }
    var selectedOption = remember {
        mutableStateOf("Select an option ")

    }
    val option = listOf("option1", "option2", "option3", "option4")
    OutlinedButton(onClick = { expanded.value = true }, modifier = Modifier.fillMaxWidth()) {
        Text(text = "selectedOption")
    }
    DropdownMenu(expanded = expanded.value, onDismissRequest = { expanded.value = false }) {
        option.forEach { option ->
            DropdownMenuItem(text = { Text(text = option) }, onClick = {
                selectedOption.value = option
                expanded.value = false
            })
        }
    }
}

@Composable
fun MyAlertDialog(shouldShowDialog: MutableState<Boolean>) {
    if (shouldShowDialog.value) {
        AlertDialog(onDismissRequest = { shouldShowDialog.value = false },
            title = { Text(text = "Alert dialog", color = Color.Blue) },
            confirmButton = {
                Button(onClick = { shouldShowDialog.value = false }) {
                    Text(
                        text = "Confirm", color = Color.White
                    )
                }
            })
    }
}

@Composable
fun MainScreen(

) {
    Row(modifier = Modifier.padding(50.dp)) {
        val shouldShowDialog = remember { mutableStateOf(false) }
        if (shouldShowDialog.value) {
            MyAlertDialog(shouldShowDialog = shouldShowDialog)
        }
        Button(onClick = { shouldShowDialog.value = true }, modifier = Modifier.wrapContentSize()) {
            Text(text = "Show Dialog")
        }
    }

}
