package ebj.habinyasuyujin.animefacts.repository.local

import ebj.habinyasuyujin.animefacts.models.Anime
import io.reactivex.Completable
import io.reactivex.Flowable

interface LocalRepository {

    fun getAnimeList(): Flowable<List<Anime>>
    fun insertAnimeList(animeList: List<Anime>): Completable
    fun clearAnimeList(): Completable

}