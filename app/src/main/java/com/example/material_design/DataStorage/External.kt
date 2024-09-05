package com.example.material_design.DataStorage

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Environment
import android.util.Log
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
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.FileOutputStream
import java.io.FileInputStream
import java.io.BufferedReader
import java.io.InputStreamReader

fun writeDataToExternalStorage(context: Context, filename: String, data: String) {
    if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
        val file = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), filename)
        FileOutputStream(file).use { outputStream ->
            outputStream.write(data.toByteArray())
        }
    } else {
        Log.e("Storage", "Write permission not granted")
    }
}
fun readFromExternalStorage(context: Context, filename: String): String {
    val file = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), filename)
    return if (file.exists()) {
        FileInputStream(file).use { inputStream ->
            BufferedReader(InputStreamReader(inputStream)).use { reader ->
                reader.readText()
            }
        }
    } else {
        "File does not exist"
    }
}

@Composable
fun ExternalStorage() {
    val context = LocalContext.current
    var text by remember { mutableStateOf("No Data") }
    LaunchedEffect(Unit) {
        val filename = "file.txt"
        writeDataToExternalStorage(context, filename, "Hello text from compose")
        text = readFromExternalStorage(context, filename)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Data from External Storage")
        Text(text = text)
    }
}

@Composable
fun ExternalStorageExample() {
    val context = LocalContext.current
    var writeMessage by remember { mutableStateOf("Write data to external storage") }
    var readMessage by remember { mutableStateOf("Read data from external storage") }
    val fileName = "myExternalFile.txt"
    Column(modifier = Modifier.padding(16.dp)) {
        // Button to write data to external storage
        Button(onClick = {
            writeDataToExternalStorage(context, fileName, "Hello, Jetpack Compose!")
            writeMessage = "Data written to $fileName"
        }) {
            Text("Write to External Storage")
        }
        Text(text = writeMessage)
        // Button to read data from external storage
        Button(onClick = {
            readMessage = readFromExternalStorage(context, fileName)
        }) {
            Text("Read from External Storage")
        }
        Text(text = readMessage)
    }
}
