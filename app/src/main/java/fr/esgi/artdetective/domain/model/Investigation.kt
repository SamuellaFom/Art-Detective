package fr.esgi.artdetective.domain.model

data class Investigation(
    val artwork: Artwork,
    val choices: List<String>,
    val revealedHints: Int = 0,
) {
    val hints: List<Hint>
        get() = listOf(
            Hint(HintType.ERA, artwork.year),
            Hint(HintType.STYLE, artwork.style),
            Hint(HintType.COUNTRY, artwork.country),
        )
}