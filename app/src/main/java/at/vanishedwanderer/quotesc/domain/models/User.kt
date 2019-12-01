package at.vanishedwanderer.quotesc.domain.models

class User (
    firstName: String,
    lastName: String,
    groups: List<Group>,
    val subject: String
) : Person (
    firstName,
    lastName,
    groups
)