package fr.esgi.artdetective.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun ThemePreview() {
    ArtDetectiveTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text("Art Detective", style = MaterialTheme.typography.headlineLarge)
                Text("Texte secondaire", color = MaterialTheme.colorScheme.onSurfaceVariant)
                Button(onClick = {}) { Text("Commencer l'enquête") }
                OutlinedButton(onClick = {}) { Text("Retour") }
                Card { Text("Une carte", modifier = Modifier.padding(16.dp)) }

            }

        }
    }
}