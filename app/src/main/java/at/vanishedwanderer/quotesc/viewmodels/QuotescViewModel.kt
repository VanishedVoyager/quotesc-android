package at.vanishedwanderer.quotesc.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import at.vanishedwanderer.quotesc.database.QuotescDatabase.Companion.getDatabase
import at.vanishedwanderer.quotesc.repository.QuoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class QuotescViewModel(application: Application) : AndroidViewModel(application) {

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val database = getDatabase(application)
    private val quoteRepository = QuoteRepository(database)

    init {
        viewModelScope.launch {
            quoteRepository.refreshQuotes()
        }
    }

    val quotes = quoteRepository.quotes

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(QuotescViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return QuotescViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }

    }
}
