package fr.esgi.artdetective.ui.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.esgi.artdetective.data.repository.ArtworkRepository
import fr.esgi.artdetective.domain.usecase.GetAllArtworksUseCase

@Suppress("UNCHECKED_CAST")
class GalleryViewModelFactory(private val repository: ArtworkRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass.isAssignableFrom(GalleryViewModel::class.java))
        return GalleryViewModel(
            getAllArtworksUseCase = GetAllArtworksUseCase(repository)
        ) as T
    }
}