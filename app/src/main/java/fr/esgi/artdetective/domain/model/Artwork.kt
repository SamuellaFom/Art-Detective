package fr.esgi.artdetective.domain.model

data class Artwork(
    val id: Int,
    val title: String,
    val artistId: Int,
    val artistName: String,
    val year: String,
    val style: String,
    val country: String,
    val imageUrl: String,
)