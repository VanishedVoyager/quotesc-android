package at.vanishedwanderer.quotesc.database.entities

import androidx.room.*

@Entity(
    tableName = "Quotesc_Person_Group",
    foreignKeys = [ForeignKey(entity = DatabaseQuote::class, parentColumns = ["id"],
        childColumns = ["group_id"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = DatabasePerson::class, parentColumns = ["id"],
            childColumns = ["person_id"], onDelete = ForeignKey.CASCADE)],
    indices = [Index("group_id"),
        Index("person_id")]
)
data class GroupMember (
    @ColumnInfo(name = "group_id")
    var groupId: Long,
    @ColumnInfo(name = "person_id")
    var personId: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
