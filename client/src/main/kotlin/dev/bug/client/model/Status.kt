package dev.bug.client.model

data class Status(override val id: Long, override val title: String) : IdAndTitle(id, title)
