package fr.esgi.artdetective.ui.gallery

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.esgi.artdetective.domain.model.Artwork
import fr.esgi.artdetective.domain.usecase.GetAllArtworksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ArtworkUiState (
    val artworks: List<Artwork> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class GalleryViewModel(
    private val getAllArtworksUseCase: GetAllArtworksUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(ArtworkUiState());
    val uiState: StateFlow<ArtworkUiState> = _uiState.asStateFlow();

    fun getAll(page: Int = 1, query: String = "", style: String? = null) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val result = getAllArtworksUseCase(page = page, query = query, style = style)
                _uiState.update { it.copy(artworks = result, isLoading = false) }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.localizedMessage ?: "Erreur lors du chargement des œuvres"
                    )
                }
            }
        }
    }


}