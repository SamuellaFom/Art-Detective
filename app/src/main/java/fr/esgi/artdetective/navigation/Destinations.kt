package fr.esgi.artdetective.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

object Destinations {
    const val HOME = "home"
    const val GALLERY = "gallery"
    const val FAVORITES = "favorites"
    const val INVESTIGATION = "investigation/{artworkId}"
    const val ARTIST = "artist/{artistId}"

    fun investigation(artworkId: Int) = "investigation/$artworkId"
    fun artist(artistId: Int) = "artist/$artistId"
}

enum class BottomTab(val route: String, val label: String, val icon: ImageVector) {
    HOME(Destinations.HOME, "Home", Icons.Default.Home),
    GALLERY(Destinations.GALLERY, "Galerie", Icons.Default.GridView),
    FAVORITES(Destinations.FAVORITES, "Favoris", Icons.Default.FavoriteBorder),
}
