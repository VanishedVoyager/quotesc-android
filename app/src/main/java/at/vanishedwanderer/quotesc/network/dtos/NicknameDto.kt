package at.vanishedwanderer.quotesc.network.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NicknameDto (
    val text: String
)