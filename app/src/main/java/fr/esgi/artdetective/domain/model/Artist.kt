package fr.esgi.artdetective.domain.model

data class Artist(
    val id: Int,
    val fullName: String,
    val birthDeathYears: String,
    val origin: String,
    val shortBio: String
)
