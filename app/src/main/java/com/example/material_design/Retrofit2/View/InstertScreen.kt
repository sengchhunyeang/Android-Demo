import android.annotation.SuppressLint
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.material_design.Retorfit.ViewModel.ViewModel
import com.example.material_design.Retrofit2.Model.ArticleRequest
import com.example.material_design.Retrofit2.Route.Screen
import java.time.LocalDate

@SuppressLint("InvalidColorHexValue")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsertArticleScreen(navController: NavHostController, viewModel: ViewModel) {
    val context = LocalContext.current
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var author by remember { mutableStateOf("") }
    var publishedDate by remember { mutableStateOf(LocalDate.now().toString()) }
    var views by remember { mutableStateOf(0) }
    var isPublished by remember { mutableStateOf(true) }

    // Image picker launcher
    val imagePickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri = uri
        }

    // Function to launch image picker
    val selectImage = {
        imagePickerLauncher.launch("image/*")
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFBF00))
        ) {
            Text(
                text = "Form Input Article ",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.ListScreen.route)
                    }
                    .padding(20.dp)
                    .align(Alignment.Center)

            )
        }
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title", modifier = Modifier) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFFFBF00),
                focusedTextColor = Color.Black
            )
        )
        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Content") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFFFBF00),
                focusedTextColor = Color.Black
            )
        )

        OutlinedTextField(
            value = author,
            onValueChange = { author = it },
            label = { Text("Author") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFFFBF00),
                focusedTextColor = Color.Black
            )
        )
        OutlinedTextField(
            value = publishedDate,
            onValueChange = { publishedDate = it },
            label = { Text("Published Date") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFFFBF00),
                focusedTextColor = Color.Black
            )
        )

        Button(
            onClick = { selectImage() },
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.Start),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFBF00)
            )
        ) {

            Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "Localized description")
            Text(text = if (imageUri != null) "Change Image" else "Upload Image")
        }

        imageUri?.let { uri ->
            Text(
                text = "Selected Image",
                color = Color.Green,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Published")
            Switch(
                checked = isPublished,
                onCheckedChange = { isPublished = it }
            )
        }
        Button(
            onClick = {
                val article = ArticleRequest(
                    title = title,
                    content = content,
                    imageUrl = imageUri?.toString() ?: "",
                    author = author,
                    publishedDate = publishedDate,
                    views = views,
                    isPublished = isPublished
                )
                viewModel.createArticle(
                    article = article,
                    onSuccess = {
                        Toast.makeText(
                            context,
                            "Article created successfully",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    },
                    onFailure = { errorMessage ->
                        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                    }
                )
                navController.navigate(Screen.ListScreen.route)
            },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xFFFFBF00)
            )
        ) {
            Text("Create Article")
        }
    }
}

