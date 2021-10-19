package ebj.habinyasuyujin.animefacts.repository.local

import ebj.habinyasuyujin.animefacts.models.Anime
import ebj.habinyasuyujin.animefacts.repository.local.room.AnimeFactsDatabase
import ebj.habinyasuyujin.animefacts.repository.local.utils.toEntity
import ebj.habinyasuyujin.animefacts.repository.local.utils.toModel
import io.reactivex.Completable
import io.reactivex.Flowable

class LocalRepositoryImpl(
    private val animeFactsDatabase: AnimeFactsDatabase
): LocalRepository {
    override fun getAnimeList(): Flowable<List<Anime>> {
        return animeFactsDatabase.animeFactsDao().getAnimeList()
            .map { animeEntities -> animeEntities.map { it.toModel() } }
    }

    override fun insertAnimeList(animeList: List<Anime>): Completable {
        return animeFactsDatabase.animeFactsDao().insertAnimeList(animeList.map { it.toEntity() })
    }

    override fun clearAnimeList(): Completable {
        return animeFactsDatabase.animeFactsDao().clearAnimeList()
    }
}