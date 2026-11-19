package fr.esgi.artdetective

import fr.esgi.artdetective.data.repository.ArtworkRepository
import fr.esgi.artdetective.data.repository.FakeArtworkRepository
import fr.esgi.artdetective.data.repository.InMemoryProgressRepository
import fr.esgi.artdetective.data.repository.ProgressRepository

class AppContainer {
    val artworkRepository: ArtworkRepository = FakeArtworkRepository()
    val progressRepository: ProgressRepository = InMemoryProgressRepository()
}