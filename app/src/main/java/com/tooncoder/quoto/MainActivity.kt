package com.tooncoder.quoto

import SignInSignUpScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tooncoder.quoto.ui.theme.QuotoTheme
import com.tooncoder.quoto.ui.theme.auth.OnboardingFlow
import com.tooncoder.quoto.ui.theme.auth.onboardingItems
import com.tooncoder.quoto.ui.theme.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotoApp()
        }
    }
}

@Composable
fun QuotoApp() {
    QuotoTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "onboarding") {
            composable("onboarding") { OnboardingScreen(navController) }
            composable("signup") { ToSignUpScreen(navController) }
            composable("home") { ToHomeScreen(navController) }
        }
    }
}

@Composable
fun OnboardingScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        OnboardingFlow(
            items = onboardingItems,
            onboardingFinished = {
                navController.navigate("signup") // Navigate to home screen
            }
        )
    }
}


@Composable
fun ToSignUpScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        SignInSignUpScreen(navController)
    }
}

@Composable
fun ToHomeScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        HomeScreen(navController)
    }
}
