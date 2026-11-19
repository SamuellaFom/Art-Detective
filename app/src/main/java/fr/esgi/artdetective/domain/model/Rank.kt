package fr.esgi.artdetective.domain.model

enum class Rank(val level: Int, val title: String, val minXp: Int) {
    APPRENTICE(1, "Apprenti", 0),
    INVESTIGATOR(2, "Enquêteur", 200),
    DETECTIVE(3, "Détective", 500),
    INSPECTOR(4, "Inspecteur", 1000),
    COMMISSAR(5, "Commissaire", 1500),
    LEGEND(6, "Légende", 2500);

    val next: Rank?
        get() = entries.getOrNull(ordinal + 1)

    companion object {
        fun fromXp(xp: Int): Rank = entries.last { xp >= it.minXp }
    }
}
