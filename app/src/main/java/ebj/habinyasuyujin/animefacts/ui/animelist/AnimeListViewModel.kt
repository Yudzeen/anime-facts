package ebj.habinyasuyujin.animefacts.ui.animelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import ebj.habinyasuyujin.animefacts.models.Anime
import ebj.habinyasuyujin.animefacts.repository.AnimeFactsRepository
import ebj.habinyasuyujin.animefacts.utils.Resource
import ebj.habinyasuyujin.animefacts.utils.lifecycle.Event
import ebj.habinyasuyujin.animefacts.utils.lifecycle.RxViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AnimeListViewModel
@Inject internal constructor(
    private val savedStateHandle: SavedStateHandle,
    private val animeFactsRepository: AnimeFactsRepository
): RxViewModel() {

    private val animeList = MutableLiveData<Resource<List<Anime>>>()
    private val refreshAnimeListEvent = MutableLiveData<Event<Resource<Unit>>>()

    init {
        animeFactsRepository.refreshAnimeList()
            .andThen(animeFactsRepository.getAnimeList())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { animeList.value = Resource.Loading() }
            .subscribe ({ animeList.value = Resource.Success(it) },
                { animeList.value = Resource.Error(it) })
            .bind()
    }

    fun getAnimeList(): LiveData<Resource<List<Anime>>> {
        return animeList
    }

    fun refreshAnimeList() {
        animeFactsRepository.refreshAnimeList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { refreshAnimeListEvent.value = Event(Resource.Loading()) }
            .subscribe ({ refreshAnimeListEvent.value = Event(Resource.Success(Unit)) },
                { refreshAnimeListEvent.value = Event(Resource.Error(it)) })
            .bind()

    }


}