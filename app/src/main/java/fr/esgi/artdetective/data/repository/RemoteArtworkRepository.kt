package fr.esgi.artdetective.data.repository

import fr.esgi.artdetective.data.network.ArtInstituteApi
import fr.esgi.artdetective.data.network.toDomainOrNull
import fr.esgi.artdetective.domain.model.Artist
import fr.esgi.artdetective.domain.model.Artwork

class RemoteArtworkRepository(private val api: ArtInstituteApi): ArtworkRepository {
    override suspend fun getArtworks(
        page: Int,
        query: String,
        style: String?
    ): List<Artwork> {

        val combinedQuery = listOfNotNull(
            query.trim().takeIf { it.isNotEmpty() },
            style?.trim()?.takeIf { it.isNotEmpty() }
        ).joinToString(" ").ifEmpty { null }

        val response = api.getArtworks(
            query = combinedQuery,
            page = page
        )

        return response.data.mapNotNull { it.toDomainOrNull() }
    }

    override suspend fun getArtwork(id: Int): Artwork? {
        return api.getArtwork(id).data?.toDomainOrNull()
    }

    override suspend fun getArtist(id: Int): Artist? {
        TODO("Not yet implemented")
    }

}