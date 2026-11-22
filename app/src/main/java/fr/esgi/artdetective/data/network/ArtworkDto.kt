package fr.esgi.artdetective.data.network

import com.google.gson.annotations.SerializedName
import fr.esgi.artdetective.domain.model.Artwork

data class ArtworkResponseDto(
    val data: ArtworkDto?
)

data class ArtworkDto(
    val id: Int?,
    val title: String?,
    @SerializedName("artist_id") val artistId: Int?,
    @SerializedName("artist_title") val artistTitle: String?,
    @SerializedName("date_display") val dateDisplay: String?,
    @SerializedName("style_title") val styleTitle: String?,
    @SerializedName("place_of_origin") val placeOfOrigin: String?,
    @SerializedName("image_id") val imageId: String?,
)

fun ArtworkDto.toDomainOrNull(): Artwork? {
    val validId = id ?: return null
    val validTitle = title?.trim()?.takeIf { it.isNotEmpty() } ?: return null
    val validArtistId = artistId ?: return null
    val validImageId = imageId ?: return null

    return Artwork(
        id = validId,
        title = validTitle,
        artistId = validArtistId,
        artistName = artistTitle ?: "Unknown artist",
        year = dateDisplay ?: "Unknown date",
        style = styleTitle ?: "Unknown style",
        country = placeOfOrigin ?: "Unknown country",
        imageUrl = imageUrlFor(validImageId)
    )
}

fun imageUrlFor(imageId: String): String =
    "https://www.artic.edu/iiif/2/$imageId/full/843,/0/default.jpg"