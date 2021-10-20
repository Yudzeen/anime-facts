package ebj.habinyasuyujin.animefacts.repository.remote

import ebj.habinyasuyujin.animefacts.api.AnimeFactsService
import ebj.habinyasuyujin.animefacts.models.Anime
import ebj.habinyasuyujin.animefacts.utils.filter.AnimeFilter
import io.reactivex.Single

class RemoteRepositoryImpl(
    private val animeFactsService: AnimeFactsService
): RemoteRepository {

    override fun fetchAnimeList(): Single<List<Anime>> {
        return animeFactsService.getAnimeList()
            .map { response -> response.data.map { Anime(it.id, it.name, it.imageUrl) } }
            .map { list -> list.filter { anime -> !AnimeFilter.animeBlocklist.contains(anime.name) } }
    }

}