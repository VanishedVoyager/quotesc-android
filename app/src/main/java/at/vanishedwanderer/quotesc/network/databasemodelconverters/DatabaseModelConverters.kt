package at.vanishedwanderer.quotesc.network.databasemodelconverters

import at.vanishedwanderer.quotesc.database.QuotescDatabase
import at.vanishedwanderer.quotesc.database.entities.DatabaseGroup
import at.vanishedwanderer.quotesc.database.entities.DatabasePerson
import at.vanishedwanderer.quotesc.database.entities.DatabaseQuote
import at.vanishedwanderer.quotesc.database.entities.DatabaseUser
import at.vanishedwanderer.quotesc.network.containers.GroupDtoContainer
import at.vanishedwanderer.quotesc.network.containers.PersonDtoContainer
import at.vanishedwanderer.quotesc.network.containers.QuoteDtoContainer
import at.vanishedwanderer.quotesc.network.dtos.GroupDto
import at.vanishedwanderer.quotesc.network.dtos.PersonDto
import at.vanishedwanderer.quotesc.network.dtos.QuoteDto
import at.vanishedwanderer.quotesc.network.dtos.UserDto
import java.time.format.DateTimeFormatter

fun PersonDto.asDatabaseModel(): DatabasePerson {
    return DatabasePerson(
        firstName = this.firstName,
        lastName = this.firstName
    )
}

fun QuoteDto.asDatabaseModel(database: QuotescDatabase): DatabaseQuote {
    return DatabaseQuote(
        quote = this.quote,
        userId = database.userDao.insert(this.quoter
            .asDatabaseModel()),
        brain = this.brain,
        date = this.date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
    )
}

fun UserDto.asDatabaseModel(): DatabaseUser {
    return DatabaseUser(
        firstName = this.firstName,
        lastName = this.lastName,
        subject = this.subject
    )
}

fun GroupDto.asDatabaseModel(): DatabaseGroup {
    return DatabaseGroup(
        name = this.name
    )
}

fun GroupDtoContainer.asDatabaseModel(database: QuotescDatabase): List<DatabaseGroup> {
    return groups.map {
        it.asDatabaseModel()
    }
}

fun PersonDtoContainer.asDatabaseModel(database: QuotescDatabase): List<DatabasePerson> {
    return persons.map {
        it.asDatabaseModel()
    }
}

fun QuoteDtoContainer.asDatabaseModel(database: QuotescDatabase): List<DatabaseQuote> {
    return quotes.map {
        it.asDatabaseModel(database)
    }
}
