package fr.esgi.artdetective.domain.model

data class Investigation(
    val artworkId: Int,
    val imageUrl: String,
    val hints: List<String>,
    val options: List<String>,
    val correctArtist: String
)
