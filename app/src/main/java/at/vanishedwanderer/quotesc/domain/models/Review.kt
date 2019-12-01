package at.vanishedwanderer.quotesc.domain.models

data class Review (
    val user: User,
    val quote: Quote,
    val grade: Int
)