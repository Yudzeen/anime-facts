package ebj.habinyasuyujin.animefacts.ui.animelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ebj.habinyasuyujin.animefacts.databinding.ListItemAnimeBinding
import ebj.habinyasuyujin.animefacts.models.Anime

class AnimeListAdapter(): RecyclerView.Adapter<AnimeListAdapter.ViewHolder>() {

    private val animeList = mutableListOf<Anime>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemAnimeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anime = animeList[position]
        holder.bind(anime)
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    fun submitList(newList: List<Anime>) {
        val diffResult = DiffUtil.calculateDiff(DiffCallback(animeList, newList))
        animeList.clear()
        animeList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(
        private val binding: ListItemAnimeBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Anime) {
            binding.apply {
                anime = item
                executePendingBindings()
            }
        }

    }

    class DiffCallback(
        private val oldList: List<Anime>,
        private val newList: List<Anime>
    ): DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }
}