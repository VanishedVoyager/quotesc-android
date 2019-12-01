package at.vanishedwanderer.quotesc.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import at.vanishedwanderer.quotesc.database.entities.DatabaseQuote

@Dao
interface QuoteDao {
    @Query("select * from Quotesc_quote")
    fun getAll(): List<DatabaseQuote>
    @Query("select * from Quotesc_quote")
    fun getAllLiveData(): LiveData<List<DatabaseQuote>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(quotes: List<DatabaseQuote>): List<Long>
}
