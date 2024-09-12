package com.example.material_design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
            }
        }
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "list_screen") {
        composable(Screen.ListScreen.route) {
            ListScreen(navController = navController, viewModel = ViewModel())
        }
    }
}

@Composable
fun Route(){
    val navController = rememberNavController()
    NavGraph(navController = navController)
}
