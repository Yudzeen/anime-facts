package ebj.habinyasuyujin.animefacts.repository.local.utils

import ebj.habinyasuyujin.animefacts.models.Anime
import ebj.habinyasuyujin.animefacts.repository.local.room.entities.AnimeEntity

fun AnimeEntity.toModel(): Anime {
    return Anime(id, name, imageUrl)
}

fun Anime.toEntity(): AnimeEntity {
    return AnimeEntity(id, name, imageUrl)
}