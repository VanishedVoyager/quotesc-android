package at.vanishedwanderer.quotesc.network.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class QuoteDto(
    val quote: String,
    val quotedPersons: List<PersonDto>,
    val quoter: UserDto,
    val brain: Int,
    val date: String
)
