package ebj.habinyasuyujin.animefacts.repository.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime")
data class AnimeEntity (
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String,
)