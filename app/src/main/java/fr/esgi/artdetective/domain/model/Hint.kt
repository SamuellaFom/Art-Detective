package fr.esgi.artdetective.domain.model

enum class HintType(val label: String) {
    ERA("Époque"),
    STYLE("Style"),
    COUNTRY("Pays"),
}

data class Hint(
    val type: HintType,
    val value: String
)