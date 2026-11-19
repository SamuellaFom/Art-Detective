package fr.esgi.artdetective.ui.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GalleryScreen(onOpenInvestigation: (Int) -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(all = 24.dp)) {
        Button(onClick = { onOpenInvestigation(2) }) {
            Text("Locked Work")
        }
    }
}