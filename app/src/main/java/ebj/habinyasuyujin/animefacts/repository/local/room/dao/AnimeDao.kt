package ebj.habinyasuyujin.animefacts.repository.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ebj.habinyasuyujin.animefacts.repository.local.room.entities.AnimeEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface AnimeDao {

    @Query("SELECT * FROM anime")
    fun getAnimeList(): Flowable<List<AnimeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAnimeList(animeList: List<AnimeEntity>): Completable

    @Query("DELETE FROM anime")
    fun clearAnimeList(): Completable

}