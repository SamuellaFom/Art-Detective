package fr.esgi.artdetective.data.repository

import fr.esgi.artdetective.domain.model.PlayerProgress
import kotlinx.coroutines.flow.StateFlow

interface ProgressRepository {
    val progress: StateFlow<PlayerProgress>
    fun recordAnswer(artworkId: Int, correct: Boolean, xpEarned: Int)
    fun toggleFavorite(artworkId: Int)
}