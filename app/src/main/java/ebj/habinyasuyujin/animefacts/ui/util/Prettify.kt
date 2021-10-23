package ebj.habinyasuyujin.animefacts.ui.util

object Prettify {

    @JvmStatic
    fun prettifyAnimeName(animeName: String): String {
        return animeName.replace("_", " ").capitalizeWords()
    }

    private fun String.capitalizeWords(): String {
        return split(" ").map { word ->
            word.lowercase().replaceFirstChar { it.uppercase() }
        }.joinToString(" ")
    }

}
