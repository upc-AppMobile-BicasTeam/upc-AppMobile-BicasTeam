package pe.edu.upc.movigestionscreens.presentation.Register

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
fun RegisterGerenteScreen(onRegisterClicked: (String, String, String, String) -> Unit, onAlreadyUserClicked: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var termsAccepted by remember { mutableStateOf(false) }

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

            // Nombre
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,  // Fondo blanco cuando está enfocado
                    unfocusedContainerColor = Color.White  // Fondo blanco cuando no está enfocado
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Usuario
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Usuario") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,  // Fondo blanco cuando está enfocado
                    unfocusedContainerColor = Color.White  // Fondo blanco cuando no está enfocado
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // DNI
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

            Spacer(modifier = Modifier.height(16.dp))

            // Contraseña
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,  // Fondo blanco cuando está enfocado
                    unfocusedContainerColor = Color.White  // Fondo blanco cuando no está enfocado
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Confirmar Contraseña
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("ConfirmarContraseña") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,  // Fondo blanco cuando está enfocado
                    unfocusedContainerColor = Color.White  // Fondo blanco cuando no está enfocado
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Checkbox para confirmar los términos
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Checkbox(
                    checked = termsAccepted,
                    onCheckedChange = { termsAccepted = it },
                    colors = CheckboxDefaults.colors(checkedColor = Color(0xFFFFA000))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Confirmar Terminos y Condiciones", fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón de registrarse
            Button(
                onClick = {
                    if (termsAccepted && password == confirmPassword) {
                        onRegisterClicked(name, username, dni, password)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000)),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "REGISTRARSE", fontWeight = FontWeight.Bold, color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Enlace para iniciar sesión
            Text(
                text = "¿Ya eres usuario? - Inicia Sesion",
                modifier = Modifier.clickable(onClick = onAlreadyUserClicked),
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterGerenteScreenPreview() {
    MoviGestionScreensTheme {
        RegisterGerenteScreen(
            onRegisterClicked = { _, _, _, _ -> },
            onAlreadyUserClicked = { }
        )
    }
}
