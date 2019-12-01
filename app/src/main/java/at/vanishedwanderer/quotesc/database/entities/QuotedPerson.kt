package at.vanishedwanderer.quotesc.database.entities

import androidx.room.*

@Entity(
    tableName = "Quotesc_Person_Quote",
    foreignKeys = [ForeignKey(entity = DatabaseQuote::class, parentColumns = ["id"],
        childColumns = ["quote_id"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = DatabasePerson::class, parentColumns = ["id"],
            childColumns = ["person_id"], onDelete = ForeignKey.CASCADE)],
    indices = [Index("quote_id"),
        Index("person_id")]
)
data class QuotedPerson (
    @ColumnInfo(name = "quote_id")
    var quoteId: Long,
    @ColumnInfo(name = "person_id")
    var personId: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
