package pe.edu.upc.movigestionscreens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.movigestionscreens.presentation.Login.LoginScreen
import pe.edu.upc.movigestionscreens.presentation.Register.RegisterUserScreen
import pe.edu.upc.movigestionscreens.presentation.Menu.GerenteMenuScreen
import pe.edu.upc.movigestionscreens.presentation.Profile.PerfilScreen
import pe.edu.upc.movigestionscreens.presentation.Register.RegisterGerenteScreen
import pe.edu.upc.movigestionscreens.presentation.Reports.ReportesScreen
import pe.edu.upc.movigestionscreens.presentation.Shipments.EnvioScreen
import pe.edu.upc.movigestionscreens.presentation.Vehicles.CrearNuevoVehiculoScreen
import pe.edu.upc.movigestionscreens.presentation.Vehicles.Vehicle
import pe.edu.upc.movigestionscreens.presentation.Vehicles.VehiculosScreen
import pe.edu.upc.movigestionscreens.ui.theme.MoviGestionScreensTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviGestionScreensTheme {
                // Crear NavController
                val navController = rememberNavController()

                // Crear NavHost para manejar las rutas
                AppNavigation(navController = navController)
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    val vehiclesList = remember { mutableStateListOf<Vehicle>() } // Lista mutable de vehículos

    NavHost(navController = navController, startDestination = "login") {
        // Pantalla de Login
        composable("login") {
            LoginScreen(
                onLoginClicked = { username, password ->
                    navController.navigate("menu")
                },
                onRegisterClicked = {
                    navController.navigate("register")
                }
            )
        }

        // Pantalla de Registro de Usuarios
        composable("register") {
            RegisterUserScreen(
                onNextClicked = { selectedRole ->
                    when (selectedRole) {
                        "Gerente" -> navController.navigate("registerGerente")
                        "Transportista" -> {
                            // Lógica adicional para transportista
                        }
                    }
                },
                onOptionSelected = { role ->
                    // Manejo de selección de rol
                }
            )
        }

        // Pantalla de Registro del Gerente
        composable("registerGerente") {
            RegisterGerenteScreen(
                onRegisterClicked = { name, username, dni, password ->
                    navController.navigate("menu")
                },
                onAlreadyUserClicked = {
                    navController.navigate("login")
                }
            )
        }

        // Pantalla de Menú
        composable("menu") {
            GerenteMenuScreen(
                onPerfilClicked = { navController.navigate("perfil") },
                onReportesClicked = { navController.navigate("reportes") },
                onVehiculosClicked = { navController.navigate("vehiculos") },
                onEnviosClicked = { navController.navigate("envios") }
            )
        }

        // Pantalla de Perfil
        composable("perfil") {
            PerfilScreen(
                onUpdateClicked = { nombre, dni -> },
                onBackClicked = { navController.navigate("menu") }
            )
        }

        // Pantalla de Reportes
        composable("reportes") {
            ReportesScreen(
                reportList = listOf(),  // Lista de reportes vacía por ahora
                onBackClicked = { navController.navigate("menu") }
            )
        }

        // Pantalla de Vehículos (sin duplicado)
        composable("vehiculos") {
            VehiculosScreen(
                vehicles = vehiclesList,  // Pasamos la lista mutable de vehículos
                onEliminarClicked = { /* Lógica para eliminar vehículo */ },
                onNuevoVehiculoClicked = { navController.navigate("crearNuevoVehiculo") },
                onBackClicked = { navController.navigate("menu") }
            )
        }

        // Pantalla para crear un nuevo vehículo
        composable("crearNuevoVehiculo") {
            CrearNuevoVehiculoScreen(
                onCrearVehiculoClicked = { placa, modelo, asignado ->
                    vehiclesList.add(Vehicle(placa, modelo, asignado))  // Agrega el nuevo vehículo
                    navController.navigate("vehiculos")  // Vuelve a la pantalla de vehículos
                },
                onBackClicked = { navController.navigate("vehiculos") }
            )
        }

        // Pantalla de Envíos
        composable("envios") {
            EnvioScreen(
                shipments = listOf(),  // Lista de envíos vacía por ahora
                onDeleteClicked = { /* Lógica para eliminar envío */ },
                onNewShipmentClicked = { /* Lógica para agregar nuevo envío */ },
                onBackClicked = { navController.navigate("menu") }
            )
        }
    }
}

