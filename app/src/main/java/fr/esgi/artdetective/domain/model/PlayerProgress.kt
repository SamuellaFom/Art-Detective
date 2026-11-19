package fr.esgi.artdetective.domain.model

data class PlayerProgress(
    val xp: Int = 0,
    val solvedCount: Int = 0,
    val attempts: Int = 0,
    val streakDays: Int = 0,
    val unlockedArtworkIds: Set<Int> = emptySet(),
    val favoriteArtworkIds: Set<Int> = emptySet(),
) {
    val rank: Rank
        get() = Rank.fromXp(xp)

    val successRate: Int
        get() = if (attempts == 0) 0 else solvedCount * 100 / attempts
}
