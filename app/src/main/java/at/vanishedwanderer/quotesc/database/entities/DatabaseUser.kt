package at.vanishedwanderer.quotesc.database.entities

import androidx.room.Entity
import androidx.room.Index
import at.vanishedwanderer.quotesc.domain.models.Group

@Entity(
    tableName = "Quotesc_User",
    indices = [Index("subject", unique = true),
        Index(value = ["first_name", "last_name"], unique = true)]
)
class DatabaseUser (
    firstName: String,
    lastName: String,
    var subject: String
) : DatabasePerson (
    firstName,
    lastName
)
