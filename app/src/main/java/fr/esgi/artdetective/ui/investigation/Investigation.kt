package fr.esgi.artdetective.ui.investigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun InvestigationScreen(artworkId: Int, onSolved: (Int) -> Unit, onBack: () -> Unit) {
    Column() {
        Text("Enquête n°\$artworkId")
        Button(onClick = { onSolved(artworkId) }) {
            Text("Valider")
        }
        Button(onClick = onBack) {
            Text("Back")
        }
    }
}