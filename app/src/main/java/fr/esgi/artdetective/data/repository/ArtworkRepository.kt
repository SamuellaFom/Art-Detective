package fr.esgi.artdetective.data.repository

import fr.esgi.artdetective.domain.model.Artist
import fr.esgi.artdetective.domain.model.Artwork

interface ArtworkRepository {
    suspend fun getArtworks(page: Int = 1, query: String = "", style: String? = null): List<Artwork>
    suspend fun getArtwork(id: Int): Artwork?
    suspend fun getArtist(id: Int): Artist?
}