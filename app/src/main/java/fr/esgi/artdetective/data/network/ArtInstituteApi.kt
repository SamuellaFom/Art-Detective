package fr.esgi.artdetective.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArtInstituteApi {
    @GET("artworks/{id}")
    suspend fun getArtwork(
        @Path("id") id: Int,
        @Query("fields") fields: String = ARTWORK_FIELDS,
    ): ArtworkResponseDto

    companion object {
        const val ARTWORK_FIELDS =
            "id,title,artist_id,artist_title,date_display,style_title,place_of_origin,image_id"
    }
}