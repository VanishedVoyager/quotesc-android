package at.vanishedwanderer.quotesc.network.containers

import at.vanishedwanderer.quotesc.network.dtos.GroupDto
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class GroupDtoContainer(val groups: List<GroupDto>)