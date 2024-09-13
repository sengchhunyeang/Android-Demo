package com.example.material_design.Retrofit2.View


//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.material_design.Retorfit.Model.ArticleResponse
import com.example.material_design.Retorfit.ViewModel.ViewModel
import com.example.material_design.Retrofit2.Route.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavHostController, viewModel: ViewModel) {
    val articles by viewModel.articles.observeAsState(emptyList())
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFBF00),
                    titleContentColor = Color.Black,
                ),
                title = {
                    TextButton(onClick = { navController.navigate(Screen.InputArticle.route) }) {
                        Text(
                            text = "Input", fontSize = 20.sp, color = Color.Black
                        )
                    }

                }
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                items(articles) { article ->
                    ArticleItem(
                        article = article,
                        onDeleteClick = { articleId ->
                            viewModel.deleteArticle(articleId, onSuccess = {
                                Toast.makeText(
                                    context,
                                    "Article delete ",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }, onFailure = { error ->
                                Toast.makeText(
                                    context,
                                    "Error:$error",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            )
                        }, navController = navController
                    )
                }
            }
        }
    )
}

@SuppressLint("InvalidColorHexValue")
@Composable
fun ArticleItem(
    article: ArticleResponse,
    onDeleteClick: (Int) -> Unit,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Display article image
        Image(
            painter = rememberAsyncImagePainter(article.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Display article title
        Text(
            text = "Name: ${article.title}",
            modifier = Modifier,
            color = Color.Black, // Set text color to black
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Display article content
        Text(
            text = "Content: ${article.content}",
            color = Color.Black, // Set text color to black
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Display article author
        Text(
            text = "Author: ${article.author}",
            color = Color.Black, // Set text color to black
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Display article published date
        Text(
            text = "Published Date: ${article.publishedDate}",
            color = Color.Black, // Set text color to black
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Display article views
        Text(
            text = "Views: ${article.views}",
            color = Color.Black, // Set text color to black
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Display article ID
        Text(
            text = "ID: ${article.id}",
            color = Color.Black, // Set text color to black
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Display article published status
        Text(
            text = "Published: ${if (article.isPublished) "Yes" else "No"}",
            color = Color.Black, // Set text color to black
            style = MaterialTheme.typography.bodySmall
        )

        Button(
            onClick = { onDeleteClick(article.id) },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                Color(0xFFFF08080)
            )
        ) {
            Text(text = "Delete id ${article.id}")
        }
//        navController.navigate("update/${article.id}")
        Button(
            onClick = {  },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                Color(0xFFFFBF00)
            )
        ) {
            Text(text = "Update id ${article.id}")
        }
        Divider(modifier = Modifier.padding(vertical = 8.dp))

    }

}



