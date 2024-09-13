import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.material_design.Retorfit.Model.ArticleResponse
import com.example.material_design.Retorfit.ViewModel.ViewModel
import com.example.material_design.Retrofit2.Model.ArticleRequest
import com.example.material_design.Retrofit2.Route.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateArticleScreen(
    viewModel: ViewModel,
    article: ArticleResponse,
    navController: NavHostController
) {
    val context = LocalContext.current
    var title by remember { mutableStateOf(article.title) }
    var content by remember { mutableStateOf(article.content) }
    var imageUrl by remember { mutableStateOf(article.imageUrl) }
    var author by remember { mutableStateOf(article.author) }
    var publishedDate by remember { mutableStateOf(article.publishedDate) }
    var views by remember { mutableStateOf(article.views.toString()) }
    var isPublished by remember { mutableStateOf(article.isPublished) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFFFBF00)
            )
        )
        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Content") },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFFFBF00)
            )
        )
        OutlinedTextField(
            value = imageUrl,
            onValueChange = { imageUrl = it },
            label = { Text("Image URL") },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFFFBF00)
            )
        )
        OutlinedTextField(
            value = author,
            onValueChange = { author = it },
            label = { Text("Author") },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFFFBF00)
            )
        )
        OutlinedTextField(
            value = publishedDate,
            onValueChange = { publishedDate = it },
            label = { Text("Published Date") },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFFFBF00)
            )
        )

        Button(
            onClick = {
                val updatedArticle = ArticleRequest(
                    title = title,
                    content = content,
                    imageUrl = imageUrl,
                    author = author,
                    publishedDate = publishedDate,
                    views = views.toIntOrNull() ?: 0,
                    isPublished = isPublished
                )
                viewModel.updateArticle(
                    id = article.id,
                    article = updatedArticle,
                    onSuccess = {
                        Toast.makeText(context, "Article updated successfully", Toast.LENGTH_SHORT).show()
                        navController.navigate(Screen.ListScreen.route) // Navigate back after update
                    },
                    onFailure = { errorMessage ->
                        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                    }
                )
            },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFBF00)
            )
        ) {
            Text("Update Article")
        }
    }
}


