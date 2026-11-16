package fr.esgi.artdetective.data.repository

interface ArtRepository {
    fun getGalleryArtworks(page: Int)
    fun toggleFavorite(artworkId: Int)
    fun unlockArtwork(artworkId: Int)
}