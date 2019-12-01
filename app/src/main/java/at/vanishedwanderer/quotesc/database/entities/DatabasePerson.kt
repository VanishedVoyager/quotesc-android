package at.vanishedwanderer.quotesc.database.entities

import androidx.room.*

@Entity(
    tableName = "Quotesc_Person",
    indices = [Index(value = ["first_name", "last_name"], unique = true)]
)
open class DatabasePerson (
    @ColumnInfo(name = "first_name")
    var firstName: String,
    @ColumnInfo(name = "last_name")
    var lastName: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}