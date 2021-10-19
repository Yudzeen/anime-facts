package ebj.habinyasuyujin.animefacts.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AnimeFactsListResponse (
    @field:Json(name="success") val success: Boolean,
    @field:Json(name="data") val data: List<AnimeFactsAnime>,
) {
    @JsonClass(generateAdapter = true)
    data class AnimeFactsAnime (
        @field:Json(name="anime_id") val id: Int,
        @field:Json(name="anime_name") val name: String,
        @field:Json(name="anime_img") val imageUrl: String,
    )
}
