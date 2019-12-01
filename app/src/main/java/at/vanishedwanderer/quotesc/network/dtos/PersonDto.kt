package at.vanishedwanderer.quotesc.network.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class PersonDto(
    val firstName: String,
    val lastName: String,
    val groups: List<GroupDto>
)
