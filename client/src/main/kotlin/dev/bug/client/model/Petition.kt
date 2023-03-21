package dev.bug.client.model

data class Petition(
    override val id: Long,
    override val title: String,
    val geo: Geo,
    val level: Level,
    val status: Status
): IdAndTitle(id, title)
