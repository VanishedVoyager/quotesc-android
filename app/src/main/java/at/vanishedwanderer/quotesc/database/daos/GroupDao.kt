package at.vanishedwanderer.quotesc.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import at.vanishedwanderer.quotesc.database.entities.DatabaseGroup

@Dao
interface GroupDao {
    @Query("select * from Quotesc_Group where id in (select group_id from Quotesc_Person_Group where person_id = :id)")
    fun getByPersonId(id: Long): List<DatabaseGroup>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(group: DatabaseGroup): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(groups: List<DatabaseGroup>): List<Long>
}
