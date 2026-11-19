package fr.esgi.artdetective.data.repository

import fr.esgi.artdetective.domain.model.Artist
import fr.esgi.artdetective.domain.model.Artwork

class FakeArtworkRepository : ArtworkRepository {
    private val artworks = listOf<Artwork>(
        Artwork(
            id = 6565,
            title = "American Gothic",
            artistId = 37343,
            artistName = "Grant Wood",
            year = "1930",
            style = "Realism",
            country = "Cedar Rapids",
            imageUrl = image("b272df73-a965-ac37-4172-be4e99483637")
        ),
        Artwork(
            id = 27992,
            title = "A Sunday on La Grande Jatte — 1884",
            year = "1884–86,",
            country = "France",
            artistId = 40810,
             artistName = "Georges Seurat",
            style = "Pointillism",
            imageUrl = image("2d484387-2509-5e8e-2c43-22f9981972eb")
        ),
        Artwork(
            id = 16568,
            title = "Water Lilies",
            year = "1906",
            country = "France",
            artistId = 35809,
            artistName = "Claude Monet",
            style = "Impressionism",
            imageUrl = image("3c27b499-af56-f0d5-93b5-a7f2f1ad5813")
        ),
        Artwork(
            id = 28560,
            title = "The Bedroom",
            year = "1889",
            country = "Saint-Rémy-de-Provence",
            artistId = 40610,
             artistName = "Vincent van Gogh",
            style = "Post-Impressionism",
            imageUrl = image("6644829f-f292-c5c4-a73c-0356a6fdbf0d")
        ),
        Artwork(
            id = 20684,
            title = "Paris Street; Rainy Day",
            year = "1877",
            country = "Paris",
            artistId = 3829,
             artistName = "Gustave Caillebotte",
            style = "Impressionism",
            imageUrl = image("f8fd76e9-c396-5678-36ed-6a348c904d27")
        ),
        Artwork(
            id = 28067,
            title = "The Old Guitarist",
            year = "late 1903–early 1904",
            country = "Spain",
            artistId = 36198,
            artistName = "Pablo Picasso",
            style = "Blue period",
            imageUrl = image("4e7f3081-179a-af18-8abd-7908a7ae8c4e")
        ),
        Artwork(
            id = 111442,
            title = "The Child's Bath",
            year = "1893",
            country = "France",
            artistId = 33890,
             artistName = "Mary Cassatt",
            style = "Impressionism",
            imageUrl = image("3b885ae0-4d46-5fe4-d70a-00474827f02c")
        ),
        Artwork(
            id = 80607,
            title = "Self-Portrait",
            year = "1887",
            country = "Netherlands",
            artistId = 40610,
             artistName = "Vincent van Gogh",
            style = "Post-Impressionism",
            imageUrl = image("47c5bcb8-62ef-e5d7-55e7-f5121f409a30")
        ),
        Artwork(
            id = 111628,
            title = "Nighthawks",
            year = "1942",
            country = "United States",
            artistId = 34996,
             artistName = "Edward Hopper",
            style = "Modernism",
            imageUrl = image("831a05de-d3f6-f4fa-a460-23008dd58dda")
        ),
        Artwork(
            id = 61128,
            title = "At the Moulin Rouge",
            year = "1892–95",
            country = "France",
            artistId = 40869,
             artistName = "Henri de Toulouse-Lautrec",
            style = "Post-Impressionism",
            imageUrl = image("defb4004-b500-218d-3d9b-9a02423f097d")
        )
    )
    private val artists = listOf<Artist>(
        Artist(
            id = 36198,
            fullName = "Pablo Picasso",
            birthDeathYears = "1881 - 1973",
            origin = "Espagnol",
            shortBio = "…"
        ),
        Artist(
            id = 34996,
            fullName = "Edward Hopper",
            birthDeathYears = "1882 - 1967",
            origin = "Américain",
            shortBio = "…"
        ),
        Artist(
            id = 34996,
            fullName = "Grant Wood",
            birthDeathYears = "1882 - 1942",
            origin = "Américain",
            shortBio = "…"
        ),
    )

    override suspend fun getArtworks(page: Int, query: String, style: String?): List<Artwork> =
        artworks.filter { artwork ->
            val matchesQuery = query.isBlank() ||
                    artwork.title.contains(query, ignoreCase = true) ||
                    artwork.artistName.contains(query, ignoreCase = true)
            val matchesStyle = style == null || artwork.style == style
            matchesQuery && matchesStyle
        }

    override suspend fun getArtwork(id: Int): Artwork? = artworks.firstOrNull { it.id == id }

    override suspend fun getArtist(id: Int): Artist? = artists.firstOrNull { it.id == id }

    private fun image(imageId: String) =
        "https://www.artic.edu/iiif/2/$imageId/full/843,/0/default.jpg"
}