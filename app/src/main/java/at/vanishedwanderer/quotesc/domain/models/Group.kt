package at.vanishedwanderer.quotesc.domain.models

data class Group(
    val name: String,
    val members: List<Person>
)