package ebj.habinyasuyujin.animefacts.utils.filter

import ebj.habinyasuyujin.animefacts.models.Anime

object AnimeFilter {

    /**
     * Blocking below anime as the public api has errors on them
     */
    val animeBlocklist = listOf(
        "dragon_ball",
        "itachi_uchiha"
    )

    @JvmStatic
    fun sortByName(animeList: List<Anime>): List<Anime> {
        return animeList.sortedBy { it.name }
    }

}