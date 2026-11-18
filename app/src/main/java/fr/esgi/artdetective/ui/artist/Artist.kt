package fr.esgi.artdetective.ui.artist

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ArtistScreen(artistId: Int, onBack: () -> Unit) {
    Text("Artist $artistId")
    Button(onClick = onBack) {
        Text("Back")
    }
}