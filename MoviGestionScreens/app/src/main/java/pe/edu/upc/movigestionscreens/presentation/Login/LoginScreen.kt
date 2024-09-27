package pe.edu.upc.movigestionscreens.presentation.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.movigestionscreens.R
import pe.edu.upc.movigestionscreens.ui.theme.MoviGestionScreensTheme

@Composable
fun LoginScreen(
    onLoginClicked: (String, String) -> Unit,
    onRegisterClicked: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

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

            // Campo de texto para el nombre de usuario
            OutlinedTextField(
                value = username,
                onValueChange = {
                    username = it
                    showError = false // Reiniciar el error si el usuario empieza a escribir
                },
                label = { Text("Usuario", color = Color.Gray) },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                )
            )

            // Campo de texto para la contraseña
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    showError = false // Reiniciar el error si el usuario empieza a escribir
                },
                label = { Text("Contraseña", color = Color.Gray) },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Mostrar mensaje de error si faltan datos
            if (showError) {
                Text(
                    text = "Por favor ingresa un usuario y contraseña válidos",
                    color = Color.Red,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de login
            Button(
                onClick = {
                    if (username.isNotEmpty() && password.isNotEmpty()) {
                        onLoginClicked(username, password)
                    } else {
                        showError = true // Mostrar el mensaje de error
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000)),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "INGRESAR", fontWeight = FontWeight.Bold, color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Enlace para registrarse
            Text(
                text = "¿No tienes cuenta? - Regístrate",
                modifier = Modifier.clickable(onClick = onRegisterClicked),
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MoviGestionScreensTheme {
        LoginScreen(onLoginClicked = { _, _ -> }, onRegisterClicked = {})
    }
}
