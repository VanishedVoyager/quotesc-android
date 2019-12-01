package at.vanishedwanderer.quotesc.network.services

import at.vanishedwanderer.quotesc.network.containers.QuoteDtoContainer
import at.vanishedwanderer.quotesc.network.dtos.QuoteDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface QuoteService {
    @GET("quotes")
    fun getQuotes(): Deferred<QuoteDtoContainer>
    @GET("quoteoftheday")
    fun getQuoteOfTheDay(): Deferred<QuoteDto>
}