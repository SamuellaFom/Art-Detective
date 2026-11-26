package fr.esgi.artdetective.domain.usecase

import fr.esgi.artdetective.data.repository.ArtworkRepository
import fr.esgi.artdetective.data.repository.ProgressRepository
import fr.esgi.artdetective.domain.model.AnswerResult
import fr.esgi.artdetective.domain.model.Investigation

class StartInvestigationUseCase(private val artworkRepository: ArtworkRepository) {
    suspend operator fun invoke(artworkId: Int): Investigation? {
        val artwork = artworkRepository.getArtwork(artworkId) ?: return null

        val wrongAnswers = artworkRepository.getArtworks()
            .map { it.artistName }
            .distinct()
            .filter { it != artwork.artistName }
            .shuffled()
            .take(WRONG_ANSWERS_COUNT)

        val choices = (wrongAnswers + artwork.artistName).shuffled()
        return Investigation(artwork = artwork, choices = choices)
    }

    companion object {
        const val WRONG_ANSWERS_COUNT = 3
    }
}

class RevealHintUseCase {
    operator fun invoke(investigation: Investigation): Investigation {
        val revealed = minOf(investigation.revealedHints + 1, investigation.hints.size)
        return investigation.copy(revealedHints = revealed)
    }
}

class SubmitAnswerUseCase(private val progressRepository: ProgressRepository) {
    operator fun invoke(investigation: Investigation, answer: String): AnswerResult {
        val correct = answer == investigation.artwork.artistName
        val xp = if (correct) maxOf(BASE_XP - HINT_COST * investigation.revealedHints, 0) else 0

        progressRepository.recordAnswer(investigation.artwork.id, correct, xp)
        return AnswerResult(correct = correct, xpEarned = xp)

    }

    companion object {
        const val BASE_XP = 120
        const val HINT_COST = 20
    }
}