package at.vanishedwanderer.quotesc.network.containers

import at.vanishedwanderer.quotesc.network.dtos.PersonDto
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class PersonDtoContainer(val persons: List<PersonDto>)
