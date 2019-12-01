package at.vanishedwanderer.quotesc.database.entities

import androidx.room.*

@Entity(
    tableName = "Quotesc_Quote",
    foreignKeys = [ForeignKey(entity = DatabaseUser::class, parentColumns = ["id"],
        childColumns = ["user_id"], onDelete = ForeignKey.RESTRICT)],
    indices = [Index("user_id")]
)
data class DatabaseQuote (
    var quote: String,
    @ColumnInfo(name = "user_id")
    var userId: Long,
    var brain: Int,
    var date: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
