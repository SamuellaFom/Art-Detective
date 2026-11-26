package fr.esgi.artdetective.domain.usecase

import fr.esgi.artdetective.data.repository.ArtworkRepository
import fr.esgi.artdetective.domain.model.Artwork

class GetAllArtworksUseCase(private val repository: ArtworkRepository) {
        suspend operator fun invoke(
            page: Int = 1,
            query: String = "",
            style: String? = null
        ): List<Artwork> = repository.getArtworks(page = page, query = query, style = style)
}