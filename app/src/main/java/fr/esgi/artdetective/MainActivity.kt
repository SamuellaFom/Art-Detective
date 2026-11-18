package fr.esgi.artdetective

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import fr.esgi.artdetective.navigation.ArtDetectiveApp
import fr.esgi.artdetective.ui.theme.ArtDetectiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtDetectiveTheme {
                ArtDetectiveApp()
            }
        }
    }
}
