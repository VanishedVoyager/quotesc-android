package at.vanishedwanderer.quotesc.network.services

import at.vanishedwanderer.quotesc.network.containers.PersonDtoContainer
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface PersonServices {
    @GET("persons")
    fun getPersons(): Deferred<PersonDtoContainer>
}