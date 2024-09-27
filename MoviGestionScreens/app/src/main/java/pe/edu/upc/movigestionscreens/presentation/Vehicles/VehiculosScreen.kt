package pe.edu.upc.movigestionscreens.presentation.Vehicles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.movigestionscreens.R
import pe.edu.upc.movigestionscreens.ui.theme.MoviGestionScreensTheme

@Composable
fun VehiculosScreen(
    vehicles: List<Vehicle>, // Lista de vehículos a mostrar
    onEliminarClicked: () -> Unit,
    onNuevoVehiculoClicked: () -> Unit,
    onBackClicked: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Menú Icono
            IconButton(
                onClick = { onBackClicked() },
                modifier = Modifier.align(Alignment.Start)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = "Menu",
                    modifier = Modifier.size(32.dp)
                )
            }

            // Título "VEHICULOS"
            Text(
                text = "VEHICULOS",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Listado de vehículos
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(16.dp)
            ) {
                vehicles.forEach { vehicle ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .height(80.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Card(
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier.fillMaxSize(),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFD3D3D3) // Fondo gris claro
                            )
                        ) {
                            Row(
                                modifier = Modifier.padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Icono de vehículo
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_vehiculos),
                                    contentDescription = "Vehículo",
                                    modifier = Modifier.size(48.dp)
                                )
                                Spacer(modifier = Modifier.width(16.dp))

                                // Información del vehículo
                                Column {
                                    Text(text = "Modelo: ${vehicle.model}", fontWeight = FontWeight.Bold)
                                    Text(text = "Placa: ${vehicle.placa}")
                                    Text(text = "Asignado a: ${vehicle.asignado}")
                                }
                            }
                        }
                    }
                }
            }

            // Botón "Eliminar Vehículo"
            Button(
                onClick = onEliminarClicked,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000)),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "Eliminar Vehiculo", fontWeight = FontWeight.Bold, color = Color.White)
            }

            // Botón "Agregar nuevo Vehículo"
            Button(
                onClick = onNuevoVehiculoClicked,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000)),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "Agregar nuevo Vehiculo", fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun VehiculosScreenPreview() {
    val exampleVehicles = listOf(
        Vehicle(placa = "ABC-123", model = "Toyota Corolla", asignado = "Juan Perez"),
        Vehicle(placa = "XYZ-987", model = "Honda Civic", asignado = "Maria Lopez")
    )

    MoviGestionScreensTheme {
        VehiculosScreen(
            vehicles = exampleVehicles,
            onEliminarClicked = { /* Acción de eliminar vehículo */ },
            onNuevoVehiculoClicked = { /* Acción para agregar nuevo vehículo */ },
            onBackClicked = { /* Acción de volver atrás */ }
        )
    }
}

data class Vehicle(val placa: String, val model: String, val asignado: String)

