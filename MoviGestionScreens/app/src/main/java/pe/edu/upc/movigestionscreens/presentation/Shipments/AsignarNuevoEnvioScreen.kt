package pe.edu.upc.movigestionscreens.presentation.Shipments


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
fun AsignarNuevoEnvioScreen(
    onAsignarEnvioClicked: (String, String, String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
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
            Icon(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "Menu",
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.Start)
            )

            // Título "ENVIOS"
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "ENVIOS",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Imagen de perfil
            Image(
                painter = painterResource(id = R.drawable.ic_perfil), // Coloca la imagen adecuada
                contentDescription = "Profile Icon",
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto para el nombre
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,  // Fondo blanco cuando está enfocado
                    unfocusedContainerColor = Color.White,  // Fondo blanco cuando no está enfocado
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto para el destino
            OutlinedTextField(
                value = destination,
                onValueChange = { destination = it },
                label = { Text("Destiny") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,  // Fondo blanco cuando está enfocado
                    unfocusedContainerColor = Color.White,  // Fondo blanco cuando no está enfocado
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto para la descripción
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,  // Fondo blanco cuando está enfocado
                    unfocusedContainerColor = Color.White,  // Fondo blanco cuando no está enfocado
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botón "Asignar nuevo envío"
            Button(
                onClick = { onAsignarEnvioClicked(name, destination, description) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000)),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "Asignar Envio", fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AsignarNuevoEnvioScreenPreview() {
    MoviGestionScreensTheme {
        AsignarNuevoEnvioScreen { _, _, _ -> /* Acción al asignar envío */ }
    }
}
