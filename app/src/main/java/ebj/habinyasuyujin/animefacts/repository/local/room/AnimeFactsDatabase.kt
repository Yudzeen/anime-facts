package ebj.habinyasuyujin.animefacts.repository.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ebj.habinyasuyujin.animefacts.repository.local.room.dao.AnimeDao
import ebj.habinyasuyujin.animefacts.repository.local.room.entities.AnimeEntity

@Database(entities = [AnimeEntity::class], version = 1, exportSchema = false)
abstract class AnimeFactsDatabase: RoomDatabase() {

    abstract fun animeFactsDao(): AnimeDao

    companion object {
        private const val DB_NAME = "anime-facts-db"

        @Volatile private var instance: AnimeFactsDatabase? = null

        fun getInstance(context: Context): AnimeFactsDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AnimeFactsDatabase {
            return Room.databaseBuilder(context, AnimeFactsDatabase::class.java, DB_NAME)
                .build()
        }
    }
}