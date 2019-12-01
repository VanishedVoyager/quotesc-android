package at.vanishedwanderer.quotesc.database.entities

import androidx.room.*

@Entity(
    foreignKeys = [ForeignKey(entity = DatabaseUser::class, parentColumns = ["id"],
        childColumns = ["user_id"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = DatabaseQuote::class, parentColumns = ["id"],
            childColumns = ["quote_id"], onDelete = ForeignKey.CASCADE)],
    indices = [Index(value = ["user_id", "quote_id"], unique = true),
        Index("quote_id")]
)
data class DatabaseReview(
    @ColumnInfo(name = "user_id")
    var userId: Long,
    @ColumnInfo(name = "quote_id")
    var quoteId: Long,
    var grade: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}