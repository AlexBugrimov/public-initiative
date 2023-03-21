package dev.bug.client.model

data class Level(override val id: Long, override val title: String) : IdAndTitle(id, title)
