package fr.esgi.artdetective.domain.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class PlayerProgressTest {

    @Test
    fun xp1240DonneInspecteur() {
        val progress = PlayerProgress(xp = 1240)
        assertEquals(Rank.INSPECTEUR, progress.rank)
        assertEquals(Rank.COMMISSAIRE, progress.rank.next)
    }

    @Test
    fun nouveauJoueurEstApprenti() {
        assertEquals(Rank.APPRENTI, PlayerProgress().rank)
    }

    @Test
    fun aucuneTentativeDonneZeroPourcent() {
        assertEquals(0, PlayerProgress().successRate)
    }

    @Test
    fun troisSurQuatreDonne75Pourcent() {
        assertEquals(75, PlayerProgress(solvedCount = 3, attempts = 4).successRate)
    }
}