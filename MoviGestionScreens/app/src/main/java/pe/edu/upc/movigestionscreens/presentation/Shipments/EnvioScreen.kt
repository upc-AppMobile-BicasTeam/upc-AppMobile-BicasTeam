package pe.edu.upc.movigestionscreens.presentation.Shipments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

data class Shipment(val name: String, val destination: String, val description: String)

@Composable
fun EnvioScreen(
    shipments: List<Shipment>,
    onDeleteClicked: () -> Unit,
    onNewShipmentClicked: () -> Unit,
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
            // Título "ENVIOS"
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "ENVIOS",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de Envíos
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                items(shipments) { shipment ->
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_perfil),
                                contentDescription = "Profile Icon",
                                modifier = Modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(text = "Name: ${shipment.name}", fontWeight = FontWeight.Bold)
                                Text(text = "Destino: ${shipment.destination}")
                                Text(text = "Descripción: ${shipment.description}")
                            }
                        }
                    }
                }
            }

            // Botón "Eliminar Envío"
            Button(
                onClick = { onDeleteClicked() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000)),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "Eliminar Envio", fontWeight = FontWeight.Bold, color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón "Asignar nuevo envío"
            Button(
                onClick = { onNewShipmentClicked() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA000)),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "Asignar nuevo envio", fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EnvioScreenPreview() {
    MoviGestionScreensTheme {
        EnvioScreen(
            shipments = listOf(
                Shipment("Name", "Destino: JSM", "Descripción: Lorem"),
                Shipment("Name", "Destino: JSM", "Descripción: Lorem")
            ),
            onDeleteClicked = { /* Acción al eliminar */ },
            onNewShipmentClicked = { /* Acción al asignar nuevo envío */ },
            onBackClicked = {  }

        )
    }
}
