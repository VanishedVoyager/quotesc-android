package at.vanishedwanderer.quotesc.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import at.vanishedwanderer.quotesc.database.daos.*
import at.vanishedwanderer.quotesc.database.entities.*

@Database(entities = [DatabaseGroup::class, DatabaseNickname::class, DatabasePerson::class,
    DatabaseQuote::class, DatabaseReview::class, DatabaseTag::class, DatabaseUser::class,
    GroupMember::class, QuotedPerson::class],
    version = 1)
abstract class QuotescDatabase : RoomDatabase() {
    abstract val groupDao: GroupDao
    abstract val nicknameDao: NicknameDao
    abstract val personDao: PersonDao
    abstract val quoteDao: QuoteDao
    abstract val quotedPersonDao: QuotedPersonDao
    abstract val reviewDao: ReviewDao
    abstract val tagDao: TagDao
    abstract val userDao: UserDao

    companion object {
        private lateinit var INSTANCE: QuotescDatabase

        fun getDatabase(context: Context): QuotescDatabase {
            synchronized(QuotescDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, QuotescDatabase::class.java,
                        "quotesc").build()
                }
            }
            return INSTANCE
        }
    }

}
