package at.vanishedwanderer.quotesc.database.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Quotesc_Nickname",
    indices = [Index("text", unique = true)]
)
data class DatabaseNickname (
    var text: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}