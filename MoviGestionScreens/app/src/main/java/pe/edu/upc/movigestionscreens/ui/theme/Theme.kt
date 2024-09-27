package pe.edu.upc.movigestionscreens.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryColor,
    background = BackgroundColor // Color oscuro para el fondo
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    background = BackgroundColor // Puedes cambiarlo si deseas otro color en modo claro
)

@Composable
fun MoviGestionScreensTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
