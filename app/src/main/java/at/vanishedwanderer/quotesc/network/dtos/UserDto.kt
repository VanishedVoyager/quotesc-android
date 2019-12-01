package at.vanishedwanderer.quotesc.network.dtos

class UserDto (
    firstName: String,
    lastName: String,
    groups: List<GroupDto>,
    val subject: String
) : PersonDto (
    firstName,
    lastName,
    groups
)