package com.example.material_design.DataStorage

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.DocumentsContract
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.startActivityForResult

// write f
fun writeDataToInternalStorage(context: Context, filename: String, data: String) {
    context.openFileOutput(filename, Context.MODE_PRIVATE).use { outputStream ->
        outputStream.write(data.toByteArray())
    }
}

fun readFromInternalStorage(context: Context, filename: String): String {
    context.openFileInput(filename).use { inputStream ->
        return inputStream.bufferedReader().use { reader ->
            reader.readText()
        }
    }
}

@Composable
fun InternalStorage() {

    val context = LocalContext.current
    var text by remember { mutableStateOf("No Data ") }
    LaunchedEffect(Unit) {
        val filename = "file.txt"
        writeDataToInternalStorage(context, filename, "Storage text Internal form compose")
        text = readFromInternalStorage(context, filename)
    }
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Data from Internal Storage ",
            modifier = Modifier
                .background(Color.Blue)
                .padding(15.dp),
            fontSize = 30.sp,
            color = Color.White
        )
        Text(text = text, modifier = Modifier.padding(15.dp), fontSize = 20.sp)
    }
}

