package fr.esgi.artdetective.data.repository

import fr.esgi.artdetective.domain.model.PlayerProgress
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class InMemoryProgressRepository(
    initial: PlayerProgress = PlayerProgress(),
) : ProgressRepository {

    private val _progress = MutableStateFlow(initial)
    override val progress: StateFlow<PlayerProgress> = _progress.asStateFlow()

    override fun recordAnswer(artworkId: Int, correct: Boolean, xpEarned: Int) {
        _progress.update { current ->
            if (correct) {
                current.copy(
                    xp = current.xp + xpEarned,
                    solvedCount = current.solvedCount + 1,
                    attempts = current.attempts + 1,
                    unlockedArtworkIds = current.unlockedArtworkIds + artworkId,
                )
            } else {
                current.copy(attempts = current.attempts + 1)
            }
        }
    }

    override fun toggleFavorite(artworkId: Int) {
        _progress.update { current ->
            val favorites = if (artworkId in current.favoriteArtworkIds) {
                current.favoriteArtworkIds - artworkId
            } else {
                current.favoriteArtworkIds + artworkId
            }
            current.copy(favoriteArtworkIds = favorites)
        }
    }
}