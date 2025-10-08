package com.filkom.mycv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.filkom.mycv2.screen.*
import com.filkom.mycv2.ui.theme.Mycv2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mycv2Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            LoginScreen(
                onLoginClick = {
                    navController.navigate("detail/nim123/NamaUser/email@user.com/AlamatUser")
                },
                onDaftarClick = { navController.navigate("daftar") }
            )
        }

        composable("daftar") {
            DaftarScreen(
                onSimpanClick = { nim, nama, email, alamat ->
                    navController.navigate("detail/$nim/$nama/$email/$alamat")
                },
                onKembaliClick = { navController.navigate("login") }
            )
        }

        composable(
            "detail/{nim}/{nama}/{email}/{alamat}",
            arguments = listOf(
                navArgument("nim") { type = NavType.StringType },
                navArgument("nama") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("alamat") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: ""
            val nama = backStackEntry.arguments?.getString("nama") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""
            val alamat = backStackEntry.arguments?.getString("alamat") ?: ""

            DetailScreen(
                nim = nim,
                nama = nama,
                email = email,
                alamat = alamat,
                onDaftarClick = { navController.navigate("daftar") }
            )
        }
    }
}
