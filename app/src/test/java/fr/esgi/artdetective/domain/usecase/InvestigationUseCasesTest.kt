package fr.esgi.artdetective.domain.usecase

import fr.esgi.artdetective.data.repository.FakeArtworkRepository
import fr.esgi.artdetective.data.repository.InMemoryProgressRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class InvestigationUseCasesTest {
    private val seuratArtworkId = 27992
    private val startInvestigation = StartInvestigationUseCase(FakeArtworkRepository())

    @Test
    fun startCreatesFourDistinctChoicesWithTheRightAnswer() = runBlocking {
        val investigation = startInvestigation(seuratArtworkId)!!

        assertEquals(4, investigation.choices.size)
        assertEquals(4, investigation.choices.distinct().size)
        assertTrue("Georges Seurat" in investigation.choices)
    }

    @Test
    fun startReturnsNullForUnknownArtwork() = runBlocking {
        assertNull(startInvestigation(-1))
    }

    @Test
    fun revealHintStopsAtThree() = runBlocking {
        val reveal = RevealHintUseCase()
        var investigation = startInvestigation(seuratArtworkId)!!

        repeat(5) { investigation = reveal(investigation) }

        assertEquals(3, investigation.revealedHints)
    }

    @Test
    fun rightAnswerWithOneHintGives100Xp() = runBlocking {
        val progress = InMemoryProgressRepository()
        val submit = SubmitAnswerUseCase(progress)
        val investigation = RevealHintUseCase()(startInvestigation(seuratArtworkId)!!)

        val result = submit(investigation, "Georges Seurat")

        assertTrue(result.correct)
        assertEquals(100, result.xpEarned)
        assertEquals(100, progress.progress.value.xp)
    }

    @Test
    fun wrongAnswerGivesNoXp() = runBlocking {
        val progress = InMemoryProgressRepository()
        val result =
            SubmitAnswerUseCase(progress)(startInvestigation(seuratArtworkId)!!, "Claude Monet")

        assertFalse(result.correct)
        assertEquals(0, result.xpEarned)
        assertEquals(1, progress.progress.value.attempts)
    }
}