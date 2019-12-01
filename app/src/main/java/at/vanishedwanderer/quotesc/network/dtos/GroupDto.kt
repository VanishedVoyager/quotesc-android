package at.vanishedwanderer.quotesc.network.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GroupDto (
    val name: String,
    val members: List<PersonDto>
)