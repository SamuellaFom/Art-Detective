package fr.esgi.artdetective.domain.model

data class Artwork(
    val id: Int,
    val title: String,
    val artistName: String,
    val year: String,
    val style: String,
    val imageUrl: String,
    val isUnlocked: Boolean = false,
    val isFavorite: Boolean = false
)
