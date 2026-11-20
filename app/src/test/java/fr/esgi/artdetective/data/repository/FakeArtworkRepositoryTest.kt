package fr.esgi.artdetective.data.repository

import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.assertTrue

class FakeArtworkRepositoryTest {

    @Test
    fun searchIgnoresCase() = runBlocking {
        val results = FakeArtworkRepository().getArtworks(query = "seurat")
        assertTrue(results.isNotEmpty())
        assertTrue(results.all { it.artistName.contains("Seurat") })
    }
}