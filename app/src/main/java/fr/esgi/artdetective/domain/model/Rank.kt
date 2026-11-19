package fr.esgi.artdetective.domain.model

enum class Rank(val level: Int, val title: String, val minXp: Int) {
    APPRENTI(1, "Apprenti", 0),
    ENQUETEUR(2, "Enquêteur", 200),
    DETECTIVE(3, "Détective", 500),
    INSPECTEUR(4, "Inspecteur", 1000),
    COMMISSAIRE(5, "Commissaire", 1500),
    LEGENDE(6, "Légende", 2500);

    val next: Rank?
        get() = entries.getOrNull(ordinal + 1)

    companion object {
        fun fromXp(xp: Int): Rank = entries.last { xp >= it.minXp }
    }
}
