package at.vanishedwanderer.quotesc.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import at.vanishedwanderer.quotesc.database.QuotescDatabase.Companion.getDatabase
import at.vanishedwanderer.quotesc.repository.QuoteRepository
import retrofit2.HttpException

class RefreshQuotesWorker(appContext: Context, params: WorkerParameters)
    : CoroutineWorker (appContext, params) {

    override suspend fun doWork(): Result {
        val database = getDatabase(applicationContext)
        val repository = QuoteRepository(database)

        return try {
            repository.refreshQuotes()
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }

    companion object {
        const val WORK_NAME = "RegreshQuotesWorker"
    }
}
