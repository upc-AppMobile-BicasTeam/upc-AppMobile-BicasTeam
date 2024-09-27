package pe.edu.upc.movigestionscreens.presentation.Menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.upc.movigestionscreens.R
import pe.edu.upc.movigestionscreens.ui.theme.MoviGestionScreensTheme

@Composable
fun GerenteMenuScreen(
    onPerfilClicked: () -> Unit,
    onReportesClicked: () -> Unit,
    onVehiculosClicked: () -> Unit,
    onEnviosClicked: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Menu Icono de hamburguesa
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_menu), // Icono de menú hamburguesa
                    contentDescription = "Menu",
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Logo
            Image(
                painter = painterResource(id = R.drawable.login_logo), // Asegúrate de tener el recurso de la imagen
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Opción Perfil
            MenuOption(
                iconRes = R.drawable.ic_perfil, // Asegúrate de tener el recurso de icono de perfil
                label = "PERFIL",
                onClick = onPerfilClicked
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Opción Reportes
            MenuOption(
                iconRes = R.drawable.ic_reportes, // Asegúrate de tener el recurso de icono de reportes
                label = "REPORTES",
                onClick = onReportesClicked
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Opción Vehículos
            MenuOption(
                iconRes = R.drawable.ic_vehiculos, // Asegúrate de tener el recurso de icono de vehículos
                label = "VEHÍCULOS",
                onClick = onVehiculosClicked
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Opción Envíos
            MenuOption(
                iconRes = R.drawable.ic_envios, // Asegúrate de tener el recurso de icono de envíos
                label = "ENVIOS",
                onClick = onEnviosClicked
            )
        }
    }
}

@Composable
fun MenuOption(iconRes: Int, label: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = label,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GerenteMenuScreenPreview() {
    MoviGestionScreensTheme {
        GerenteMenuScreen(
            onPerfilClicked = { },
            onReportesClicked = { },
            onVehiculosClicked = { },
            onEnviosClicked = { }
        )
    }
}
