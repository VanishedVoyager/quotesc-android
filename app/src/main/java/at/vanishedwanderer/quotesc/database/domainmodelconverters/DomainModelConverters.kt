package at.vanishedwanderer.quotesc.database.domainmodelconverters

import at.vanishedwanderer.quotesc.database.QuotescDatabase
import at.vanishedwanderer.quotesc.database.containers.DatabaseGroupContainer
import at.vanishedwanderer.quotesc.database.containers.DatabasePersonContainer
import at.vanishedwanderer.quotesc.database.containers.DatabaseQuoteContainer
import at.vanishedwanderer.quotesc.database.entities.DatabaseGroup
import at.vanishedwanderer.quotesc.database.entities.DatabasePerson
import at.vanishedwanderer.quotesc.database.entities.DatabaseQuote
import at.vanishedwanderer.quotesc.database.entities.DatabaseUser
import at.vanishedwanderer.quotesc.domain.models.Group
import at.vanishedwanderer.quotesc.domain.models.Person
import at.vanishedwanderer.quotesc.domain.models.Quote
import at.vanishedwanderer.quotesc.domain.models.User
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun DatabaseQuote.asDomainModel(database: QuotescDatabase, fromPerson: Boolean): Quote {
    return Quote(
        quote = this.quote,
        quotedPersons = if (!fromPerson) DatabasePersonContainer(database.personDao.getByQuoteId(this.id))
            .asDomainModel(database, true) else listOf(),
        quoter = database.userDao.getById(this.userId)
            .asDomainModel(database),
        brain = this.brain,
        date = LocalDate.parse(this.date, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
    )
}

fun DatabaseUser.asDomainModel(database: QuotescDatabase): User {
    return User(
        firstName = this.firstName,
        lastName = this.lastName,
        groups = DatabaseGroupContainer(database.groupDao.getByPersonId(this.id))
            .asDomainModel(database, true),
        subject = this.subject
    )
}

fun DatabaseGroup.asDomainModel(database: QuotescDatabase, fromPerson: Boolean): Group {
    return Group(
        name = this.name,
        members = if (!fromPerson) DatabasePersonContainer(database.personDao.getByGroupId(this.id))
            .asDomainModel(database, true) else listOf()
    )
}

fun DatabasePerson.asDomainModel(database: QuotescDatabase, fromGroup: Boolean): Person {
    return Person(
        firstName = this.firstName,
        lastName = this.lastName,
        groups = if (!fromGroup) DatabaseGroupContainer(database.groupDao.getByPersonId(this.id))
            .asDomainModel(database, true) else listOf()
    )
}

fun DatabaseGroupContainer.asDomainModel(database: QuotescDatabase, fromPerson: Boolean): List<Group> {
    return groups.map {
        it.asDomainModel(database, fromPerson)
    }
}

fun DatabaseQuoteContainer.asDomainModel(database: QuotescDatabase, fromPerson: Boolean): List<Quote> {
    return quotes.map {
        it.asDomainModel(database, fromPerson)
    }
}

fun DatabasePersonContainer.asDomainModel(database: QuotescDatabase, fromGroup: Boolean): List<Person> {
    return persons.map {
        it.asDomainModel(database, fromGroup)
    }
}
