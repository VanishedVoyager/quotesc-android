package at.vanishedwanderer.quotesc.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import at.vanishedwanderer.quotesc.database.QuotescDatabase
import at.vanishedwanderer.quotesc.database.containers.DatabaseQuoteContainer
import at.vanishedwanderer.quotesc.database.domainmodelconverters.asDomainModel
import at.vanishedwanderer.quotesc.domain.models.Quote
import at.vanishedwanderer.quotesc.network.Network
import at.vanishedwanderer.quotesc.network.containers.GroupDtoContainer
import at.vanishedwanderer.quotesc.network.containers.PersonDtoContainer
import at.vanishedwanderer.quotesc.network.containers.QuoteDtoContainer
import at.vanishedwanderer.quotesc.network.databasemodelconverters.asDatabaseModel
import at.vanishedwanderer.quotesc.network.dtos.GroupDto
import at.vanishedwanderer.quotesc.network.dtos.PersonDto
import at.vanishedwanderer.quotesc.network.dtos.QuoteDto
import at.vanishedwanderer.quotesc.network.dtos.UserDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception

class QuoteRepository (private val database: QuotescDatabase) {

    val quotes: LiveData<List<Quote>> = Transformations.map(database.quoteDao.getAllLiveData()) {
        DatabaseQuoteContainer(it).asDomainModel(database, false)
    }

    suspend fun refreshQuotes() {
        withContext(Dispatchers.IO) {
            try{
                val quoteDtos = Network.quotes.getQuotes().await()
                val personDtos = PersonDtoContainer(quoteDtos.quotes.flatMap {
                    it.quotedPersons
                }.toList())
                val groupDtos = GroupDtoContainer(personDtos.persons.flatMap {
                    it.groups
                }.distinct().toList())

                database.groupDao.insertAll(groupDtos.asDatabaseModel(database))
                database.personDao.insertAll(personDtos.asDatabaseModel(database))
                database.quoteDao.insertAll(quoteDtos.asDatabaseModel(database))
            } catch (e: Exception) {
                Timber.log(5, e.message)
                val networkQuotes = QuoteDtoContainer(listOf(
                    QuoteDto(
                        "Dummy quote",
                        listOf(
                            UserDto(
                                "Florian",
                                "Schwarcz",
                                listOf(
                                    GroupDto(
                                        "5BHIF",
                                        listOf()
                                    )
                                ),
                                "asdf"
                            ),
                            PersonDto(
                                "Erik",
                                "Mayrhofer",
                                listOf(
                                    GroupDto(
                                        "5BHIF",
                                        listOf()
                                    )
                                )
                            )
                        ),
                        UserDto(
                            "Erik",
                            "Mayrhofer",
                            listOf(
                                GroupDto(
                                    "5BHIF",
                                    listOf()
                                )
                            ),
                            "fdsa"
                        ),
                        brain = 10,
                        date = "22.11.2019"
                    )
                ))
                database.quoteDao.insertAll(networkQuotes.asDatabaseModel(database))
            }
        }
    }

}
