package com.example.material_design.Retorfit.View

//noinspection UsingMaterialAndMaterial3Libraries
import MainViewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ArticleListScreen(userVm: MainViewModel) {
    userVm.getPosts()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
//        items(userModel) { article ->
//            ArticleItem(article)
//        }
    }
}


//@Composable
//fun ArticleItem(article) {
//    LaunchedEffect(article) {
//        Log.d("ArticleItem", "Displaying article: ${article.title}")
//    }
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//    ) {
//        Text(text = article.title, style = MaterialTheme.typography.titleMedium)
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(text = article.content, style = MaterialTheme.typography.bodyMedium)
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(text = "Author: ${article.author}", style = MaterialTheme.typography.bodySmall)
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(
//            text = "Published Date: ${article.publishedDate}",
//            style = MaterialTheme.typography.bodySmall
//        )
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(text = "Views: ${article.views}", style = MaterialTheme.typography.bodySmall)
//        Divider(modifier = Modifier.padding(vertical = 8.dp))
//    }
//}
