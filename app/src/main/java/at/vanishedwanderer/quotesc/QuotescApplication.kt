package at.vanishedwanderer.quotesc

import android.app.Application
import timber.log.Timber

class QuotescApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}
