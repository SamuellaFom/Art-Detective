package fr.esgi.artdetective.data.network

import org.junit.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Ignore
import org.junit.Test

@Ignore("Calls the real API: to be launched manually")
class ArtInstituteApiCheck {
    @Test
    fun fetchesLaGrandeJatte() = runBlocking {
        val artwork = ArtInstituteClient.create().getArtwork(27992).data?.toDomainOrNull()

        println(artwork)
        assertEquals("Georges Seurat", artwork?.artistName)
    }
}