package me.zairacelis.unabshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                val navController = rememberNavController()
                val startDestination = "Login"
                NavHost(
                    navController = navController,
                    startDestination = startDestination,
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable(route = "Login") {
                        LoginScreen(onClickRegister = {
                            navController.navigate("register")
                        }, onSuccessfulLogin = {
                            navController.navigate("home"){
                                popUpTo("Login"){inclusive=true}
                            }
                        }

                        )
                    }
                    composable (route = "register") {
                        RegisterScreen(onClickBack = {
                            navController.popBackStack()
                        }
                        )
                    }
                    composable (route = "home") {
                        HomeScreen()
                    }
                }
            }

        }
    }
