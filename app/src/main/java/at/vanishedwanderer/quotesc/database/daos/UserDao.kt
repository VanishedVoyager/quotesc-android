package at.vanishedwanderer.quotesc.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import at.vanishedwanderer.quotesc.database.entities.DatabaseUser

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: DatabaseUser): Long
    @Query("select * from Quotesc_User where id = :id")
    fun getById(id: Long): DatabaseUser
}
