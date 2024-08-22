package com.github.aliftrd.jetupacto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.aliftrd.jetupacto.presentation.about.AboutScreen
import com.github.aliftrd.jetupacto.presentation.detail.DetailScreen
import com.github.aliftrd.jetupacto.presentation.home.HomeScreen
import com.github.aliftrd.jetupacto.ui.theme.JetupactoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetupactoTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Home.route) {
                    composable(Screen.Home.route) {
                        HomeScreen(navController = navController)
                    }
                    composable(Screen.Detail.route) {
                        DetailScreen(navController = navController)
                    }
                    composable(Screen.About.route) {
                        AboutScreen(navController = navController)
                    }
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Detail : Screen("detail")
    data object About : Screen("about")
}