package at.vanishedwanderer.quotesc.network.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReviewDto (
    val user: UserDto,
    val quote: QuoteDto,
    val grade: Int
)