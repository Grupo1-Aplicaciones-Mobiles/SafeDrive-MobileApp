package com.example.mobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.example.mobileapp.features.vehicles.common.Constants
import com.example.mobileapp.features.vehicles.data.remote.VehicleService
import com.example.mobileapp.features.vehicles.data.repository.VehicleRepository
import com.example.mobileapp.features.vehicles.presentation.vehicleDetail.AddVehicleScreen
import com.example.mobileapp.features.vehicles.presentation.vehicleDetail.VehicleDetailViewModel
import com.example.mobileapp.features.vehicles.presentation.vehicleList.VehicleListScreen
import com.example.mobileapp.features.vehicles.presentation.vehicleList.VehicleListViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobileapp.ui.theme.MobileAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobileapp.common.TopLevelRoute
import com.example.mobileapp.presentation.edit_profile.EditProfileScreen
import com.example.mobileapp.presentation.login.LoginScreen
import com.example.mobileapp.presentation.register.RegisterScreen
import kotlinx.serialization.Serializable

@Serializable
object Login {
    const val route = "login"
}

@Serializable
object Register {
    const val route = "register"
}

@Serializable
object Edit_Profile {
    const val route = "edit_profile"
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val topLevelRoutes = listOf(
            TopLevelRoute("Inicio", Login.route, Icons.Filled.Home),
            TopLevelRoute("Rastreo", Register.route, Icons.Filled.LocationOn),
            TopLevelRoute("Avisos", Edit_Profile.route, Icons.Filled.Warning),
            TopLevelRoute("Cuenta", Edit_Profile.route, Icons.Filled.Person),

        )

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileAppTheme    {
                val navController = rememberNavController()
                val selectedRoute = remember {
                    mutableStateOf(0)
                }

                Scaffold(bottomBar = {
                    BottomNavigation(
                        backgroundColor = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.navigationBarsPadding()
                    ) {
                        topLevelRoutes.forEachIndexed { index, topLevelRoute ->
                            BottomNavigationItem(
                                selected = (index == selectedRoute.value),
                                label = {
                                    Text(
                                        topLevelRoute.name,
                                        color = if (index == selectedRoute.value) MaterialTheme.colors.primary
                                        else Color.Gray
                                    )
                                },
                                icon = {
                                    Icon(
                                        topLevelRoute.icon,
                                        topLevelRoute.name,
                                        tint = if (index == selectedRoute.value) MaterialTheme.colors.primary
                                        else Color.Gray
                                    )
                                },
                                onClick = {
                                    navController.navigate(topLevelRoute.route){
                                        launchSingleTop = true
                                    }
                                    selectedRoute.value = index
                                },
                            )
                        }
                    }
                }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Edit_Profile.route,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable(Edit_Profile.route) { EditProfileScreen() }  // Definir la ruta correctamente
                        composable(Login.route) { LoginScreen() }
                        composable(Register.route) { RegisterScreen() }

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileAppTheme {

    }
}