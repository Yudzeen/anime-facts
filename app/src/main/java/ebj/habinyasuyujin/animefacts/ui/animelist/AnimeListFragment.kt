package ebj.habinyasuyujin.animefacts.ui.animelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ebj.habinyasuyujin.animefacts.databinding.FragmentAnimeListBinding
import ebj.habinyasuyujin.animefacts.models.Anime
import ebj.habinyasuyujin.animefacts.utils.Resource
import timber.log.Timber

@AndroidEntryPoint
class AnimeListFragment: Fragment() {

    private lateinit var binding: FragmentAnimeListBinding
    private val viewModel: AnimeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getAnimeList().observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Loading -> handleGetAnimeListLoading()
                is Resource.Success -> handleGetAnimeListSuccess(it.data)
                is Resource.Error -> handleGetAnimeListError(it.error)
            }
        })
    }

    private fun handleGetAnimeListLoading() {
        Timber.d("Loading...")
    }

    private fun handleGetAnimeListSuccess(animeList: List<Anime>) {
        Timber.i("List loaded: $animeList")
    }

    private fun handleGetAnimeListError(error: Throwable) {
        Timber.e(error)
    }
}