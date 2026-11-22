package fr.esgi.artdetective.data.network

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import org.junit.Test

class ArtworkDtoTest {
    private val completeDto = ArtworkDto(
        id = 27992,
        title = "  A Sunday on La Grande Jatte  ",
        artistId = 40810,
        artistTitle = "Georges Seurat",
        dateDisplay = "1884–86",
        styleTitle = "Pointillism",
        placeOfOrigin = "France",
        imageId = "abc",
    )

    @Test
    fun mapsCompleteDtoToArtwork() {
        val artwork = completeDto.toDomainOrNull()

        assertEquals(27992, artwork?.id)
        assertEquals("A Sunday on La Grande Jatte", artwork?.title)
        assertEquals("Georges Seurat", artwork?.artistName)
        assertEquals("https://www.artic.edu/iiif/2/abc/full/843,/0/default.jpg", artwork?.imageUrl)
    }

    @Test
    fun ignoresArtworkWithoutImage() {
        assertNull(completeDto.copy(imageId = null).toDomainOrNull())
    }

    @Test
    fun ignoresArtworkWithBlankTitle() {
        assertNull(completeDto.copy(title = "   ").toDomainOrNull())
    }

    @Test
    fun usesFallbackWhenStyleIsMissing() {
        assertEquals("Style inconnu", completeDto.copy(styleTitle = null).toDomainOrNull()?.style)
    }
}