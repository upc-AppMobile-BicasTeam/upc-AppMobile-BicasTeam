package pe.edu.upc.movigestionscreens.presentation.Register

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
import pe.edu.upc.movigestionscreens.ui.theme.MoviGestionScreensTheme
import pe.edu.upc.movigestionscreens.R

@Composable
fun RegisterUserScreen(onNextClicked: (String) -> Unit, onOptionSelected: (String) -> Unit) {
    var selectedRole by remember { mutableStateOf("") }

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
            verticalArrangement = Arrangement.Center
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.login_logo), // Asegúrate de tener el recurso de la imagen
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botón para "Gerente"
            Button(
                onClick = {
                    selectedRole = "Gerente"
                    onOptionSelected(selectedRole)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedRole == "Gerente") Color.Gray else Color.White
                )
            ) {
                Text(text = "GERENTE", fontWeight = FontWeight.Bold, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para "Transportista"
            Button(
                onClick = {
                    selectedRole = "Transportista"
                    onOptionSelected(selectedRole)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedRole == "Transportista") Color.Gray else Color.White
                )
            ) {
                Text(text = "TRANSPORTISTA", fontWeight = FontWeight.Bold, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón de "Siguiente"
            Button(
                onClick = {
                    if (selectedRole.isNotEmpty()) {
                        onNextClicked(selectedRole)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                enabled = selectedRole.isNotEmpty(), // Habilitar solo si se ha seleccionado un rol
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedRole.isNotEmpty()) Color(0xFFFFA000) else Color.Gray
                ),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "Siguiente", fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterUserScreenPreview() {
    MoviGestionScreensTheme {
        RegisterUserScreen(
            onNextClicked = { /* Aquí puedes manejar la acción de "Siguiente" para la vista previa */ },
            onOptionSelected = { /* Aquí puedes manejar la selección de "Gerente" o "Transportista" */ }
        )
    }
}
