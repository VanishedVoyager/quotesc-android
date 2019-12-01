package at.vanishedwanderer.quotesc.database.entities

import androidx.room.*

@Entity(
    tableName = "Quotesc_Group",
    indices = [Index("name", unique = true)]
)
data class DatabaseGroup (
    var name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}