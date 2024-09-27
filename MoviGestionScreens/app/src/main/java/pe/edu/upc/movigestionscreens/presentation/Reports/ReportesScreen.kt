package pe.edu.upc.movigestionscreens.presentation.Reports

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.movigestionscreens.R
import pe.edu.upc.movigestionscreens.ui.theme.MoviGestionScreensTheme

@Composable
fun ReportesScreen(reportList: List<ReporteItem>,onBackClicked: () -> Unit) {

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

            // Título "REPORTES"
            Text(
                text = "REPORTES",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Listado de reportes
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(reportList) { report ->
                    ReportCard(report)
                }
            }
        }
    }
}

@Composable
fun ReportCard(report: ReporteItem) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFE0E0E0),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen de usuario
            Icon(
                painter = painterResource(id = R.drawable.ic_perfil),
                contentDescription = "Profile Icon",
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            // Información del reporte
            Column {
                Text(text = "Name: ${report.name}", fontWeight = FontWeight.Bold)
                Text(text = "Tipo: ${report.tipo}", fontWeight = FontWeight.Light)
                Text(text = "Descripción: ${report.descripcion}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReportesScreenPreview() {
    MoviGestionScreensTheme {
        val sampleReports = listOf(
            ReporteItem("John Doe", "Tipo A", "Descripción: Lorem ipsum..."),
            ReporteItem("Jane Doe", "Tipo B", "Descripción: Dolor sit amet..."),
            ReporteItem("Jake Smith", "Tipo C", "Descripción: Consectetur adipiscing...")
        )
        ReportesScreen(reportList = sampleReports, onBackClicked = {  })
    }
}

data class ReporteItem(val name: String, val tipo: String, val descripcion: String)
