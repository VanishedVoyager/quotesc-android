package at.vanishedwanderer.quotesc.domain.models

import java.time.LocalDate

data class Quote (
    val quote: String,
    val quotedPersons: List<Person>,
    val quoter: User,
    val brain: Int,
    val date: LocalDate
)
