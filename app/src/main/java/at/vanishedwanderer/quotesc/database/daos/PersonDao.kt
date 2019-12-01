package at.vanishedwanderer.quotesc.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import at.vanishedwanderer.quotesc.database.entities.DatabasePerson

@Dao
interface PersonDao {
    @Query("select * from Quotesc_Person where id in (select person_id from Quotesc_Person_Quote where quote_id = :id)")
    fun getByQuoteId(id: Long): List<DatabasePerson>
    @Query("select * from Quotesc_Person where id in (select person_id from Quotesc_Person_Group where group_id = :id)")
    fun getByGroupId(id: Long): List<DatabasePerson>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(quotes: List<DatabasePerson>): List<Long>
}
