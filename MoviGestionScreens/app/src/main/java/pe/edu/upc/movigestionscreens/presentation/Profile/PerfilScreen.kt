package pe.edu.upc.movigestionscreens.presentation.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
fun PerfilScreen(onUpdateClicked: (String, String) -> Unit, onBackClicked: () -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }

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
        )

        {
            // Menú Icono (Placeholder para el menú desplegable)
            IconButton(
                onClick = { onBackClicked() },
                modifier = Modifier.align(Alignment.Start) // Alinea al inicio (costado izquierdo)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = "Menu",
                    modifier = Modifier.size(32.dp) // Ajusta el tamaño si es necesario
                )
            }

            // Imagen de perfil
            Spacer(modifier = Modifier.height(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_perfil),
                contentDescription = "Profile Icon",
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // Texto que indica el rol
            Text(
                text = "Gerente/Transportista",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Caja para editar nombre
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,  // Fondo blanco cuando está enfocado
                    unfocusedContainerColor = Color.White  // Fondo blanco cuando no está enfocado
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Caja para editar DNI
            OutlinedTextField(
                value = dni,
                onValueChange = { dni = it },
                label = { Text("DNI") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,  // Fondo blanco cuando está enfocado
                    unfocusedContainerColor = Color.White  // Fondo blanco cuando no está enfocado
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botón para actualizar datos
            Button(
                onClick = {
                    onUpdateClicked(nombre, dni)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000)),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "ACTUALIZAR DATOS", fontWeight = FontWeight.Bold, color = Color.White)
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Logo (Placeholder for company logo)
            Image(
                painter = painterResource(id = R.drawable.login_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PerfilScreenPreview() {
    MoviGestionScreensTheme {
        PerfilScreen(
            onUpdateClicked = { _, _ -> },
            onBackClicked = {  }
        )
    }
}
