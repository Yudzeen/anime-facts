package ebj.habinyasuyujin.animefacts.repository.remote

import ebj.habinyasuyujin.animefacts.api.AnimeFactsApi
import ebj.habinyasuyujin.animefacts.models.Anime
import io.reactivex.Single

class RemoteRepositoryImpl(
    private val animeFactsApi: AnimeFactsApi
): RemoteRepository {

    override fun fetchAnimeList(): Single<List<Anime>> {
        return animeFactsApi.getAnimeList()
            .map { response -> response.data.map { Anime(it.id, it.name, it.imageUrl) } }
    }

}