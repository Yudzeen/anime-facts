package ebj.habinyasuyujin.animefacts.repository.remote

import ebj.habinyasuyujin.animefacts.models.Anime
import io.reactivex.Single

interface RemoteRepository {

    fun fetchAnimeList(): Single<List<Anime>>

}