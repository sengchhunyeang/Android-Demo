package com.example.material_design

import InsertArticleScreen
import UpdateArticleScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.material_design.Retorfit.Model.ArticleResponse
import com.example.material_design.Retorfit.ViewModel.ViewModel
import com.example.material_design.Retrofit2.Route.Screen
import com.example.material_design.Retrofit2.View.ListScreen
import com.example.material_design.ui.theme.Material_DesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Material_DesignTheme {
//                ConstraintLayoutDemo()
//                Flexible()
//                TextExample()
//               ConstraintAs()
//                ComponentTesting()
//                AllButton()
//                TestCheck()
//                MainScreen()
//                WrappedButton()
//                GridLayOut()
//                LazyVerticalGrid()
//                MyGrid()
//                Flag()
//                Avatar()
//                SmallTopAppBarExample()
//                NestedNavigation()
//                InternalStorage()
//                InternalStorageExample()
//                ExternalStorageExample()
//                Homescreen()
//                ArticleListScreen(userVm = viewModel())
//                InsertArticleScreen(viewModel= ViewModel())
//                ListScreen(viewModel= ViewModel())
//
                Route()
//                PreviewUpdateArticleScreen()
            }
        }
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "list_screen") {
        composable(Screen.ListScreen.route) {
            ListScreen(navController = navController, viewModel = viewModel())
        }
        composable(Screen.InputArticle.route) {
            InsertArticleScreen(navController = navController, viewModel = viewModel())
        }
    }
}



@Composable
fun Route(){
    val navController = rememberNavController()
    NavGraph(navController = navController)
}

@Composable
fun PreviewUpdateArticleScreen() {
    val navController = rememberNavController()
    val viewModel = remember { ViewModel() } // Replace with actual ViewModel provider or mock

    // Mock ArticleResponse
    val article = ArticleResponse(
        id = 256,
        title = "Sample Title",
        content = "Sample Content",
        imageUrl = "http://example.com/image.jpg",
        author = "Author Name",
        publishedDate = "2024-09-13",
        views = 100,
        isPublished = true
    )
    UpdateArticleScreen(
        viewModel = viewModel,
        article = article,
        navController = navController
    )
}