package fr.esgi.artdetective.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArtInstituteApi {

    @GET("artworks/search")
    suspend fun getArtworks(
        @Query("q") query: String? = null,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20,
        @Query("query[bool][must][][term][is_public_domain]") isPublicDomain: Boolean = true,
        @Query("query[bool][must][][term][artwork_type_title.keyword]") type: String = "Painting",
        @Query("query[bool][must][][exists][field]") requiredField: String = "image_id",
        @Query("fields") fields: String = ARTWORK_FIELDS
    ): ArtworksResponseDto

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