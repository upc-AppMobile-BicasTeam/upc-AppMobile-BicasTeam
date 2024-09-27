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
fun CrearNuevoVehiculoScreen(
    onCrearVehiculoClicked: (String, String, String) -> Unit,
    onBackClicked: () -> Unit
) {
    var placa by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var asignado by remember { mutableStateOf("") }
    val isFormValid = remember(placa, modelo, asignado) {
        placa.isNotBlank() && modelo.isNotBlank() && asignado.isNotBlank()
    }

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
            // Icono de menú para retroceder
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

            // Imagen de vehículo
            Image(
                painter = painterResource(id = R.drawable.ic_vehiculos),
                contentDescription = "Vehículo",
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo Placa
            OutlinedTextField(
                value = placa,
                onValueChange = { placa = it },
                label = { Text("Placa") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo Modelo
            OutlinedTextField(
                value = modelo,
                onValueChange = { modelo = it },
                label = { Text("Modelo") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo Asignado a
            OutlinedTextField(
                value = asignado,
                onValueChange = { asignado = it },
                label = { Text("Asignado a") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botón Crear Nuevo Vehículo
            Button(
                onClick = {
                    onCrearVehiculoClicked(placa, modelo, asignado)
                },
                enabled = isFormValid, // Habilitar solo si el formulario es válido
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000)),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "Agregar Vehiculo", fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CrearNuevoVehiculoScreenPreview() {
    MoviGestionScreensTheme {
        CrearNuevoVehiculoScreen(
            onCrearVehiculoClicked = { placa, modelo, asignado ->
                // Aquí puedes simular el comportamiento al agregar un nuevo vehículo
            },
            onBackClicked = {
                // Simular la acción de volver
            }
        )
    }
}




