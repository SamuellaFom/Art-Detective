package fr.esgi.artdetective.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val ArtDetectiveColorScheme = darkColorScheme(
    primary = GoldPrimary,
    onPrimary = TextOnAccent,
    primaryContainer = GoldContainer,
    onPrimaryContainer = GoldPrimary,

    secondary = IndigoSecondary,
    onSecondary = TextPrimary,
    secondaryContainer = IndigoContainer,
    onSecondaryContainer = TextPrimary,

    background = BackgroundDark,
    onBackground = TextPrimary,
    surface = SurfaceDark,
    onSurface = TextPrimary,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = TextSecondary,
    surfaceContainer = SurfaceDark,
    surfaceContainerHigh = SurfaceDark,
    surfaceContainerHighest = SurfaceVariantDark,
    outline = SurfaceVariantDark,

    error = ErrorRed,
    onError = TextPrimary,
)

@Composable
fun ArtDetectiveTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = ArtDetectiveColorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
