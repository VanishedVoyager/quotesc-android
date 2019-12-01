package at.vanishedwanderer.quotesc.database.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Quotesc_Tag",
    indices = [Index("name", unique = true)]
)
data class DatabaseTag (
    var name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}