package fr.esgi.artdetective.domain.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class PlayerProgressTest {

    @Test
    fun xp1240InspectorGiver() {
        val progress = PlayerProgress(xp = 1240)
        assertEquals(Rank.INSPECTOR, progress.rank)
        assertEquals(Rank.COMMISSAR, progress.rank.next)
    }

    @Test
    fun newPlayerIsApprentice() {
        assertEquals(Rank.APPRENTICE, PlayerProgress().rank)
    }

    @Test
    fun NoAttemptGiveZeroPercent() {
        assertEquals(0, PlayerProgress().successRate)
    }

    @Test
    fun ThreeOutOfFourGives75Percent() {
        assertEquals(75, PlayerProgress(solvedCount = 3, attempts = 4).successRate)
    }
}