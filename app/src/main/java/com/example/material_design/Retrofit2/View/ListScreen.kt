package com.example.material_design.Retrofit2.View


//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.Image
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.material_design.Retorfit.Model.ArticleResponse
import com.example.material_design.Retorfit.ViewModel.ViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import coil.compose.rememberAsyncImagePainter

import coil.compose.rememberImagePainter
@Composable
fun ListScreen(viewModel: ViewModel) {
    val articles by viewModel.articles.observeAsState(emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(articles) { article ->
            ArticleItem(article)
        }
    }
}

@Composable
fun ArticleItem(article: ArticleResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Display article image
        article.imageUrl?.let {
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Display article title
        Text(text = "Name : ${article.title}", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(4.dp))

        // Display article content
        Text(text = "Content : ${article.content}", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(4.dp))

        // Display article author
        Text(text = "Author: ${article.author}", style = MaterialTheme.typography.bodySmall)

        Spacer(modifier = Modifier.height(4.dp))

        // Display article published date
        Text(text = "Published Date: ${article.publishedDate}", style = MaterialTheme.typography.bodySmall)

        Spacer(modifier = Modifier.height(4.dp))

        // Display article views
        Text(text = "Views: ${article.views}", style = MaterialTheme.typography.bodySmall)

        // Display article ID
        Text(text = "ID: ${article.id}", style = MaterialTheme.typography.bodySmall)

        Spacer(modifier = Modifier.height(4.dp))

        // Display article published status
        Text(
            text = "Published: ${if (article.isPublished) "Yes" else "No"}",
            style = MaterialTheme.typography.bodySmall
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp))
    }
}



