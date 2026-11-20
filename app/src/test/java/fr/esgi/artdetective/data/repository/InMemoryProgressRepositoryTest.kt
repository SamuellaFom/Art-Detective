package fr.esgi.artdetective.data.repository

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
class InMemoryProgressRepositoryTest {

    @Test
    fun validateCorrectAnswerAndUnlockArtwork() {
        val repository = InMemoryProgressRepository()
        repository.recordAnswer(artworkId = 42, correct = true, xpEarned = 80)

        val progress = repository.progress.value
        assertEquals(80, progress.xp)
        assertEquals(1, progress.solvedCount)
        assertTrue(42 in progress.unlockedArtworkIds)
    }

    @Test
    fun countIncorrectAnswerAsAttempt() {
        val repository = InMemoryProgressRepository()
        repository.recordAnswer(artworkId = 42, correct = false, xpEarned = 80)

        val progress = repository.progress.value
        assertEquals(0, progress.xp)
        assertEquals(1, progress.attempts)
        assertTrue(progress.unlockedArtworkIds.isEmpty())
    }

    @Test
    fun toggleFavoriteOnDoubleClick() {
        val repository = InMemoryProgressRepository()
        repository.toggleFavorite(42)
        repository.toggleFavorite(42)

        assertTrue(repository.progress.value.favoriteArtworkIds.isEmpty())
    }
}