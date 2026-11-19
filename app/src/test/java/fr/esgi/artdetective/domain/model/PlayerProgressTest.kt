package fr.esgi.artdetective.domain.model

import org.junit.Test
import org.junit.Assert.assertEquals

class PlayerProgressTest {

    @Test
    fun xp1240IsInspector() {
        val progress = PlayerProgress(xp = 1240)
        assertEquals(Rank.INSPECTOR, progress.rank)
        assertEquals(Rank.SUPERINTENDENT, progress.rank.next)
    }

    @Test
    fun newPlayerIsApprentice() {
        assertEquals(Rank.APPRENTICE, PlayerProgress().rank)
    }

    @Test
    fun noAttemptGivesZeroPercent() {
        assertEquals(0, PlayerProgress().successRate)
    }

    @Test
    fun threeOutOfFourGives75Percent() {
        assertEquals(75, PlayerProgress(solvedCount = 3, attempts = 4).successRate)
    }
}