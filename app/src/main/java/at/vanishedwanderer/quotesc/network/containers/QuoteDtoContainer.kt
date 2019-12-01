package at.vanishedwanderer.quotesc.network.containers

import at.vanishedwanderer.quotesc.network.dtos.QuoteDto
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class QuoteDtoContainer(val quotes: List<QuoteDto>)
