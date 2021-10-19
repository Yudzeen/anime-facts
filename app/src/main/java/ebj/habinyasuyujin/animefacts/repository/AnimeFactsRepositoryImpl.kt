package ebj.habinyasuyujin.animefacts.repository

import ebj.habinyasuyujin.animefacts.models.Anime
import ebj.habinyasuyujin.animefacts.repository.local.LocalRepository
import ebj.habinyasuyujin.animefacts.repository.remote.RemoteRepository
import io.reactivex.Completable
import io.reactivex.Flowable

class AnimeFactsRepositoryImpl(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository
): AnimeFactsRepository {

    override fun getAnimeList(): Flowable<List<Anime>> {
        return localRepository.getAnimeList()
    }

    override fun refreshAnimeList(): Completable {
        return remoteRepository.fetchAnimeList()
            .flatMapCompletable { localRepository.clearAnimeList()
                .andThen(localRepository.insertAnimeList(it))
            }
    }



}