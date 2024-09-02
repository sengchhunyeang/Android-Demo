import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import java.security.AccessController

@Composable
fun MainNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        navigation(startDestination = "profile", route = "profile_graph") {
            composable("profile") {
                ProfileScreen(navController)
            }
            composable("profile/details") { ProfileDetailsScreen(navController) }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Row(modifier = Modifier) {

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Magenta)
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Home Screen", modifier = Modifier.align(Alignment.Center), color = Color.White, fontSize = 30.sp
                )
            }
            Button(
                onClick = { navController.navigate("profile") },
                modifier = Modifier.padding(top = 14.dp)
            ) {
                Text(text = "Go to profile")
            }
        }
        
    }
}

@Composable
fun ProfileScreen(navController: NavHostController) {
    Row(modifier = Modifier) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Green)
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Profile",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontSize = 30.sp
                )
            }
            Button(onClick = { navController.navigate("profile/details") }) {
                Text(text = "view Details")
            }
        }

    }
}

@Composable
fun ProfileDetailsScreen(navController: NavHostController) {
    Row(modifier = Modifier) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Blue)
                    .padding(20.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)

            ) {
                Text(
                    text = "Profile details",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontSize = 30.sp


                )
            }
            Button(onClick = { navController.navigate("home") }) {
                Text(text = "Back")
            }
        }

    }
}

@Composable
fun NestedNavigation() {
    MainNavGraph()
}
