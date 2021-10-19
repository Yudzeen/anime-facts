package ebj.habinyasuyujin.animefacts.repository

import ebj.habinyasuyujin.animefacts.models.Anime
import io.reactivex.Completable
import io.reactivex.Flowable

interface AnimeFactsRepository {

    fun getAnimeList(): Flowable<List<Anime>>
    fun refreshAnimeList(): Completable

}